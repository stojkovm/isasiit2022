package rs.ac.uns.ftn.isa.surrogate;

import static javax.persistence.GenerationType.TABLE;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

/**
 * Ova klasa koristi TABLE tip generisanja vrednosti primarnog kljuca. U ovom
 * slucaju koristi se posebna tabela sa potencijalno vise brojaca iz koje se
 * brojevi zahvataju uz pesimisticko zakljucavanje.
 * 
 * Ovaj tip generisanja primarnog kljuca je prenosiv izmedju razlicitih baza
 * podataka, jer se ne oslanja na specificne funkcije pojedinacnih konkretnih
 * baza.
 * 
 * Znacajno je sporija opcija od IDENTITY i SEQUENCE strategija.
 */
@Entity
@Table(name="surrogate_table")
public class PrimerTable {

	@Id
	@GeneratedValue(strategy=TABLE, generator="surrogate_idtable")
	@TableGenerator(
			name="surrogate_idtable", 
			table="surrogate_counters", 
			pkColumnName="counter_name", 
			pkColumnValue="primer", 
			valueColumnName="counter_value", 
			initialValue=0,
			allocationSize=1)
	@Column(name="id")
	private Integer id;

	@Column(name="name")
	private String name;

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
}