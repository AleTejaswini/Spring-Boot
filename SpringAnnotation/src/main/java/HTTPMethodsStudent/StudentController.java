package HTTPMethodsStudent;

import java.util.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/students")
public class StudentController {

	private Map<Integer, Student> s = new HashMap<>();

	public StudentController() {
		s.put(1, new Student(1, "Teja", 21));
		s.put(2, new Student(2, "Afsheen", 22));
		s.put(3, new Student(3, "Renuka", 21));
	}

	// Get all students
	@GetMapping("/all")
	@ResponseStatus(HttpStatus.OK)
	public List<Student> getAllStudents() {
		return new ArrayList<>(s.values());
	}

	@GetMapping("/count")
	public int getcount() {
		int count = 0;
		for (int i = 0; i < s.size(); i++) {
			count++;
		}
		return count;
	}

	@GetMapping("olderthan/{age}")
	public ResponseEntity<List<Student>> getbyage(@PathVariable int age) {
		List<Student> result = new ArrayList<>();

		for (Student std : s.values()) {
			if (std.getAge() > age) {
				result.add(std);
			}
		}

		if (result.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(result);

	}

	@GetMapping("/search/{name}")
	public ResponseEntity<Student> getbyname(@PathVariable String name) {
		for (Student std : s.values())

			if (std.getName().equalsIgnoreCase(name))
				return ResponseEntity.ok(std);

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	}

	// Get student by id
	@GetMapping("/{id}")
	public ResponseEntity<Student> getById(@PathVariable int id) {
		Student std = s.get(id);
		if (std == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.ok(std);
	}

	@GetMapping("/re/{id}")
	public ResponseEntity<?> getIdre(@PathVariable int id) {
		Student std = s.get(id);

		if (std == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No data found for ID: " + id);
		}
		return ResponseEntity.ok(std);
	}

	@GetMapping("/rs/{id}")
	public Student getId(@PathVariable int id) {
		Student std = s.get(id);
		if (std == null) {
			throw new StudentNotFoundException("No data found");
		}
		return std;
	}

	// Add new student
	@PostMapping("/add")
	public ResponseEntity<Student> postStd(@RequestBody Student student) {
		s.put(student.getId(), student);
		return ResponseEntity.status(HttpStatus.CREATED).body(student);
	}

	@PostMapping("/agelimit")
	public ResponseEntity<Student> agelimit(@RequestBody Student student) {
		if (student.getAge() > 18) {
			s.put(student.getId(), student);
			return ResponseEntity.status(HttpStatus.CREATED).body(student);
		}
		return ResponseEntity.badRequest().build();
	}

	@PostMapping("/namenotEmpty")
	public ResponseEntity<Student> Emptyname(@RequestBody Student student) {
		if (student.getName().isBlank()) {
			return ResponseEntity.status(HttpStatus.CREATED).body(student);
		}
		s.put(student.getId(), student);
		return ResponseEntity.status(HttpStatus.CREATED).body(student);
	}

	@PostMapping("/duplicateids")
	public ResponseEntity<?> duplicatid(@RequestBody Student student) {
		List<Student> std = new ArrayList<>();
		if (s.containsKey(student.getId())) {
			return ResponseEntity.status(HttpStatus.CONFLICT)
					.body("Student with id : " + student.getId() + "is already exists");
		}
		s.put(student.getId(), student);
		return ResponseEntity.status(HttpStatus.CREATED).body(student);
	}

	// Update student
	@PutMapping("/update/{id}")
	public ResponseEntity<Student> updateStd(@PathVariable int id, @RequestBody Student student) {
		Student std = s.get(id);
		if (std == null)
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

		student.setId(id);
		s.put(id, student);
		return ResponseEntity.ok(student);
	}

	// Delete student
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> deleteStd(@PathVariable int id) {
		Student std = s.remove(id);
		if (std == null)
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

		return ResponseEntity.noContent().build();
	}
}
