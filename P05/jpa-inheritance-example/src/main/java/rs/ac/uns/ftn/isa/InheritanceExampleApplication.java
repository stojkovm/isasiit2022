package rs.ac.uns.ftn.isa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import rs.ac.uns.ftn.isa.repository.BankAccountV1Repository;
import rs.ac.uns.ftn.isa.repository.BankAccountV2Repository;
import rs.ac.uns.ftn.isa.repository.BankAccountV3Repository;
import rs.ac.uns.ftn.isa.repository.BankAccountV4Repository;
import rs.ac.uns.ftn.isa.repository.BillingDetailsV1Repository;
import rs.ac.uns.ftn.isa.repository.CreditCardV1Repository;
import rs.ac.uns.ftn.isa.repository.CreditCardV2Repository;
import rs.ac.uns.ftn.isa.repository.CreditCardV3Repository;
import rs.ac.uns.ftn.isa.repository.CreditCardV4Repository;
import rs.ac.uns.ftn.isa.v1.BankAccount;
import rs.ac.uns.ftn.isa.v1.BillingDetails;
import rs.ac.uns.ftn.isa.v1.CreditCard;

@SpringBootApplication
public class InheritanceExampleApplication implements CommandLineRunner {

	@Autowired
	private BillingDetailsV1Repository repbd1;
	
	@Autowired
	private BankAccountV1Repository repbav1;

	@Autowired
	private BankAccountV2Repository repbav2;

	@Autowired
	private BankAccountV3Repository repbav3;

	@Autowired
	private BankAccountV4Repository repbav4;

	@Autowired
	private CreditCardV1Repository repccv1;

	@Autowired
	private CreditCardV2Repository repccv2;

	@Autowired
	private CreditCardV3Repository repccv3;

	@Autowired
	private CreditCardV4Repository repccv4;

	public static void main(String[] args) {
		SpringApplication.run(InheritanceExampleApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		//--------V1--------
		BillingDetails bd1 = new BillingDetails();
		bd1.setOwner("Mika Mikic");
		repbd1.save(bd1);
		
		BankAccount bav11 = new BankAccount();
		bav11.setBankName("Banka 1");
		bav11.setNumber("111-1234567-89");
		bav11.setOwner("Pera Peric");
		bav11.setSwift("ABCRSBG");
		repbav1.save(bav11);

		CreditCard ccv11 = new CreditCard();
		ccv11.setExpMonth("12");
		ccv11.setExpYear("2025");
		ccv11.setNumber("1234-1234-1234-1234");
		ccv11.setOwner("Pera Peric");
		repccv1.save(ccv11);

		BankAccount bav12 = new BankAccount();
		bav12.setBankName("Banka 2");
		bav12.setNumber("222-1234567-89");
		bav12.setOwner("Pera Peric");
		bav12.setSwift("DEFRSBG");
		repbav1.save(bav12);


		//--------V2--------
		rs.ac.uns.ftn.isa.v2.BankAccount bav21 = new rs.ac.uns.ftn.isa.v2.BankAccount();
		bav21.setBankName("Banka 1");
		bav21.setNumber("111-1234567-89");
		bav21.setOwner("Pera Peric");
		bav21.setSwift("ABCRSBG");
		repbav2.save(bav21);

		rs.ac.uns.ftn.isa.v2.CreditCard ccv21 = new rs.ac.uns.ftn.isa.v2.CreditCard();
		ccv21.setExpMonth("12");
		ccv21.setExpYear("2025");
		ccv21.setNumber("1234-1234-1234-1234");
		ccv21.setOwner("Pera Peric");
		repccv2.save(ccv21);

		//--------V3--------
		rs.ac.uns.ftn.isa.v3.BankAccount bav31 = new rs.ac.uns.ftn.isa.v3.BankAccount();
		bav31.setBankName("Banka 1");
		bav31.setNumber("111-1234567-89");
		bav31.setOwner("Pera Peric");
		bav31.setSwift("ABCRSBG");
		repbav3.save(bav31);

		rs.ac.uns.ftn.isa.v3.CreditCard ccv31 = new rs.ac.uns.ftn.isa.v3.CreditCard();
		ccv31.setExpMonth("12");
		ccv31.setExpYear("2025");
		ccv31.setNumber("1234-1234-1234-1234");
		ccv31.setOwner("Pera Peric");
		repccv3.save(ccv31);

		//--------V4--------
		rs.ac.uns.ftn.isa.v4.BankAccount bav41 = new rs.ac.uns.ftn.isa.v4.BankAccount();
		bav41.setBankName("Banka 1");
		bav41.setNumber("111-1234567-89");
		bav41.setOwner("Pera Peric");
		bav41.setSwift("ABCRSBG");
		repbav4.save(bav41);

		rs.ac.uns.ftn.isa.v4.CreditCard ccv41 = new rs.ac.uns.ftn.isa.v4.CreditCard();
		ccv41.setExpMonth("12");
		ccv41.setExpYear("2025");
		ccv41.setNumber("1234-1234-1234-1234");
		ccv41.setOwner("Pera Peric");
		repccv4.save(ccv41);

		rs.ac.uns.ftn.isa.v4.BankAccount bav42 = new rs.ac.uns.ftn.isa.v4.BankAccount();
		bav42.setBankName("Banka 2");
		bav42.setNumber("222-1234567-89");
		bav42.setOwner("Pera Peric");
		bav42.setSwift("DEFRSBG");
		repbav4.save(bav42);


	}
}
