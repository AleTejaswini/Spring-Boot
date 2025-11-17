
 package Product.spring_sort_pagination_demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import Product.spring_sort_pagination_demo.model.Product;
import Product.spring_sort_pagination_demo.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private  ProductRepository productrepository;
	
	public Page<Product> findall(Pageable pageable){
		return productrepository.findAll(pageable);
	}
	
	public Page<Product> findallsortbyname(Pageable pageable){
		return productrepository.findAll(pageable);
	}
	
	
}