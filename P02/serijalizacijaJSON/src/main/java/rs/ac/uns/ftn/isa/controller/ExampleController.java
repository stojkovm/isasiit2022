package rs.ac.uns.ftn.isa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import rs.ac.uns.ftn.isa.model.Ocena;
import rs.ac.uns.ftn.isa.model.Student;
import rs.ac.uns.ftn.isa.repository.DBRepository;
import rs.ac.uns.ftn.isa.serializers.Json1Serializer;
import rs.ac.uns.ftn.isa.serializers.Json2Serializer;

@RestController
@RequestMapping("/api")
public class ExampleController {

	@Autowired
	private DBRepository dbRepository;

	@GetMapping(value = "/studenti", produces = "application/json")
	public String getStudenti(@RequestParam String format) {
		List<Student> s = dbRepository.getStudenti();
		String f = "json1";
		if (format != null)
			f = format;
		switch(f) {
		case "json":
		case "json1":
			return Json1Serializer.serialize(s, "student");
		case "json2":
			return Json1Serializer.serialize(s, "student|ocene");
		default:
			return "";
		}
	}

	@GetMapping(value = "/studenti/{index}", produces = "application/json")
	public String getStudent(@RequestParam String format, @PathVariable("index") String index) {
	    Student s = dbRepository.getStudent(index);
	    if (s == null) {
	      return "";
	    }
	    String f = "json1";
	    if (format != null)
	      f = format;
	    switch(f) {
	      case "json":
	      case "json1":
	        return Json1Serializer.serialize(s, "student");
	      case "json2":
	        return Json1Serializer.serialize(s, "student|ocene");
	      default:
	        return "";
	    }
	  }


	@GetMapping(value = "/ocene/{ocena}", produces = "application/json")
	public String getOcena(@RequestParam String format, @PathVariable("ocena") Integer ocena) {
		Ocena o = dbRepository.getOcena(ocena);
	    if (o == null) {
	    	return "";
	    }
		String f = "json1";
		if (format != null)
			f = format;
		switch(f) {
		case "json":
		case "json1":
			return Json1Serializer.serialize(o, "ocene");
		case "json2":
			return Json2Serializer.serialize(o, "ocene");
		default:
			return "";
		}
	}

	@GetMapping(value = "/ocene", produces = "application/json")
	public String getOcene(@RequestParam String format) {
		List<Ocena> ocene = dbRepository.getOcene();
		String f = "json1";
		if (format != null)
			f = format;
		switch(f) {
		case "json":
		case "json1":
			return Json1Serializer.serialize(ocene, "ocene");
		case "json2":
			return Json2Serializer.serialize(ocene, "ocene");
		default:
			return "";
		}
	}

}
