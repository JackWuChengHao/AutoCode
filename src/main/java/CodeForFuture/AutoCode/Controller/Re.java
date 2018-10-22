package CodeForFuture.AutoCode.Controller;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Re {
	
	@GetMapping("/re")
    public String getIndex() throws IOException {

        return "exception/waiting";
        
    }

}
