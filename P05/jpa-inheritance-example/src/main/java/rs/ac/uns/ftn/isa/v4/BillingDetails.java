package rs.ac.uns.ftn.isa.v4;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.SequenceGenerator;

/*
 * Prednosti strategije nasledjivanja sa @MappedSuperclass:
 * - Read i Write operacije su brze
 * - alternativa za table per class strategiju ako roditeljska klasa ne mora da bude entitet
 * Mane strategije:
 * - nad roditeljsom klasom se ne mogu vrsiti upiti
 */

@MappedSuperclass
// ovom anotacijom se naglasava da je ova klasa koren hijerarhije koja koristi
// koncept jedna tabela po konkretnoj klasi

public abstract class BillingDetails {

	@Id
	@SequenceGenerator(name = "mySeqGenV4", sequenceName = "mySeqV4", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mySeqGenV4")
	private Integer id;

	@Column(name="owner", unique=false, nullable=false)
	private String owner;

	public BillingDetails() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}
}
