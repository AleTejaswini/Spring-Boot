package relationships.examples.onetoone;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;


@Entity
public class EmpID {
	@Id
	private int id;
	private String empcode;
	
	@Override
	public String toString() {
		return "EmpID [id=" + id + ", empcode=" + empcode + "]";
	}
	public EmpID(int id, String empcode) {
		super();
		this.id = id;
		this.empcode = empcode;
	}
	public int getId() {
		return id;
	}
	public String getEmpcode() {
		return empcode;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setEmpcode(String empcode) {
		this.empcode = empcode;
	}
	public EmpID() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}