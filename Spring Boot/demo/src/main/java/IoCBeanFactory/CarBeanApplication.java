package IoCBeanFactory;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CarBeanApplication {

	public static void main(String[] args) {
		BeanFactory factory = new ClassPathXmlApplicationContext("car.xml");
		CarBean c = (CarBean) factory.getBean("car");
		c.ModelAndColor();
	}

}
