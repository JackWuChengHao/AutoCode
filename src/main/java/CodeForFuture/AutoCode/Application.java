package CodeForFuture.AutoCode;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
@EnableAutoConfiguration(exclude= {DataSourceAutoConfiguration.class})
public class Application {
	
	private final static Logger logger =  Logger.getLogger(Application.class); 

    public static void main(String[] args) {
    	logger.info("start running");
        SpringApplication.run(Application.class, args);
        logger.info("running success");
    }
}
