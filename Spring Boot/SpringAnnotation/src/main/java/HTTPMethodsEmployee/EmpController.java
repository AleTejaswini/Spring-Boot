package HTTPMethodsEmployee;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import HTTPMethodsStudent.Student;

@RestController
@RequestMapping("/employee")
public class EmpController {

	private Map<Integer, Employee> emp = new HashMap<>();

	public EmpController() {
		emp.put(1, new Employee(1, "Teja", 60000));
		emp.put(2, new Employee(2, "Affu", 80000));
		emp.put(3, new Employee(3, "Renuka", 50000));
	}

	@GetMapping("/getallemp")
	public ResponseEntity<List<Employee>> getAllEmployees() {
		return ResponseEntity.ok(new ArrayList<>(emp.values()));
	}

	@GetMapping("/getbyid/{id}")
	public ResponseEntity<Employee> getbyid(@PathVariable int id) {
		Employee employee = emp.get(id);
		if (employee == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.ok(employee);

	}
	


	@PostMapping("/addnewemp")
	public ResponseEntity<Employee> addnewemp(@RequestBody Employee e) {
		emp.put(e.getId(), e);
		return ResponseEntity.status(HttpStatus.CREATED).body(e);
	}

	@PutMapping("/updateemp/{id}")
	public ResponseEntity<Employee> updateemp(@PathVariable int id, @RequestBody Employee e) {
		Employee employee = emp.get(id);
		if (e == null)
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

		e.setId(id);
		emp.put(id, e);
		return ResponseEntity.ok(e);
	}

	@DeleteMapping("/deleteemp/{id}")
	public ResponseEntity<Void> deleteemp(@PathVariable int id) {
		Employee employee = emp.remove(id);
		if (employee == null)
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

		return ResponseEntity.noContent().build();
	}

	@DeleteMapping("/deleteall")
	public ResponseEntity<String> deleteallemp() {
		emp.clear();
		return ResponseEntity.ok("Deleted sucessfully");
	}
	
	
}
