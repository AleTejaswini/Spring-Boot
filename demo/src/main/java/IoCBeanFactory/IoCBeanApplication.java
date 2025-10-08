package IoCBeanFactory;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class IoCBeanApplication {

	public static void main(String[] args) {

		BeanFactory factory = new ClassPathXmlApplicationContext("mobiles.xml");
		Mobiles mobile = (Mobiles) factory.getBean("obj1");
		mobile.getModelAndColor();

	}

}
