package rs.ac.uns.ftn.isa;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import rs.ac.uns.ftn.isa.model.Project;
import rs.ac.uns.ftn.isa.model.Student;
import rs.ac.uns.ftn.isa.model.SubProject;
import rs.ac.uns.ftn.isa.model.SubSubProject;
import rs.ac.uns.ftn.isa.service.StudentService;

@SpringBootApplication
public class JpaEntityGraphApplication implements CommandLineRunner {
	
	
	@Autowired
	private StudentService studentService;


	public static void main(String[] args) {
		SpringApplication.run(JpaEntityGraphApplication.class, args);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void run(String... args) throws Exception {
		
		studentService.saveStudentWithProjects();
		
		List<Student> students = studentService.findAllStudentsAndNestedCollectionsUsingGraph();
		System.out.println("Podaci o studentu: " + students.get(0));
		
		List<Project> projekti = new ArrayList(students.get(0).getProjects());
		List<SubProject> potprojekti1 = new ArrayList(projekti.get(0).getSubProjects());
		List<SubProject> potprojekti2 = new ArrayList(projekti.get(1).getSubProjects());
		List<SubSubProject> potpotprojekti1 = new ArrayList(potprojekti1.get(0).getSubSubProjects());
		List<SubSubProject> potpotprojekti2 = new ArrayList(potprojekti2.get(0).getSubSubProjects());
		
		System.out.println("Podaci o projektu 1: " + projekti.get(0) + ", student " + projekti.get(0).getStudent());
		System.out.println("Podaci o potprojektu 1 projekta 1: " + potprojekti1.get(0) + ", projekat " + potprojekti1.get(0).getProject());
		System.out.println("Podaci o potpotprojektu 1 potprojekta 1: " + potpotprojekti1.get(0) + ", potprojekat " + potpotprojekti1.get(0).getSubProject());
		System.out.println("Podaci o potpotprojektu 2 potprojekta 1: " + potpotprojekti1.get(1)+ ", potprojekat " + potpotprojekti1.get(1).getSubProject());
		
		
		System.out.println("Podaci o projektu 2: " + projekti.get(1));
		System.out.println("Podaci o potprojektu 1 projekta 2: " + potprojekti2.get(0));
		System.out.println("Podaci o potpotprojektu 1 potprojekta 1: " + potpotprojekti2.get(0));
		System.out.println("Podaci o potpotprojektu 2 potprojekta 1: " + potpotprojekti2.get(1));
	
		
	}

}
