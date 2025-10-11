package LazyAnnotation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class SpringAnnotationApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(SpringAnnotationApplication.class, args);
		System.out.println("Starts Initialization");
		EagerLoader load = context.getBean(EagerLoader.class);
		load.eagerload();
	}

}
