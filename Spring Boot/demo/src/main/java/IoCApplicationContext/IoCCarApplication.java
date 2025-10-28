package IoCApplicationContext;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class IoCCarApplication {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(CarConfig.class);
		Car car = context.getBean("getname", Car.class);
		
		car.carname();
		
	}

}
