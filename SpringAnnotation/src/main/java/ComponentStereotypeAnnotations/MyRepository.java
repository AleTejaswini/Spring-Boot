package ComponentStereotypeAnnotations;

import org.springframework.stereotype.Repository;

@Repository
public class MyRepository {
	public void hello() {
		System.out.println("Hello Repository");
	}
}
