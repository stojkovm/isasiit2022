package rs.ac.uns.ftn.isa.surrogate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;


/**
 * 
 * Primer koriscenja custom generatora za generisanje kljuceva po sablonu.
 *
 */
@Entity
@Table(name="surrogate_custom_sequence")
public class PrimerCustomSequence {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,
	   generator = "custom_seq")
	@GenericGenerator(name = "custom_seq",
	strategy = "rs.ac.uns.ftn.isa.surrogate.CustomSequenceIdGenerator", parameters = {
	      @Parameter(name = CustomSequenceIdGenerator.INITIAL_PARAM,
	                 value = "1"),
	      @Parameter(name = CustomSequenceIdGenerator.INCREMENT_PARAM,
	                 value = "1"),
	      @Parameter(name = CustomSequenceIdGenerator.PREFIX_PARAM,
	                 value = "KEYGEN-"),
	      @Parameter(name = CustomSequenceIdGenerator.NUMBER_FORMAT_PARAM,
	                 value = "%010d")
	} )
	@Column(name="id")
	private String id;

	@Column(name="name")
	private String name;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
