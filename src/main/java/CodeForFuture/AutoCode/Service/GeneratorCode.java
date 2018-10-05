package CodeForFuture.AutoCode.Service;

import java.io.File;
import java.util.UUID;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import CodeForFuture.AutoCode.Resources.GolbalConfig;
import CodeForFuture.AutoCode.Resources.ZipTools;
import CodeForFuture.AutoCode.entity.DataSourceInfo;

@Service
public class GeneratorCode {

	private final static Logger logger =  Logger.getLogger(GeneratorCode.class);
	
	@Autowired
	private DataSourceInfo dsi;

	private String[] tablenames;

	private String packagename;

	public DataSourceInfo getDsi() {
		return dsi;
	}

	public void setDsi(DataSourceInfo dsi) {
		this.dsi = dsi;
	}


	public String[] getTablenames() {
		return tablenames;
	}




	public void setTablenames(String[] tablenames) {
		this.tablenames = tablenames;
	}




	public String getPackagename() {
		return packagename;
	}




	public void setPackagename(String packagename) {
		this.packagename = packagename;
	}




	public String run(){

		String uuid = UUID.randomUUID().toString().replaceAll("-","");

		// 代码生成器
		AutoGenerator mpg = new AutoGenerator();

		// 全局配置
		GlobalConfig gc = new GlobalConfig();
		gc.setOutputDir(GolbalConfig.Generator_Dir.getContext()+uuid);
		gc.setAuthor(GolbalConfig.Generator_Author.getContext());
		gc.setOpen(false);
		gc.setFileOverride(true);
		gc.setSwagger2(false);
		mpg.setGlobalConfig(gc);

		// 数据源配置
		DataSourceConfig dsc = new DataSourceConfig();
		dsc.setUrl(dsi.getDatasourceAddress());
		dsc.setDriverName(dsi.getDriverclassname());
		dsc.setUsername(dsi.getUsername());
		dsc.setPassword(dsi.getPassword());
		mpg.setDataSource(dsc);

		// 包配置
		PackageConfig pc = new PackageConfig();
		pc.setParent(packagename);
		mpg.setPackageInfo(pc);

		// 策略配置
		StrategyConfig strategy = new StrategyConfig();
		strategy.setNaming(NamingStrategy.underline_to_camel);
		strategy.setColumnNaming(NamingStrategy.underline_to_camel);
		strategy.setEntityLombokModel(false);
		strategy.setRestControllerStyle(true);
		strategy.setInclude(tablenames);
		mpg.setStrategy(strategy);
		mpg.execute();

		try {
			ZipTools.packToolFiles(GolbalConfig.Generator_Dir.getContext()+uuid,
					GolbalConfig.Generator_Dir.getContext()+uuid+".zip");

			FileSystemUtils.deleteRecursively(new File(GolbalConfig.Generator_Dir.getContext()+uuid));

		} catch (Exception e) {
			logger.error(e);
		}

		return uuid;

	}

}
