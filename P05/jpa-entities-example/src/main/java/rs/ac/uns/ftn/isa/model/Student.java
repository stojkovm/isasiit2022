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
import javax.persistence.OneToMany;

/*
 * Efikasnost asocijacija:
 * 
 * One-To-One:
 * - Unidirekcione/bidirekcione @OneToOne veze sa @MapsId su efikasne
 * - Bidirekcione @OneToOne bez @MapsId su manje efikasne
 * 
 * One-To-Many:
 * - Bidirekcione @OneToMany i unidirekcione @ManyToOne su efikasne
 * - Unidirekcione @OneToMany sa Set kolekcijom su manje efikasne
 * - Unidirekcione @OneToMany sa List kolekcijom su prilično neefikasne
 * 
 * Many-To-Many:
 * - Unidirekcione/bidirekcione @ManyToMany sa Set kolekcijom su efikasne
 * - Unidirekcione/bidirekcione @ManyToMany sa List kolekcijom su prilično neefikasne
 */

@Entity
public class Student implements Serializable {
	
	private static final long serialVersionUID = -4356825398598425756L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "indexNumber", unique = true, nullable = false)
	private String index;

	@Column(name = "firstName", nullable = false)
	private String firstName;

	@Column(name = "lastName", nullable = false)
	private String lastName;
	
	/*
	 * Uvek treba raditi cascade sa strane vlasnika veze jer je on taj od kojeg zavise povezani entiteti.
	 * Treba biti pažljiv sa cascade.ALL ako je u pitanju many-to-many veza da se recimo projekat ne obriše ako sa istog uklonimo studenta
	 * fetch za one-to-many je podrazumevano podesen na lazy
	 */
	@OneToMany(mappedBy = "student", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<Project> projects = new HashSet<Project>();

	public Student() {
		super();
	}

	public Student(Integer id, String index, String firstName, String lastName, Set<Project> projects) {
		super();
		this.id = id;
		this.index = index;
		this.firstName = firstName;
		this.lastName = lastName;
		this.projects = projects;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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
	
	/*
	 * Pomocnim metodama se obe strane mogu drzati sinhronizovanim.
	 */
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
