package ComponentStereotypeAnnotations;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestControll{
	
	@RequestMapping("/restcontrollerbook")
	public BookJson getbook() {
		return new BookJson(2,"Python","Learn python");
		
	}
	
}
