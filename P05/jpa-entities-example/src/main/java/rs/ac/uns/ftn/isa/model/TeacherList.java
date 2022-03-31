package rs.ac.uns.ftn.isa.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class TeacherList implements Serializable {

	private static final long serialVersionUID = -1595464644362074258L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "firstName", nullable = false)
	private String firstName;

	@Column(name = "lastName", nullable = false)
	private String lastName;

	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(name = "teaching_list", joinColumns = @JoinColumn(name = "course_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "teacher_id", referencedColumnName = "id"))
	private List<CourseList> courses = new ArrayList<CourseList>();
	
	public TeacherList() {
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public List<CourseList> getCourses() {
		return courses;
	}

	public void setCourses(List<CourseList> courses) {
		this.courses = courses;
	}
	
	public void addCourse(CourseList course) {
        this.courses.add(course);
        course.getTeachers().add(this);
    }

    public void removeCourse(CourseList course) {
        this.courses.remove(course);
        course.getTeachers().remove(this);
    }

    public void removeCourses() {
        Iterator<CourseList> iterator = this.courses.iterator();

        while (iterator.hasNext()) {
        	CourseList course = iterator.next();

            course.getTeachers().remove(this);
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

		return id != null && id.equals(((TeacherList) o).id);
	}

	@Override
	public int hashCode() {
		return 2021;
	}

	@Override
	public String toString() {
		return "Teacher [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}
}
