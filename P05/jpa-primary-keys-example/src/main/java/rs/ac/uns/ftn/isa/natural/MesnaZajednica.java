package rs.ac.uns.ftn.isa.natural;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="MESNAZAJEDNICA")
public class MesnaZajednica implements Serializable {

	@EmbeddedId
	private MesnaZajednicaPK kljuc;

	@Column(name="broj_telefona", unique=true, nullable=false)
	private String brojTelefona;


	public MesnaZajednica(MesnaZajednicaPK kljuc, String brojTelefona) {
		this.kljuc = kljuc;
		this.brojTelefona = brojTelefona;
	}

	public MesnaZajednica() {
	}

	public MesnaZajednicaPK getKljuc() {
		return kljuc;
	}

	public void setMesnaZajednicaPK(MesnaZajednicaPK kljuc) {
		this.kljuc = kljuc;
	}

	public String getBrojTelefona() {
		return brojTelefona;
	}

	public void setBrojTelefona(String brojTelefona) {
		this.brojTelefona = brojTelefona;
	}

	@Override
	public String toString() {
		return "MesnaZajednica [kljuc=" + kljuc + ", brojTelefona="
				+ brojTelefona + "]";
	}

	private static final long serialVersionUID = -8435959221660198218L;
}
