package rs.ac.uns.ftn.isa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import rs.ac.uns.ftn.isa.model.Address;
import rs.ac.uns.ftn.isa.model.Project;
import rs.ac.uns.ftn.isa.model.Student;
import rs.ac.uns.ftn.isa.service.AddressService;
import rs.ac.uns.ftn.isa.service.ProjectService;
import rs.ac.uns.ftn.isa.service.StudentService;
import rs.ac.uns.ftn.isa.service.TeacherService;

@SpringBootApplication
public class JpaExampleApplication implements CommandLineRunner {
	
	@Autowired
	private TeacherService teacherService;
	
	@Autowired
	private AddressService addressService;
	
	@Autowired
	private StudentService studentService;
	
	@Autowired
	private ProjectService projectService;

	public static void main(String[] args) {
		SpringApplication.run(JpaExampleApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		teacherService.saveTeacherWithCoursesSet();
		Thread.sleep(4000);
		teacherService.saveTeacherWithCoursesList();
		
		addressService.save();
		
		Address address = addressService.getAddressByStudentId();
		System.out.println(address);
		
		studentService.saveStudentWithProjects();
		Student s2 = studentService.fetchStudentWithProjects(2);
		System.out.println(s2 + " --- " + s2.getProjects());
		Project p = projectService.fetchProjectWithStudent(1);
		System.out.println(p.getStudent());
	}

}
