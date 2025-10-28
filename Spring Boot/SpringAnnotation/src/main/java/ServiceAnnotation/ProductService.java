package ServiceAnnotation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class ProductService {
	private Map<Integer,ServiceAnnotationProduct> pro = new HashMap<>();
	
	
	public ServiceAnnotationProduct addproduct(ServiceAnnotationProduct p ) {
		 pro.put(p.getProductid(), p);
		return p;
	}
	
	public List<ServiceAnnotationProduct> getallproducts(){
		return new ArrayList<>(pro.values());
		
	}
}
