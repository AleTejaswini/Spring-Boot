package ConstructorInjection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ConstructorInjectionApplication {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("constructor.xml");
//		Customers cust1 = (Customers) context.getBean("customer1");
//		System.out.println(cust1.toString());
		
		Orders order = (Orders) context.getBean("order");
		System.out.println(order.toString());
		
		
		

	}

}
