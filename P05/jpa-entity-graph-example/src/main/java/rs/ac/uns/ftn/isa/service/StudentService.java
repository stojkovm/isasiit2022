package rs.ac.uns.ftn.isa.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.ac.uns.ftn.isa.model.Project;
import rs.ac.uns.ftn.isa.model.Student;
import rs.ac.uns.ftn.isa.model.SubProject;
import rs.ac.uns.ftn.isa.model.SubSubProject;
import rs.ac.uns.ftn.isa.repository.StudentRepository;

@Service
@Transactional
public class StudentService {
	
	@Autowired
	private StudentRepository studentRepository;
	
	public List<Student> findAllStudentsAndNestedCollectionsUsingGraph() {
		return studentRepository.fetchAllNestedCollections();
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
		
		SubProject sp1 = new SubProject();
		sp1.setName("Backend ISA");
		sp1.setProgrammingLanguage("Spring Boot");
		sp1.setDescription("Endpointi za apoteku");
		SubProject sp2 = new SubProject();
		sp2.setName("Frontend PSW");
		sp2.setProgrammingLanguage("Vue.js");
		sp2.setDescription("Stranice za zaposlene");
		
		SubSubProject ssp1 = new SubSubProject();
		ssp1.setName("Registracija");
		ssp1.setProgrammingLanguage("Spring Boot");
		ssp1.setDescription("Registracija apoteke back");
		SubSubProject ssp2 = new SubSubProject();
		ssp2.setName("Brisanje");
		ssp2.setProgrammingLanguage("Spring Boot");
		ssp2.setDescription("Brisanje apoteke back");
		SubSubProject ssp3 = new SubSubProject();
		ssp3.setName("Registracija Front");
		ssp3.setProgrammingLanguage("Vue.js");
		ssp3.setDescription("Registracija zaposlenog front forma");
		SubSubProject ssp4 = new SubSubProject();
		ssp4.setName("Brisanje Front");
		ssp4.setProgrammingLanguage("Vue.js");
		ssp4.setDescription("Brisanje zaposlenog front button");
		
		sp1.addSubSubProject(ssp1);
		sp1.addSubSubProject(ssp2);
		p1.addSubProject(sp1);
		s.addProject(p1);
		
		
		sp2.addSubSubProject(ssp3);
		sp2.addSubSubProject(ssp4);
		p2.addSubProject(sp2);
		s.addProject(p2);
		
		studentRepository.save(s);
	}

}
