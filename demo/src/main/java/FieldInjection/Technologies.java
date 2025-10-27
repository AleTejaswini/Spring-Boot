package FieldInjection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Technologies {
	private int Techid;
	@Autowired
	public int getTechid() {
		return Techid;
	}

	public void setTechid(int techid) {
		Techid = techid;
	}
	
	public void show() {
		System.out.println("Successfull");
	}
}
