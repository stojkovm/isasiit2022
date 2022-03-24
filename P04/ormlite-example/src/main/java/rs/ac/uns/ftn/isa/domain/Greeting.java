package rs.ac.uns.ftn.isa.domain;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import rs.ac.uns.ftn.isa.dao.GreetingDAOImpl;

@DatabaseTable(tableName = "greetings", daoClass = GreetingDAOImpl.class)
public class Greeting {
	
	@DatabaseField(generatedId = true)
    private Long id;
	
	@DatabaseField(canBeNull = false)
    private String text;

	/*
	 * no-args konstruktor je obavezan
	 */
    public Greeting() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
    
    public void copyValues(Greeting greeting) {
    		this.text = greeting.getText();
    }

}
