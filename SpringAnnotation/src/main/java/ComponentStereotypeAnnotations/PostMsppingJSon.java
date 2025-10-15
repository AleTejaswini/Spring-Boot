package ComponentStereotypeAnnotations;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostMsppingJSon {
	
	
	@PostMapping("/usingJSon")
	public BookJson book() {
		return new BookJson(3,"Python","Datatypes");
		
	}

}
