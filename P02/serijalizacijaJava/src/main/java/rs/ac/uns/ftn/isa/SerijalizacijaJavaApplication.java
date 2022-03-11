package rs.ac.uns.ftn.isa;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import rs.ac.uns.ftn.isa.model.Ocena;
import rs.ac.uns.ftn.isa.model.Student;
import rs.ac.uns.ftn.isa.repository.DBRepository;

@SpringBootApplication
public class SerijalizacijaJavaApplication {


	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		ApplicationContext ctx =SpringApplication.run(SerijalizacijaJavaApplication.class, args);
		
		DBRepository dbRepository = (DBRepository) ctx.getBean("DBRepository");
		dbRepository.populate();
		
		RestTemplate rTemplate = new RestTemplate();
		String resourceUrl = "http://localhost:8080/api/studenti";
		ResponseEntity<byte[]> resp = rTemplate.exchange(resourceUrl, HttpMethod.GET, null, new ParameterizedTypeReference<byte[]>(){});
		ByteArrayInputStream in = new ByteArrayInputStream(resp.getBody());
		ObjectInputStream is;
		List<Student> st = new ArrayList<Student>();
		try {
			is = new ObjectInputStream(in);
			st = (List<Student>) is.readObject();
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
		System.out.println(st);
		
		resourceUrl = "http://localhost:8080/api/ocene";
		resp = rTemplate.exchange(resourceUrl, HttpMethod.GET, null, new ParameterizedTypeReference<byte[]>(){});
		in = new ByteArrayInputStream(resp.getBody());
		List<Ocena> ocene = new ArrayList<Ocena>();
		try {
			is = new ObjectInputStream(in);
			ocene = (List<Ocena>) is.readObject();
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
		
		System.out.println(ocene.get(0).getStudent() == ocene.get(1).getStudent());

	}

}
