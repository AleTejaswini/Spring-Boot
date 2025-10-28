package StudentRepositoryAnnotation;

public class Student {
	private int id;
	private String Name;
	private String Branch;
	public int getId() {
		return id;
	}
	public Student() {
		super();
		
	}
	public Student(int id, String name, String branch) {
		super();
		this.id = id;
		this.Name = name;
		this.Branch = branch;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getBranch() {
		return Branch;
	}
	public void setBranch(String branch) {
		Branch = branch;
	}
}
