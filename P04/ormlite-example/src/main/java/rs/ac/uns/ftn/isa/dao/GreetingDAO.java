package rs.ac.uns.ftn.isa.dao;

import java.sql.SQLException;
import java.util.List;

import com.j256.ormlite.dao.Dao;

import rs.ac.uns.ftn.isa.domain.Greeting;

public interface GreetingDAO extends Dao<Greeting, Long>{
	
	public List<Greeting> queryForAll() throws SQLException;

	public Greeting createIfNotExists(Greeting greeting) throws SQLException;

	public Greeting queryForId(Long id) throws SQLException;
	
	public int update(Greeting greeting) throws SQLException;

	public int deleteById(Long id) throws SQLException;

}
