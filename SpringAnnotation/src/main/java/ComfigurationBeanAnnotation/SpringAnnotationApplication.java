package ComfigurationBeanAnnotation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class SpringAnnotationApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(SpringAnnotationApplication.class, args);

		VegPizza vegpizza = context.getBean(VegPizza.class);
		System.out.println(vegpizza.getPizza());
		
		NonVegPizza nonvegpizza = (NonVegPizza) context.getBean("getNonVegPizza");
		System.out.println(nonvegpizza.getPizza());
		
		
		PizzaController pizza = (PizzaController) context.getBean(PizzaController.class);
		System.out.println(pizza.getPizza());
	}

}
