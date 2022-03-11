package rs.ac.uns.ftn.isa;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import rs.ac.uns.ftn.isa.model.Ocena;

@SpringBootApplication
public class SerijalizacijaJava2Application {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		SpringApplication.run(SerijalizacijaJava2Application.class, args);
		
		RestTemplate rTemplate = new RestTemplate();
		String resourceUrl = "http://localhost:8080/api/ocene";
		ResponseEntity<byte[]> resp = rTemplate.exchange(resourceUrl, HttpMethod.GET, null, new ParameterizedTypeReference<byte[]>(){});
		
		//----Java Serialization START----
		ByteArrayInputStream in = new ByteArrayInputStream(resp.getBody());
		ObjectInputStream is;
		List<Ocena> ocene = new ArrayList<Ocena>();
		try {
			is = new ObjectInputStream(in);
			ocene = (List<Ocena>) is.readObject();
			
			System.out.println(ocene.get(0).getStudent() == ocene.get(1).getStudent());
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
		//---Java Serialization END---
		//----Protobuf START----
//		try {
//			Ocene ocBuf = Ocene.parseFrom(resp.getBody());
//			System.out.println(ocBuf.toString());
//			//deserializes as a tree
//			System.out.println(ocBuf.getOcene(0).getStudent() == ocBuf.getOcene(1).getStudent());
//
//			System.out.println(ocBuf.getOcene(0).getStudent());
//			System.out.println(ocBuf.getOcene(1).getStudent());
//		} catch (InvalidProtocolBufferException e) {
//			e.printStackTrace();
//		}
		//----Protobuf END----
	}

}
