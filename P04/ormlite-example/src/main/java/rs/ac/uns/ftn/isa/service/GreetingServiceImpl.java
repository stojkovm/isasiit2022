package rs.ac.uns.ftn.isa.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.ac.uns.ftn.isa.dao.GreetingDAOImpl;
import rs.ac.uns.ftn.isa.domain.Greeting;

@Service
public class GreetingServiceImpl implements GreetingService {
	
	private static final Logger logger = LoggerFactory.getLogger(GreetingServiceImpl.class);

	@Autowired
	private GreetingDAOImpl greetingDAO;

	@Override
	public List<Greeting> findAll() {
		List<Greeting> greetings = new ArrayList<Greeting>();
		try {
			greetings = greetingDAO.queryForAll();
		} catch (SQLException e) {
			logger.error("Database communication error!");
		}
		return greetings;
	}

	@Override
	public Greeting findOne(Long id) {
		Greeting greeting = new Greeting();
		try {
			greeting = greetingDAO.queryForId(id);
		} catch (SQLException e) {
			logger.error("Database communication error!");
		}
		return greeting;
	}

	@Override
	public Greeting create(Greeting greeting) {
		try {
			return greetingDAO.createIfNotExists(greeting);
		} catch (SQLException e) {
			logger.error("Database communication error!");
		}
		return null;

	}

	@Override
	public int update(Greeting greeting) {
		
		try {
			Greeting greetingToUpdate = findOne(greeting.getId());
			greetingToUpdate.setText(greeting.getText());
			return greetingDAO.update(greetingToUpdate);
		} catch (SQLException e) {
			logger.error("Database communication error!");
		}
		return -1;
	}

	@Override
	public void delete(Long id) {
		try {
			greetingDAO.deleteById(id);
		} catch (SQLException e) {
			logger.error("Database communication error!");
		}
	}

}
