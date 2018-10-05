package CodeForFuture.AutoCode.Controller.DAO;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import CodeForFuture.AutoCode.Service.FileService;
import CodeForFuture.AutoCode.Service.GeneratorCode;
import CodeForFuture.AutoCode.Service.Impl.StatisticsServiceImpl;
import CodeForFuture.AutoCode.entity.DataSourceInfo;
import CodeForFuture.AutoCode.entity.Statistics;
import CodeForFuture.AutoCode.entity.Table;

@Controller
public class DataSourceController {

	private final static Logger logger =  Logger.getLogger(DataSourceController.class);
	
	@Autowired
	private DataSourceInfo dsi;
	
	@Autowired
	private GeneratorCode gecd;
	
	@Autowired
	private FileService fs;
	
	@Autowired
	private StatisticsServiceImpl iss;
	
	@GetMapping("/gettables")
	@ResponseBody
	public String getTables(HttpSession session) {

		List<Table> tables = new ArrayList<Table>();

		InputStream fis = DataSourceController.class.getClassLoader().getResourceAsStream("data.properties");

		Properties prop = new Properties();

		try {
			prop.load(fis);
		} catch (IOException e) {
			logger.error(e);
		}
		prop.setProperty("com.mysql.jdbc.Driver", session.getAttribute("driver").toString());

		prop.setProperty("url", session.getAttribute("url").toString());

		prop.setProperty("username", session.getAttribute("username").toString());

		prop.setProperty("password", session.getAttribute("password").toString());
		DataSource datasource = null;
		Connection conn = null;
		DatabaseMetaData dbmd = null;
		try {

			datasource = BasicDataSourceFactory.createDataSource(prop);

			conn = datasource.getConnection();

			dbmd = conn.getMetaData();

			ResultSet rest  = dbmd.getTables(null, null, null,new String[] {"TABLE"});

			int i = 0;
			while(rest.next()) {
				i = i+1;
				tables.add(new Table(i,rest.getString("TABLE_NAME")));
			}

		} catch (SQLException e) {
			logger.error(e);
		} catch (Exception e) {
			logger.error(e);
		}finally {
			if(conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				logger.error(e);
			}
			}
		}
		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.writeValueAsString(tables);
		} catch (JsonProcessingException e) {
			logger.error(e);
		}
		return null;
	}

	@PostMapping("/getCode")
	@ResponseBody
	public String getCodeZip(@RequestParam(value="datalist") String tablestring,@RequestParam(value="packagename") String packagename,HttpSession session) throws JsonParseException, JsonMappingException, IOException{
		
		ObjectMapper mapper = new ObjectMapper();
		
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		
		List<Table> tables = mapper.readValue(tablestring, new TypeReference<ArrayList<Table>> (){});
		
		int size = tables.size();
		String[] tablenames = new String[size];
		
		for(int i=0;i<size;i++) {
			tablenames[i] = tables.get(i).getName();
		}
		
		dsi.setDatasourceAddress(session.getAttribute("url").toString());
		dsi.setDriverclassname(session.getAttribute("driver").toString());
		dsi.setUsername(session.getAttribute("username").toString());
		dsi.setPassword(session.getAttribute("password").toString());
		
		gecd.setDsi(dsi);
		gecd.setTablenames(tablenames);
		gecd.setPackagename(packagename);
		
		return mapper.writeValueAsString(gecd.run());
	}
	
	@PostMapping("/datasourceinfo")
	public String  getDataSource(@ModelAttribute DataSourceInfo dsi,Model  model,HttpSession session){

		session.setAttribute("driver", dsi.getDriverclassname());
		session.setAttribute("url", dsi.getDatasourceAddress());
		session.setAttribute("username", dsi.getUsername());
		session.setAttribute("password", dsi.getPassword());

		if(dsi.getDriverclassname() == null || dsi.getDatasourceAddress() == null || 
				dsi.getUsername() == null || dsi.getPassword() == null	) {
			logger.warn("driver or  url or username or password is null");
			return "dao/datasource";
		}

		return "dao/tablenames";

	}
	
	
	@GetMapping("/files/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> serveFile(@PathVariable String filename) {
		
		QueryWrapper<Statistics> qw =  new QueryWrapper<Statistics>();
		qw.eq("function","dao");
		
		Statistics statics = iss.getOne(qw);
		
		statics.setStatistics(statics.getStatistics()+1);
		
		iss.updateById(statics);
		
        Resource file = fs.loadAsResource(filename);
        
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }
	


}
