package ComponentStereotypeAnnotations;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
@RequestMapping("/class")
public class GetMappingAnnotation {
	
	@GetMapping({"/getHTTP" ,"/getmethod"})
	public BookJson getBook() {
		return new BookJson(4,"Html","tags");
	}

}
