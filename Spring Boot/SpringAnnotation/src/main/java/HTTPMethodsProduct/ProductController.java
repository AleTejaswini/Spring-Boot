package HTTPMethodsProduct;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
@RequestMapping("/products")
public class ProductController {

	private Map<Integer,Product> product = new HashMap<>();
	public ProductController() {
		product.put(1, new Product(1,"OnePlus",40000,1,"Electronics"));
		product.put(2, new Product(2,"Iphone",80000,2,"Electronics"));
		product.put(3, new Product(3,"Laptop",70000,1,"Computers"));
		product.put(4, new Product(4,"AC",60000,1,"Appliances"));
		
	}
	@GetMapping("/hello")
	public String sayHello() {
	    return "Hello World!";
	}
	@PostMapping("/add")
	public String add() {
		return "hello";
		
	}
	// above two return same http code 200..to provide custom httpcodes we use ResponseEntity

	@PostMapping("addnewproduct")
	public ResponseEntity<Product> addproduct(@RequestBody Product p ){
		product.put(p.getId(),p);
		return ResponseEntity.status(HttpStatus.CREATED).body(p);
		
	}
	
	@GetMapping("/getall")
	public ResponseEntity<List<Product>> getall(){
		
		return ResponseEntity.ok(new ArrayList<>(product.values()));
		
	}
	
	@GetMapping("/getbyid/{id}")
	public ResponseEntity<?> getbyid(@PathVariable int id){
		Product pro = product.get(id);
		if(pro==null)
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No data found with id: " +id);
		
		return ResponseEntity.ok(pro);
	}
	
	
	@GetMapping("/getbycategory/{category}") // returns only first product 
	public ResponseEntity<?> getbycategory(@PathVariable String category){
		for(Product pro:product.values()) {
			if(pro.getCategory().equalsIgnoreCase(category)) {
				return ResponseEntity.ok(pro);
			}
		}
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No product found with category: "+category);
		
	}
	
	
	@GetMapping("/getbycategorylist/{category}")
	public ResponseEntity<?> getbycategorylist(@PathVariable String category){
		List<Product> matchedcategory = new ArrayList<>();
		for(Product pro:product.values()) {
			if(pro.getCategory().equalsIgnoreCase(category)) {
				matchedcategory.add(pro);
			}
		}
		if(matchedcategory.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No product found with category: "+category);
		}
	return ResponseEntity.ok(matchedcategory);}
	
	
	
	@PutMapping("/updateproduct/{id}")
	public ResponseEntity<Product> updateproduct(@PathVariable int id ,@RequestBody Product p ){
		Product pro = product.get(id);
		if(pro==null)
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		p.setId(id);
		product.put(id, p);
		return ResponseEntity.ok(p);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> deleteproduct(@PathVariable int id){
		Product pro = product.remove(id);
		if(pro==null)
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		
		return ResponseEntity.noContent().build();
	}
}
