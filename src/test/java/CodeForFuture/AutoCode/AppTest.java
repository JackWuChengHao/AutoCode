package CodeForFuture.AutoCode;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.test.context.junit4.SpringRunner;

import CodeForFuture.AutoCode.Utils.ActiveMQUtils;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */

@RunWith(SpringRunner.class) 
@SpringBootTest
public class AppTest 
    extends TestCase
{	
	
	@Autowired
	private static RedisConnectionFactory rcf;
	
	public AppTest(){
		
	}

	
    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }
    
    
//    public void testGenerator() {
//    	
//    	 // 代码生成器
//        AutoGenerator mpg = new AutoGenerator();
//
//        // 全局配置
//        GlobalConfig gc = new GlobalConfig();
//        gc.setOutputDir("./dir/b51568aec3dc4f44b2ab0a2bf0e51786");
//        gc.setAuthor("xiaowu");
//        gc.setOpen(false);
//        gc.setFileOverride(true);
//        gc.setSwagger2(false);
//        mpg.setGlobalConfig(gc);
//
//        // 数据源配置
//        DataSourceConfig dsc = new DataSourceConfig();
//        dsc.setUrl("jdbc:mysql://140.143.234.38:3306/test?useUnicode=true&useSSL=false&characterEncoding=utf8");
//        dsc.setDriverName("com.mysql.jdbc.Driver");
//        dsc.setUsername("root");
//        dsc.setPassword("sDXAsv6R2n5t");
//        mpg.setDataSource(dsc);
//
//        // 包配置
//        PackageConfig pc = new PackageConfig();
//        pc.setParent("com.baomidou.ant");
//        mpg.setPackageInfo(pc);
//
//        // 策略配置
//        StrategyConfig strategy = new StrategyConfig();
//        strategy.setNaming(NamingStrategy.underline_to_camel);
//        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
//        strategy.setEntityLombokModel(false);
//        strategy.setRestControllerStyle(true);
//        strategy.setInclude("user");
////        strategy.setSuperEntityColumns("id");
////        strategy.setControllerMappingHyphenStyle(true);
////        strategy.setTablePrefix(pc.getModuleName() + "_");
//        mpg.setStrategy(strategy);
////        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
//        mpg.execute();
//    }
    
    
//    public void testSplit() {
//    	
//    	String pack = "com.xiaowu";
//    	
//    	String  shuzu = pack.split("\\.")[0];
//    	
//    	System.out.println(shuzu);
//    	
//    }

   @org.junit.Test
    public void testzip() {
//    	try {
//			ZipTools.zip(GolbalConfig.Generator_Dir.getContext()+"6aff83bf25214d2ca02cb3de6637f347" , GolbalConfig.Generator_Dir.getContext()+"6aff83bf25214d2ca02cb3de6637f347"+".zip");
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	   
//	   ActiveMQUtils am = new ActiveMQUtils("queue test");
//	   for(int i =0 ;i<10;i++) {
//	   am.sendMessage("okokokoko");
//	   }
//    	System.out.println(rcf.getConnection());
    }
    
}
