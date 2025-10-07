package IoC;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class InversionOfControlAppilcation {

	public static void main(String[] args) {
	
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MobilesConfig.class);
		
		Mobiles obj = context.getBean("getOneplus", Mobiles.class);
		obj.getModelAndColor();
	}

}
