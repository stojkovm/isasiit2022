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
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.NamedSubgraph;
import javax.persistence.OneToMany;

@Entity
@NamedEntityGraph(
		name = "student-projects-subprojects-graph",
		attributeNodes = {
				@NamedAttributeNode(value = "projects", subgraph = "projects.subprojects")
		},
		subgraphs = {
				@NamedSubgraph(
						name = "projects.subprojects",
						attributeNodes = {
								@NamedAttributeNode(value = "subProjects", subgraph = "subprojects.subsubprojects")
						}
						),
				@NamedSubgraph(
						name = "subprojects.subsubprojects",
						attributeNodes = {
								@NamedAttributeNode(value = "subSubProjects")
						}
						)
		}
		)
public class Student implements Serializable {

	private static final long serialVersionUID = -4356825398598425756L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "indexNumber", unique = true, nullable = false)
	private String index;

	@Column(name = "firstName", nullable = false)
	private String firstName;

	@Column(name = "lastName", nullable = false)
	private String lastName;

	@OneToMany(mappedBy = "student", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<Project> projects = new HashSet<Project>();

	public Student() {
		super();
	}

	public Student(Long id, String index, String firstName, String lastName, Set<Project> projects) {
		super();
		this.id = id;
		this.index = index;
		this.firstName = firstName;
		this.lastName = lastName;
		this.projects = projects;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIndex() {
		return index;
	}

	public void setIndex(String index) {
		this.index = index;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Set<Project> getProjects() {
		return projects;
	}

	public void setProjects(Set<Project> projects) {
		this.projects = projects;
	}

	public void addProject(Project project) {
		this.projects.add(project);
		project.setStudent(this);
	}

	public void removeProject(Project project) {
		this.projects.remove(project);
		project.setStudent(null);
	}

	public void removeProjects() {
		Iterator<Project> iterator = this.projects.iterator();

		while (iterator.hasNext()) {
			Project project = iterator.next();

			project.setStudent(null);
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

		return id != null && id.equals(((Student) o).id);
	}

	@Override
	public int hashCode() {
		return 2020;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", index=" + index + ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}

}
