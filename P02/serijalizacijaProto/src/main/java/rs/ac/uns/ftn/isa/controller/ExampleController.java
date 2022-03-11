package rs.ac.uns.ftn.isa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rs.ac.uns.ftn.isa.messages.OceneProtos.Ocene;
import rs.ac.uns.ftn.isa.messages.OceneProtos.Studenti;
import rs.ac.uns.ftn.isa.repository.DBRepository;

@RestController
@RequestMapping("/api")
public class ExampleController {

	@Autowired
	private DBRepository dbRepository;

	@GetMapping(value = "/studenti", produces = "application/x-protobuf; messageType=\"rs.ac.uns.ftn.isa.messages.Studenti\"")
	public byte[] getStudenti() {
		Studenti s = dbRepository.getStudenti();
		return s.toByteArray();
	}
	
	@GetMapping(value = "/ocene", produces = "application/x-protobuf; messageType=\"rs.ac.uns.ftn.isa.messages.Ocene\"")
	public byte[] getOcene() {
		Ocene o = dbRepository.getOcene();
		return o.toByteArray();
	}

}
