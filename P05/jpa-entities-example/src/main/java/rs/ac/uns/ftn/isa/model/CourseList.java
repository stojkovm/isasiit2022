package rs.ac.uns.ftn.isa.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class CourseList implements Serializable {

	private static final long serialVersionUID = 5342178890085694307L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "name", nullable = false)
	private String name;

	@ManyToMany(mappedBy = "courses")
	private List<TeacherList> teachers = new ArrayList<TeacherList>();
	
	public CourseList() {
		
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

	public List<TeacherList> getTeachers() {
		return teachers;
	}

	public void setTeachers(List<TeacherList> teachers) {
		this.teachers = teachers;
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

		return id != null && id.equals(((CourseList) o).id);
	}

	@Override
	public int hashCode() {
		return 2021;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + "]";
	}
}
