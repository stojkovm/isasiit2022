package rs.ac.uns.ftn.isa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import rs.ac.uns.ftn.isa.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
	
	@EntityGraph(value = "student-projects-subprojects-graph",
            type = EntityGraph.EntityGraphType.FETCH)
	@Query(value = "SELECT s FROM Student s")
	List<Student> fetchAllNestedCollections();

}
