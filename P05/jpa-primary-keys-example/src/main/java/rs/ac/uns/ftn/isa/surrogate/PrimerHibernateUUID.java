package rs.ac.uns.ftn.isa.surrogate;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * 
 * Hibernate nudi uuid2 generator koji je u skladu sa rfC 4122 standardom
 * https://www.ietf.org/rfc/rfc4122.txt
 *
 */
@Entity
@Table(name="surrogate_hibernate_uuid")
public class PrimerHibernateUUID {
	
	@Id
	@Column(name="id")
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	private UUID id;

	@Column(name="name")
	private String name;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
