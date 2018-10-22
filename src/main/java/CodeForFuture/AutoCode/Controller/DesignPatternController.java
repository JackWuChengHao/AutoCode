package CodeForFuture.AutoCode.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DesignPatternController {
	
	@GetMapping("/designpattern")
	public String DesignPatternIndex() {
		return "exception/waiting";
	}
	
	
}
