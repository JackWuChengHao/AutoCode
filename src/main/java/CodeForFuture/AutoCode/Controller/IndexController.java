package CodeForFuture.AutoCode.Controller;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class IndexController {
	
	@GetMapping("/")
    public String getIndex() throws IOException {

        return "index";
        
    }
	
	@GetMapping("dao/datasource")
    public String getDataSource() throws IOException {

        return "dao/datasource";
        
    }
	

}
