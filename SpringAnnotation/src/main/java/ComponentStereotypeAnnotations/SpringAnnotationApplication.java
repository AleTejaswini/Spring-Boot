package ComponentStereotypeAnnotations;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class SpringAnnotationApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(SpringAnnotationApplication.class, args);
//		PizzaController pizza = context.getBean(PizzaController.class); // using class parameter
//		PizzaController pizza = (PizzaController) context.getBean("pizzaController"); // using default string
//		PizzaController pizza = (PizzaController) context.getBean("P"); // by giving name to @Component 
//		System.out.println(pizza.getPizza());
		
		MyController controller = context.getBean(MyController.class);
		controller.hello();
		
		MyService service = context.getBean(MyService.class);
		service.hello();
		
		MyRepository repository = context.getBean(MyRepository.class);
		repository.hello();
	}

}
