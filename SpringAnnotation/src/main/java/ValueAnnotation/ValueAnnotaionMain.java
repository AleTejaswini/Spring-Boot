package ValueAnnotation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import AutowiredAnnotation.SpringAnnotationApplication;
@SpringBootApplication
public class ValueAnnotaionMain {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(ValueAnnotaionMain.class, args);
		
		Demo details = context.getBean(Demo.class);
		System.out.println(details.getName());
		
		System.out.println(details.getAge());
		System.out.println(details.getAddress());
		System.out.println(details.getSum());
		System.out.println(details.getJava());
		
	}

}
