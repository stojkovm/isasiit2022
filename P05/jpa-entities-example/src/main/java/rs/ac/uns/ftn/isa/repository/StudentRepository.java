package rs.ac.uns.ftn.isa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import rs.ac.uns.ftn.isa.model.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {
	
	@Query(value = "SELECT s FROM Student s JOIN FETCH s.projects p WHERE s.id = ?1")
    Student fetchStudentWithProjects(Integer id);

}
