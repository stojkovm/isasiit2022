package rs.ac.uns.ftn.isa.repository;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import org.springframework.stereotype.Repository;

import rs.ac.uns.ftn.isa.model.Ocena;
import rs.ac.uns.ftn.isa.model.Predmet;
import rs.ac.uns.ftn.isa.model.Student;

@Repository(value = "DBRepository")
public class DBRepository {

	private List<Student> studenti;
	private List<Predmet> predmeti;
	private List<Ocena> ocene;

	public List<Student> getStudenti() {
		return studenti;
	}

	public List<Predmet> getPredmeti() {
		return predmeti;
	}

	public List<Ocena> getOcene() {
		return ocene;
	}

	public Student getStudent(String indeks) {
		for (Student s: studenti)
			if (s.getIndeks().equalsIgnoreCase(indeks))
				return s;
		return null;
	}

	public Predmet getPredmet(String sifra) {
		for (Predmet p: predmeti)
			if (p.getSifra().equalsIgnoreCase(sifra))
				return p;
		return null;
	}

	public Ocena getOcena(int id) {
		for (Ocena o: ocene)
			if (o.getId() == id)
				return o;
		return null;
	}
	
	public void populate() {
		Student s1 = new Student("e1234", "Pera", "Peric");
		Student s2 = new Student("e1235", "Zika", "Zikic");
		Student s3 = new Student("e1236", "Mita", "Mitic");
		Predmet p1 = new Predmet("SE001", "Uvod u programiranje");
		Predmet p2 = new Predmet("SE002", "Algoritmi i strukture podataka");
		Predmet p3 = new Predmet("SE003", "Operativni sistemi");
		Ocena o1 = new Ocena(s1, p1, new GregorianCalendar(2019, 8, 10).getTime(), 9);
		Ocena o2 = new Ocena(s1, p2, new GregorianCalendar(2019, 8, 11).getTime(), 8);
		Ocena o3 = new Ocena(s1, p3, new GregorianCalendar(2019, 8, 12).getTime(), 10);
		Ocena o4 = new Ocena(s2, p1, new GregorianCalendar(2019, 8, 10).getTime(), 7);
		Ocena o5 = new Ocena(s2, p2, new GregorianCalendar(2019, 8, 11).getTime(), 7);
		Ocena o6 = new Ocena(s2, p3, new GregorianCalendar(2019, 8, 12).getTime(), 8);
		s1.getOcene().add(o1);
		s1.getOcene().add(o2);
		s1.getOcene().add(o3);
		s2.getOcene().add(o4);
		s2.getOcene().add(o5);
		s2.getOcene().add(o6);
		studenti = new ArrayList<>();
		studenti.add(s1);
		studenti.add(s2);
		studenti.add(s3);
		predmeti = new ArrayList<>();
		predmeti.add(p1);
		predmeti.add(p2);
		predmeti.add(p3);
		ocene = new ArrayList<>();
		ocene.add(o1);
		ocene.add(o2);
		ocene.add(o3);
		ocene.add(o4);
		ocene.add(o5);
		ocene.add(o6);
	}

}
