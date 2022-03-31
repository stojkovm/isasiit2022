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
public class Project implements Serializable {

	private static final long serialVersionUID = -9014877855106637859L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column
	private String name;

	@Column
	private String programmingLanguage;

	@Column
	private String description;

	/*
	 * fetch za many-to-one je podrazumevano podesen na eager, pa moramo eksplicitno da podesimo na lazy
	 * ako ne zelimo da kada dobavljamo podatke o projektu dobavimo i podatke o studentu
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "student_id")
	private Student student;

	public Project() {
		super();
	}

	public Project(Integer id, String name, String programmingLanguage, String description, Student student) {
		super();
		this.id = id;
		this.name = name;
		this.programmingLanguage = programmingLanguage;
		this.description = description;
		this.student = student;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

	/*
	 * Treba povesti racuna da se povezani entiteti ne nadju u toString metodi jer ce se praviti dodatni upit
	 * da se dobave i ti entiteti a kako je fetch postavljen na lazy dobice se LazyInitializationException
	 */
	@Override
	public String toString() {
		return "Project [id=" + id + ", name=" + name + ", programmingLanguage=" + programmingLanguage
				+ ", description=" + description + "]";
	}

}
