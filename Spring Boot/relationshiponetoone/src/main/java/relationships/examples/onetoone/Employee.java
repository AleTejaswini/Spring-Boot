package relationships.examples.onetoone;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Employee {
	@Id
	private int id;
	private String name;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "emp_id" , referencedColumnName = "id" )
	private EmpID empid;

	
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", empid=" + empid + "]";
	}

	public EmpID getEmpid() {
		return empid;
	}

	public void setEmpid(EmpID empid) {
		this.empid = empid;
	}

	public Employee(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
}
