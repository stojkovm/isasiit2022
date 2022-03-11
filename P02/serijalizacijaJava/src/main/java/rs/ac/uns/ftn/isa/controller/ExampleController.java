package rs.ac.uns.ftn.isa.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rs.ac.uns.ftn.isa.model.Ocena;
import rs.ac.uns.ftn.isa.model.Student;
import rs.ac.uns.ftn.isa.repository.DBRepository;

@RestController
@RequestMapping("/api")
public class ExampleController {

	@Autowired
	private DBRepository dbRepository;

	@GetMapping(value = "/studenti", produces = "application/x-java-object; type=java.util.List")
	public byte[] getStudenti() {
		List<Student> s = dbRepository.getStudenti();
		return write(s);
	}
	
	@GetMapping(value = "/ocene", produces = "application/x-java-object; type=java.util.List")
	public byte[] getOcene() {
		List<Ocena> o = dbRepository.getOcene();
		return write(o);
	}

	private static byte[] write(Object obj) {
		ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
		try (ObjectOutputStream objectOut = new ObjectOutputStream(byteOut)) {
			objectOut.writeObject(obj);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return byteOut.toByteArray();
	}

}
