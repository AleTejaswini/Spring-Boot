package LazyAnnotation;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
//@Lazy
public class EagerLoader {
	public EagerLoader() {
		System.out.println("Eager object created ");
	}

	public void eagerload() {
		System.out.println("EagerLoader");
	}
}
