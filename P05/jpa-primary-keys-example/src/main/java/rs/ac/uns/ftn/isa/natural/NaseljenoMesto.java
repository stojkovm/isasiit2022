package rs.ac.uns.ftn.isa.natural;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name="NASELJENOMESTO")
@IdClass(NaseljenoMestoPK.class)
public class NaseljenoMesto implements Serializable {

	@Id
	@Column(name="drz_sifra", unique=true, nullable=false, length=3)
	private String drzava;

	@Id
	@Column(name="nm_pttbroj", unique=true, nullable=false, length=5)
	private String pttBroj;

	@Column(name="nm_naziv", unique=false, nullable=false, length=50)
	private String naziv;

	public NaseljenoMesto() {
	}

	public NaseljenoMesto(String drzava, String pttBroj, String naziv) {
		this.drzava = drzava;
		this.pttBroj = pttBroj;
		this.naziv = naziv;
	}

	public String getDrzava() {
		return drzava;
	}

	public void setDrzava(String drzava) {
		this.drzava = drzava;
	}

	public String getPttBroj() {
		return pttBroj;
	}

	public void setPttBroj(String pttBroj) {
		this.pttBroj = pttBroj;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	@Override
	public String toString() {
		return "NaseljenoMesto [drzava=" + drzava + ", pttBroj=" + pttBroj
				+ ", naziv=" + naziv + "]";
	}

	private static final long serialVersionUID = 1981675936825251088L;
}
