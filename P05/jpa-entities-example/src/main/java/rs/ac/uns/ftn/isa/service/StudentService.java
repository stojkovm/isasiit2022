package rs.ac.uns.ftn.isa.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.ac.uns.ftn.isa.model.Project;
import rs.ac.uns.ftn.isa.model.Student;
import rs.ac.uns.ftn.isa.repository.StudentRepository;

@Service
@Transactional
public class StudentService {
	
	@Autowired
	private StudentRepository studentRepository;
	
	public Student fetchStudentWithProjects(Integer id) {
		return studentRepository.fetchStudentWithProjects(id);
	}
	
	public void saveStudentWithProjects() {
		
		Student s = new Student();
		s.setFirstName("Zika");
		s.setLastName("Zikic");
		s.setIndex("SW-22-2020");
		
		Project p1 = new Project();
		p1.setName("ISA projekat");
		p1.setProgrammingLanguage("Java");
		p1.setDescription("Aplikacija za rezervaciju lekova i pregleda");
		
		Project p2 = new Project();
		p2.setName("PSW projekat");
		p2.setProgrammingLanguage("C#");
		p2.setDescription("Aplikacija za evidenciju zaposlenih");
		
		s.addProject(p1);
		s.addProject(p2);
		
		studentRepository.save(s);
	}

}
