package CodeForFuture.AutoCode.Generator;

import java.io.IOException;

import freemarker.cache.ClassTemplateLoader;
import freemarker.cache.NullCacheStorage;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;

public class FreeMarkerUtils {

	
	  private FreeMarkerUtils(){}
	    private static final Configuration CONFIGURATION = new Configuration(Configuration.VERSION_2_3_0);

	    static{
	    	
	        CONFIGURATION.setTemplateLoader(new ClassTemplateLoader(FreeMarkerUtils.class, "/generatortemplates"));
	        CONFIGURATION.setDefaultEncoding("UTF-8");
	        CONFIGURATION.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
	        CONFIGURATION.setCacheStorage(NullCacheStorage.INSTANCE);
	    }

	    public static Template getTemplate(String templateName) throws IOException {
	        try {
	            return CONFIGURATION.getTemplate(templateName);
	        } catch (IOException e) {
	            throw e;
	        }
	    }

	    public static void clearCache() {
	        CONFIGURATION.clearTemplateCache();
	    }

	
}
