package ComponentStereotypeAnnotations;

import org.springframework.stereotype.Service;

@Service
public class MyService {
	public void hello() {
		System.out.println("Hello Service");
	}
}
