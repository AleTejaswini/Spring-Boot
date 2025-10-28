package StudentRepositoryAnnotation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.springframework.stereotype.Repository;


@Repository
public class StudentRepository {
	Map<Integer,Student> students = new HashMap<>();
	
	public List<Student> findall() {
		return  new ArrayList<>(students.values());
	}
	
	public Student save(Student s) {
		  students.put(s.getId(), s);
		  return s;
		
	}
	
	public Student updatestd(int id,Student s) {
		Student std = students.get(id);
		if(std==null)
			return null;
		std.setId(s.getId());
		std.setName(s.getName());
		std.setBranch(s.getBranch());
		students.put(id, s);
		
		return std;
		
	}	
	public long count() {
		return students.size();
	}
	
		
	public Student deleteById(int id) {
		Student std = students.remove(id);
		if(std==null)
			return null;
		return std;
		
	}
	
				
	
	
	
		
		
	
}
