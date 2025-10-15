package ComponentStereotypeAnnotations;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class PostMappingRequestBody {

	  @PostMapping("/addbook")
	  public String addBook(@RequestBody BookJson book) {
		  System.out.println(book.getBookid() );
		  System.out.println(book.getBookname() );
		  System.out.println(book.getBookdesc() );
	         return "Book received: " + book.getBookid() + " with book name: " + book.getBookname() + " | Book description: " + book.getBookdesc();
	    }
	  
	  @PostMapping("/add")
	  public ResponseEntity<BookJson> add(@RequestBody BookJson book){
		  return new ResponseEntity<>(book,HttpStatus.CREATED);
	  }
	  
	  @PutMapping("/updatebook/{id}")
	  public ResponseEntity<BookJson> updatebook(@PathVariable int id , @RequestBody BookJson updatebook){
		return ResponseEntity.ok(updatebook);
		  
	  }
	  
}
