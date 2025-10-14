package ComponentStereotypeAnnotations;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/classlevel")  // we use this as localhost:8080/classlevel/methodlevel
public class RequestMappingAnnotation {
	
	@RequestMapping("/methodlevel")
	public BookJson getbook() {
		return new BookJson(3,"SpringBoot","Annotations");
	}
	
	
	@RequestMapping({"/demo" , "/multiple" , "/simple","/reqmethod"})
	public String multpleuri() {
		return "using multiple url";
	}
}
