package rs.ac.uns.ftn.isa.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class SubProject implements Serializable {

	private static final long serialVersionUID = -9054711853281415224L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	private String name;

	@Column
	private String programmingLanguage;

	@Column
	private String description;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "project_id")
	private Project project;

	@OneToMany(mappedBy = "subProject", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<SubSubProject> subSubProjects = new HashSet<SubSubProject>();

	public SubProject() {
		super();
	}

	public SubProject(Long id, String name, String programmingLanguage, String description, Project project, Set<SubSubProject> subSubProjects) {
		super();
		this.id = id;
		this.name = name;
		this.programmingLanguage = programmingLanguage;
		this.description = description;
		this.project = project;
		this.subSubProjects = subSubProjects;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProgrammingLanguage() {
		return programmingLanguage;
	}

	public void setProgrammingLanguage(String programmingLanguage) {
		this.programmingLanguage = programmingLanguage;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public Set<SubSubProject> getSubSubProjects() {
		return subSubProjects;
	}

	public void setSubSubProjects(Set<SubSubProject> subSubProjects) {
		this.subSubProjects = subSubProjects;
	}

	public void addSubSubProject(SubSubProject project) {
		this.subSubProjects.add(project);
		project.setSubProject(this);
	}

	public void removeSubSubProject(SubSubProject project) {
		this.subSubProjects.remove(project);
		project.setSubProject(null);
	}

	public void removeSubProjects() {
		Iterator<SubSubProject> iterator = this.subSubProjects.iterator();

		while (iterator.hasNext()) {
			SubSubProject project = iterator.next();

			project.setSubProject(null);
			iterator.remove();
		}
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}

		if (o == null) {
			return false;
		}

		if (getClass() != o.getClass()) {
			return false;
		}

		return id != null && id.equals(((SubProject) o).id);
	}

	@Override
	public int hashCode() {
		return 2020;
	}

	@Override
	public String toString() {
		return "SubProject [id=" + id + ", name=" + name + ", programmingLanguage=" + programmingLanguage
				+ ", description=" + description + "]";
	}



}
