package rs.ac.uns.ftn.isa.jdbc;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertThat;


import java.util.List;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import rs.ac.uns.ftn.isa.jdbc.domain.User;
import rs.ac.uns.ftn.isa.jdbc.repository.UserRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class JdbcExampleApplicationTests {
	
	private static final int DB_COUNT = 3;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void findAllUsers() {
        List<User> users = userRepository.findAll();
        assertNotNull(users);
        assertTrue(!users.isEmpty());
    }

    @Test
    public void findUserById() {
        User user = userRepository.findUserById(1);
        assertNotNull(user);
    }

    @Test
    public void createUser() {
        User user = new User(0, "Vasa", "vasa@gmail.com");
        User savedUser = userRepository.create(user);
        User newUser = userRepository.findUserById(savedUser.getId());
        assertNotNull(newUser);
        assertEquals("Vasa", newUser.getName());
        assertEquals("vasa@gmail.com", newUser.getEmail());
        
        List<User> users = userRepository.findAll();
        assertThat(users.size(), Matchers.is(DB_COUNT + 1));
    }

}
