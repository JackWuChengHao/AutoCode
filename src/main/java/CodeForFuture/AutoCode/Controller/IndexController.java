package CodeForFuture.AutoCode.Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import CodeForFuture.AutoCode.Service.Impl.StatisticsServiceImpl;
import CodeForFuture.AutoCode.entity.Statistics;


@Controller
public class IndexController {
	
	private final static Logger logger =  Logger.getLogger(IndexController.class);
	
	@Autowired
	private StatisticsServiceImpl iss;
	
	
	@GetMapping("/")
    public String getIndex() throws IOException {

        return "index";
        
    }
	
	@GetMapping("dao/datasource")
    public String getDataSource() throws IOException {

        return "dao/datasource";
        
    }
	
	
	@GetMapping("/getStatistics")
	@ResponseBody
	public String getStatistics() {
		
		QueryWrapper<Statistics> qw =  new QueryWrapper<Statistics>();
		
		qw.eq("function","dao");
		
		Statistics statics = iss.getOne(qw);
		
		List<Statistics> list_statics = new ArrayList<Statistics>();
		
		list_statics.add(statics);
		
		ObjectMapper mapper = new ObjectMapper();
		
			try {
				return mapper.writeValueAsString(list_statics);
			} catch (JsonProcessingException e) {
				logger.error(e);
			}
		
		return null;
	}
	

}
