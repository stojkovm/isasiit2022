package rs.ac.uns.ftn.isa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import rs.ac.uns.ftn.isa.model.Project;

public interface ProjectRepository extends JpaRepository<Project, Integer>{
	
	@Query(value = "SELECT p FROM Project p JOIN FETCH p.student s WHERE p.id = ?1")
    Project fetchProjectWithStudent(Integer id);

}
