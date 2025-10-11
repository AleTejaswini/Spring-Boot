package ScopeAnnotation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class SpringAnnotationApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(SpringAnnotationApplication.class, args);

		Singleton singleton1 = context.getBean(Singleton.class);
		Singleton singleton2 = context.getBean(Singleton.class);
		Singleton singleton3 = context.getBean(Singleton.class);

		Prototype prototype1 = context.getBean(Prototype.class);
		Prototype prototype2 = context.getBean(Prototype.class);
		Prototype prototype3 = context.getBean(Prototype.class);

	}

}
