package ComponentStereotypeAnnotations;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
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
	
	
    private Map<Integer, BookJson> bookMap = new HashMap<>();
	 @GetMapping("/books")
	 public ResponseEntity<List<BookJson>> getAllBooks() {
	        return ResponseEntity.ok(new ArrayList<>(bookMap.values()));
	    }

}
