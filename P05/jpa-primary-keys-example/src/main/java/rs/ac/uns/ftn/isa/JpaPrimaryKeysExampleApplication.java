package rs.ac.uns.ftn.isa;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import rs.ac.uns.ftn.isa.natural.MesnaZajednica;
import rs.ac.uns.ftn.isa.natural.MesnaZajednicaPK;
import rs.ac.uns.ftn.isa.natural.NaseljenoMesto;
import rs.ac.uns.ftn.isa.surrogate.PrimerCustomSequence;
import rs.ac.uns.ftn.isa.surrogate.PrimerHibernateUUID;
import rs.ac.uns.ftn.isa.surrogate.PrimerIdentity;
import rs.ac.uns.ftn.isa.surrogate.PrimerSequence;
import rs.ac.uns.ftn.isa.surrogate.PrimerTable;
import rs.ac.uns.ftn.isa.surrogate.PrimerUUID;

@SpringBootApplication
public class JpaPrimaryKeysExampleApplication {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		SpringApplication.run(JpaPrimaryKeysExampleApplication.class, args);

		Logger.getLogger("").setLevel(Level.OFF);
		final EntityManagerFactory factory =
				Persistence.createEntityManagerFactory("KeyDemo");

		EntityManager em = factory.createEntityManager();

		/*
	      Kreiranje objekata sa surogatnim kljucem: vrednost kljuca se
	      ne definise prilikom kreiranja objekta, vec prilikom inserta
	      u bazu podataka.
		 */
		PrimerIdentity p1 = new PrimerIdentity();
		p1.setName("ABC");
		PrimerSequence p2 = new PrimerSequence();
		p2.setName("DEF");
		PrimerCustomSequence p3 = new PrimerCustomSequence();
		p3.setName("GHI");
		PrimerCustomSequence p4 = new PrimerCustomSequence();
		p4.setName("JKL");
		PrimerTable p5 = new PrimerTable();
		p5.setName("MNO");
		PrimerUUID p6 = new PrimerUUID();
		p6.setName("PRS");
		PrimerHibernateUUID p7 = new PrimerHibernateUUID();
		p7.setName("TXY");

		/*
	      Kreiranje objekata sa prirodnim kljucem: vrednost kljuca se
	      mora definisati pre inserta u bazu podataka.
		 */

		NaseljenoMesto naseljenoMesto = new NaseljenoMesto("SRB", "21000", "Novi Sad");
		MesnaZajednica mesnaZajednica = new MesnaZajednica(new MesnaZajednicaPK("1", "Liman"), "021-555-333"); // \m/

		em.getTransaction().begin();

		System.out.println("\n===== SURROGATE =====");
		em.persist(p1);
		em.persist(p2);
		em.persist(p3);
		em.persist(p4);
		em.persist(p5);
		em.persist(p6);
		em.persist(p7);
		System.out.println("Dodato 7 objekta sa surogatnim kljucevima.");
		em.getTransaction().commit();

		

		System.out.println("\n===== NATURAL =====");
		em.getTransaction().begin();
		em.persist(naseljenoMesto);
		em.persist(mesnaZajednica);
		em.getTransaction().commit();

		// pronadjemo naseljeno mesto u bazi sa ptt brojem 21000
		Query queryNM = em.createQuery("SELECT nm FROM NaseljenoMesto nm WHERE nm.pttBroj=?1");
		queryNM.setParameter(1, "21000");
		List<NaseljenoMesto> listNM = queryNM.getResultList();
		System.out.println("Pronadjeni objekti:");
		for (NaseljenoMesto nm: listNM)
			System.out.println(nm);

		Query queryMZ = em.createQuery("SELECT mz FROM MesnaZajednica mz WHERE mz.kljuc.naziv=?1");
		queryMZ.setParameter(1, "Liman");
		List<MesnaZajednica> listMZ = queryMZ.getResultList();
		System.out.println("Pronadjeni objekti:");
		for (MesnaZajednica nm: listMZ)
			System.out.println(nm);

		em.getTransaction().begin();
		// obrisemo mesne zajednice sa rednim brojem 1
		Query q = em.createQuery("DELETE MesnaZajednica mz WHERE mz.kljuc.redniBroj = '1'");
		int deleted = q.executeUpdate();
		// obrisemo naseljena mesta sa ptt brojem 21000
		q = em.createQuery("DELETE NaseljenoMesto nm WHERE nm.pttBroj = '21000'");
		deleted += q.executeUpdate();
		em.getTransaction().commit();
		System.out.println("Obrisano: " + deleted + " objekata.");

		em.close();
		//System.exit(0);
	}

}
