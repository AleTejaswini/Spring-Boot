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
	@PostMapping("addnewproduct")
	public ResponseEntity<Product> addproduct(@RequestBody Product p ){
		product.put(p.getId(), p);
		return ResponseEntity.status(HttpStatus.CREATED).body(p);
		
	}
	
	@GetMapping("/getall")
	public ResponseEntity<List<Product>> getall(){
		
		return ResponseEntity.ok(new ArrayList<>(product.values()));
		
	}
	
	@PutMapping("/updateproduct/{id}")
	public ResponseEntity<Product> updateproduct(@PathVariable int id ,@RequestBody Product p ){
		Product pro = product.get(id);
		if(pro==null)
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		p.setId(id);
		product.put(id, pro);
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
