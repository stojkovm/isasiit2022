package rs.ac.uns.ftn.isa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import rs.ac.uns.ftn.isa.repository.DBRepository;

@SpringBootApplication
public class SerijalizacijaProtoApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(SerijalizacijaProtoApplication.class, args);
		DBRepository dbRepository = (DBRepository) ctx.getBean("DBRepository");
		dbRepository.populate();
	}

}
