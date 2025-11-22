
package com.MongoSpring.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.MongoSpring.Model.Student;
import com.MongoSpring.Repository.StudentRepository;
import java.util.List;

@RestController
public class StudentController {

	@Autowired
	StudentRepository studentRepository;
	
	@PostMapping("/addStudent")
	public void addStudent(@RequestBody Student student) {
		studentRepository.save(student);
	}
	
	@GetMapping("/getStudents")
	public List<Student> getStudents(){
		return studentRepository.findAll();
	}
	
	@GetMapping("/getStudent/{id}")
	public Student getStudent(@PathVariable Integer id){
		return studentRepository.findById(id).orElse(null);
	}
	
	@PutMapping("/updateStudent")
	public void updateStudent(@RequestBody Student student) {
		Student data=studentRepository.findById(student.getRno()).orElse(null);
		System.out.println(data);
		if(data!=null) {
			data.setName(student.getName());
			data.setAddress(student.getAddress());
			studentRepository.save(data);
		}
	}
	
	@DeleteMapping("/deleteStudent/{id}")
	public void deleteStudent(@PathVariable Integer id) {
		studentRepository.deleteById(id);
	}
}
