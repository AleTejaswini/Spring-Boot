package HTTPMethods;

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
    public ResponseEntity<List<Student>> getAllStudents() {
        return ResponseEntity.ok(new ArrayList<>(s.values()));
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

    // Add new student
    @PostMapping("/add")
    public ResponseEntity<Student> postStd(@RequestBody Student student) {
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
