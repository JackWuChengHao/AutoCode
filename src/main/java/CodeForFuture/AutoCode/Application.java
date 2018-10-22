package CodeForFuture.AutoCode;

import org.apache.log4j.Logger;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import CodeForFuture.AutoCode.Utils.ActiveMQUtils;

@SpringBootApplication
//@EnableAutoConfiguration(exclude= {DataSourceAutoConfiguration.class})
@MapperScan(basePackages ="CodeForFuture.AutoCode.mapper")
public class Application {

	private final static Logger logger =  Logger.getLogger(Application.class); 

	public static void main(String[] args) {
		logger.info("start running");
		
		ActiveMQUtils am = new ActiveMQUtils("queuetest");
		System.out.println(am);
		for(int i =0 ;i<10;i++) {
			am.sendMessage("okokokoko");
		}
		SpringApplication.run(Application.class, args);
		logger.info("running success");
	}

}
