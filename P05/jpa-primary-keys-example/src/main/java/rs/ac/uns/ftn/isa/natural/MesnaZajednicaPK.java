package rs.ac.uns.ftn.isa.natural;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class MesnaZajednicaPK implements Serializable {

	@Column(name="redni_broj")
	private String redniBroj;

	@Column(name="naziv")
	private String naziv;

	public boolean equals(Object o) {
		if (o instanceof MesnaZajednicaPK) {
			MesnaZajednicaPK x = (MesnaZajednicaPK)o;
			return this.redniBroj.equals(x.redniBroj) && this.naziv.equals(x.naziv);
		} else
			return false;
	}

	public int hashCode() {
		return redniBroj.hashCode() + naziv.hashCode();
	}

	public MesnaZajednicaPK(String redniBroj, String naziv) {
		this.redniBroj = redniBroj;
		this.naziv = naziv;
	}

	public MesnaZajednicaPK() {
	}

	public String getRedniBroj() {
		return redniBroj;
	}

	public void setRedniBroj(String redniBroj) {
		this.redniBroj = redniBroj;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	@Override
	public String toString() {
		return "MesnaZajednicaPK [redniBroj=" + redniBroj + ", naziv=" + naziv + "]";
	}



	private static final long serialVersionUID = 8971191714268379062L;
}
