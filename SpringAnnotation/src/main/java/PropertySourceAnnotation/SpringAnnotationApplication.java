package PropertySourceAnnotation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class SpringAnnotationApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(SpringAnnotationApplication.class, args);
	
		
		PropertySourceDemo p = context.getBean(PropertySourceDemo.class);
		System.out.println(p.getStdaddress());
		System.out.println(p.getAppname());
		System.out.println(p.getApptopic());
	}

}
