package FieldInjection;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DIApplication {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext("Customers.class");
		Customers c = context.getBean(Customers.class);
		c.display();
	}

}
