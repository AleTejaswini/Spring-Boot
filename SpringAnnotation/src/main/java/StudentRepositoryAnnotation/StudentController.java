package StudentRepositoryAnnotation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/StdRepository")
public class StudentController {
	
	@Autowired
	private StudentRepository stdservice;
	
	@GetMapping("/getall")
	public List<Student> getall(){
		return stdservice.findall();
	}
	
	@GetMapping("/stdcount")
	public int getstdcount() {
		return (int) stdservice.count();
	}
	
	@PostMapping("/addnewstd")
	public Student addnew(@RequestBody Student s) {
		 stdservice.save(s);
		 return s;
	}
	
	@PutMapping("/updatestd/{id}")
	public ResponseEntity<?> updatestd(@PathVariable int id ,@RequestBody Student s) {
		Student std = stdservice.updatestd(id, s);
		if(std==null)
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not found");
		return ResponseEntity.ok(std);
		
	}
	
	
	@DeleteMapping("/deleteid/{id}")
	public ResponseEntity<?> deletestd(@PathVariable int id ){
		Student std = stdservice.deleteById(id);
		if(std==null)
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not found");
		return ResponseEntity.noContent().build();
	}
	

}
