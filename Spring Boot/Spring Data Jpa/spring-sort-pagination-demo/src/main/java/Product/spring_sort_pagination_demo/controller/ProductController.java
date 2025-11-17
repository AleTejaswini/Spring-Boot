package Product.spring_sort_pagination_demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import Product.spring_sort_pagination_demo.model.Product;
import Product.spring_sort_pagination_demo.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService productservice;

	@GetMapping("/getall")
	public Page<Product> getall() {
		Pageable pageable = PageRequest.of(0, 2);
		Page<Product> page = productservice.findall(pageable);
		return page;
	}

	@GetMapping("/getallproducts")
	public Page<Product> getAllProducts(
			@RequestParam int pageNum, 
			@RequestParam int size, 
			@RequestParam String sortBy,
			@RequestParam boolean ascending) {

		Sort sort = ascending ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
		PageRequest pagerequest = PageRequest.of(pageNum, size, sort);
		Page<Product> page = productservice.findall(pagerequest);

		return page;
	}
	
	
	@GetMapping("/get")
	public Page<Product> sortbyname(@RequestParam(name= "pagenum")  int pagenum,
			@RequestParam(name= "size") int size,
			@RequestParam(name= "sortby") String sortby){
		Sort sort= Sort.by(Direction.ASC, sortby);
		PageRequest pagerequest=PageRequest.of(pagenum, size,sort);
		Page<Product> page=productservice.findallsortbyname(pagerequest);
		return page;
	}

}
