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
public class Project implements Serializable {

	private static final long serialVersionUID = -9014877855106637859L;

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
	@JoinColumn(name = "student_id")
	private Student student;

	@OneToMany(mappedBy = "project", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<SubProject> subProjects = new HashSet<SubProject>();

	public Project() {
		super();
	}

	public Project(Long id, String name, String programmingLanguage, String description, Student student, Set<SubProject> subprojects) {
		super();
		this.id = id;
		this.name = name;
		this.programmingLanguage = programmingLanguage;
		this.description = description;
		this.student = student;
		this.subProjects = subprojects;
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

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}


	public Set<SubProject> getSubProjects() {
		return subProjects;
	}

	public void setSubProjects(Set<SubProject> subProjects) {
		this.subProjects = subProjects;
	}

	public void addSubProject(SubProject project) {
		this.subProjects.add(project);
		project.setProject(this);
	}

	public void removeSubProject(SubProject project) {
		this.subProjects.remove(project);
		project.setProject(null);
	}

	public void removeSubProjects() {
		Iterator<SubProject> iterator = this.subProjects.iterator();

		while (iterator.hasNext()) {
			SubProject project = iterator.next();

			project.setProject(null);
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

		return id != null && id.equals(((Project) o).id);
	}

	@Override
	public int hashCode() {
		return 2020;
	}

	@Override
	public String toString() {
		return "Project [id=" + id + ", name=" + name + ", programmingLanguage=" + programmingLanguage
				+ ", description=" + description + "]";
	}

}
