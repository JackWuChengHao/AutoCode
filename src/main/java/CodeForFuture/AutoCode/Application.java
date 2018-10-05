package CodeForFuture.AutoCode;

import org.apache.log4j.Logger;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@EnableAutoConfiguration(exclude= {DataSourceAutoConfiguration.class})
@MapperScan(basePackages ="CodeForFuture.AutoCode.mapper")
public class Application {
	
	private final static Logger logger =  Logger.getLogger(Application.class); 

    public static void main(String[] args) {
    	logger.info("start running");
        SpringApplication.run(Application.class, args);
        logger.info("running success");
    }
}
