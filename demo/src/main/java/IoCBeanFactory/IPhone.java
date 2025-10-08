package IoCBeanFactory;



public class IPhone implements Mobiles {
	
	IPhone() {
		System.out.println("IPhone constructor");
	}
	
	@Override
	public void getModelAndColor() {
		System.out.println("Model :17 Pro");
		
	}

}
