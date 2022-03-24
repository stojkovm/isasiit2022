package rs.ac.uns.ftn.isa.dao;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.jdbc.DataSourceConnectionSource;

import rs.ac.uns.ftn.isa.domain.Greeting;

@Repository
public class GreetingDAOImpl extends BaseDaoImpl<Greeting, Long> implements GreetingDAO {


	@Autowired
	public GreetingDAOImpl(DataSourceConnectionSource connectionSource)
			throws SQLException {
		super(connectionSource, Greeting.class);
	}
	
	@Override
	public List<Greeting> queryForAll() throws SQLException {
		return super.queryForAll();
	}

	@Override
	public Greeting createIfNotExists(Greeting greeting) throws SQLException {
		return super.createIfNotExists(greeting);
	}

	@Override
	public Greeting queryForId(Long id) throws SQLException {
		return super.queryForId(id);
	}
	
	@Override
	public int update(Greeting greeting) throws SQLException {
		return super.update(greeting);
	}

	@Override
	public int deleteById(Long id) throws SQLException {
		return super.deleteById(id);
	}


	

}
