package rs.ac.uns.ftn.isa.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class SubSubProject implements Serializable {

	private static final long serialVersionUID = 3416795085362632024L;

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
	@JoinColumn(name = "sub_project_id")
	private SubProject subProject;

	public SubSubProject() {
		super();
	}

	public SubSubProject(Long id, String name, String programmingLanguage, String description, SubProject subProject) {
		super();
		this.id = id;
		this.name = name;
		this.programmingLanguage = programmingLanguage;
		this.description = description;
		this.subProject = subProject;
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

	public SubProject getSubProject() {
		return subProject;
	}

	public void setSubProject(SubProject subProject) {
		this.subProject = subProject;
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

		return id != null && id.equals(((SubSubProject) o).id);
	}

	@Override
	public int hashCode() {
		return 2020;
	}

	@Override
	public String toString() {
		return "SubSubProject [id=" + id + ", name=" + name + ", programmingLanguage=" + programmingLanguage
				+ ", description=" + description + "]";
	}



}
