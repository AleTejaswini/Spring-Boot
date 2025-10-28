package ServiceAnnotation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/serviceproduct")
public class ProductController {
	
	@Autowired
	private ProductService productservice;

	@PostMapping("/add")
	public ServiceAnnotationProduct addproduct(@RequestBody ServiceAnnotationProduct p){
		return (ServiceAnnotationProduct) productservice.addproduct(p);
		
	}
	
	@GetMapping("/getallproducts")
	public List<ServiceAnnotationProduct> getallproduct() {
		return  productservice.getallproducts();
	}
}
