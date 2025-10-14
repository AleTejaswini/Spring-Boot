package ComponentStereotypeAnnotations;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostMappingAnnotation {
	
	@PostMapping("/post")
	public String posting() {
		return "Data posted succesfully";
	}

}
