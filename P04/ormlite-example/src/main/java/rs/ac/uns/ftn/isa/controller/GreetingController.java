package rs.ac.uns.ftn.isa.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rs.ac.uns.ftn.isa.domain.Greeting;
import rs.ac.uns.ftn.isa.service.GreetingService;

@RestController
@RequestMapping("/api/greetings")
public class GreetingController {

	@Autowired
	private GreetingService greetingService;

	/*
	 * url: /api/greetings GET
	 */
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<Greeting>> getGreetings() {
		Collection<Greeting> greetings = greetingService.findAll();
		return new ResponseEntity<Collection<Greeting>>(greetings, HttpStatus.OK);
	}

	/*
	 * url: /api/greetings/1 GET
	 */
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Greeting> getGreeting(@PathVariable("id") Long id) {
		Greeting greeting = greetingService.findOne(id);

		if (greeting == null) {
			return new ResponseEntity<Greeting>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Greeting>(greeting, HttpStatus.OK);
	}

	/*
	 * url: /api/greetings POST
	 */
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Greeting> createGreeting(@RequestBody Greeting greeting) throws Exception {
		Greeting savedGreeting = greetingService.create(greeting);
		return new ResponseEntity<Greeting>(savedGreeting, HttpStatus.CREATED);
	}

	/*
	 * url: /api/greetings/1 PUT
	 */
	@PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Greeting> updateGreeting(@RequestBody Greeting greeting, @PathVariable Long id)
			throws Exception {
		Greeting greetingForUpdate = greetingService.findOne(id);
		greetingForUpdate.copyValues(greeting);

		int check = greetingService.update(greetingForUpdate);

		if (check == -1) {
			return new ResponseEntity<Greeting>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		greetingForUpdate = greetingService.findOne(id);
		return new ResponseEntity<Greeting>(greetingForUpdate, HttpStatus.OK);
	}

	/*
	 * url: /api/greetings/1 DELETE
	 */
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Greeting> deleteGreeting(@PathVariable("id") Long id) {
		greetingService.delete(id);
		return new ResponseEntity<Greeting>(HttpStatus.NO_CONTENT);
	}

}
