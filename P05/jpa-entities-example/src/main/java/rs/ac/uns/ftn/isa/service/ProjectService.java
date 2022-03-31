package rs.ac.uns.ftn.isa.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.ac.uns.ftn.isa.model.Project;
import rs.ac.uns.ftn.isa.repository.ProjectRepository;

@Service
@Transactional
public class ProjectService {
	
	@Autowired
	private ProjectRepository projectRepository;
	
	public Project fetchProjectWithStudent(Integer id) {
		return projectRepository.fetchProjectWithStudent(id);
	}

}
