package ValueAnnotation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
@Component
public class Demo {
	
	@Value("Teja")
	private String Name;

	public String getName() {
		return Name;
	}
	
	@Value("${details.age}")
	private int age;
	
	public int getAge() {
		return age;
	}

	public String getAddress() {
		return address;
	}

	@Value("${Address}")
	private String address;
	
	@Value("#{10+10}")
	private int sum;

	public int getSum() {
		return sum;
	}
	@Value("${java.home}")
	private String java;

	public String getJava() {
		return java;
	}
	
}
