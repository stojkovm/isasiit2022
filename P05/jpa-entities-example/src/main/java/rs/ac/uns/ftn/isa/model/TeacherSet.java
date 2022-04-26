package rs.ac.uns.ftn.isa.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

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
public class TeacherSet implements Serializable {

	private static final long serialVersionUID = -2457432433073316254L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "firstName", nullable = false)
	private String firstName;

	@Column(name = "lastName", nullable = false)
	private String lastName;

	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(name = "teaching_set", joinColumns = @JoinColumn(name = "course_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "teacher_id", referencedColumnName = "id"))
	private Set<CourseSet> courses = new HashSet<CourseSet>();
	
	public TeacherSet() {
		
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

	public Set<CourseSet> getCourses() {
		return courses;
	}

	public void setCourses(Set<CourseSet> courses) {
		this.courses = courses;
	}
	
	public void addCourse(CourseSet course) {
        this.courses.add(course);
        course.getTeachers().add(this);
    }

    public void removeCourse(CourseSet course) {
        this.courses.remove(course);
        course.getTeachers().remove(this);
    }

    public void removeCourses() {
        Iterator<CourseSet> iterator = this.courses.iterator();

        while (iterator.hasNext()) {
            CourseSet course = iterator.next();

            course.getTeachers().remove(this);
            iterator.remove();
        }
    }

    /*
     * Hibernate zahteva da entitet mora biti jednak samom sebi kroz sva stanja
     * (transient!!!, managed, detached, removed). Za proveru izmene entiteta Hibernate koristi svoj
     * dirty checking mehanizam koji ne koristi equals i hashCode, ali ako se entiteti cuvaju u Setu
     * ili se radi njihov reattach u novi Persistence Context, treba uraditi override equals i hashCode metoda.
     * Takodje, kada se radi sync obe strane bidirekcionalne veze pomocu pomocnih metoda treba uraditi override equals i hashCode metoda.
     * 
     * Ukoliko se za equals i hashCode koriste neki jedinstveni atributi koje korisnik zna unapred, override ce raditi kako treba.
     * Problem nastaje ako se za equals i hashCode oslanjamo na jedinstveni kljuc koji generise baza.
     * Posto je to vrednost koja se dobija naknadno, entiteti mogu imati razlicite ID vrednosti u razlicitim stanjima:
     * null u transient stanju i ne null u managed, detached i removed stanju.
     * Dva objekta smatramo jednakim ako je njihov ID ne null i ako su im jednake ID vrednosti.
     * To znaci da dva objekta u transient stanju (imaju ID null jer baza jos uvek nije generisala kljuc za njih),
     * mogu biti jednaki samo ako referenciraju isti objekat. To mozemo postici ako hashCode vrati konstantu.
     * Ovaj scenario moze uticati na performanse sistema u slucaju da se radi sa velikim brojem objekata na ovaj nacin.
     */
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

		return id != null && id.equals(((TeacherSet) o).id);
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
