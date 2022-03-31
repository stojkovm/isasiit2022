# Primer kreiranja ključeva pomoću Hibernate ORM

Primer demonstrira kreiranje primarnih ključeva pomoću Hibernate ORM.
U primeru se koristi H2 baza podataka.

## Korisne stvari

* [Eclipse](https://www.eclipse.org)
* [IntelliJ IDEA](https://www.jetbrains.com/idea/)

## Pokretanje primera

Iz primera pokrenuti klasu `rs.ac.uns.ftn.isa.JpaPrimaryKeysExampleApplication` iz razvojnog okruženja.

## Sadržaj primera

Paket `rs.ac.uns.ftn.isa.natural` sadrži dva primera kreiranja prirodnih ključeva.
Oba primera zahtevaju da se kreira posebna klasa koja će pobrojati sve atribute koji trebaju da budu deo ključa.
U primeru klasa `MesnaZajednica` i `MesnaZajednicaPK` demonistriran je pristup korišćenja anotacija `@Embeddable` i `@EmbeddedId`.
U Primeru klasa `NaseljenoMesto` i `NaseljenoMestoPK` demonistriran je pristup korišćenja anotacija `@IdClass`.
Pravila koja moraju da vaze za kompozitni kljuc:
* klasa mora biti public
* klasa mora da implementira `Serializable`
* klasa mora da implementira `equals()` i `hashCode()` metode
* klasa mora da ima konstruktor bez parametara

Paket `rs.ac.uns.ftn.isa.surrogate` sadrži klase primere kreiranja veštačkih ključeva.

Klasa `PrimerIdentity` koristi `IDENTITY` tip generisanja vrednosti primarnog kljuca.
Ovaj mehanizam je dostupan u MySQL, DB2, SQL Server, Sybase, i Hypersonic SQL bazama (svaka koristi razlicitu SQL sintaksu prilikom definisanja seme baze).

Klasa `PrimerSequence` koristi `SEQUENCE` tip generisanja vrednosti primarnog kljuca.
Ovaj mehanizam je dostupan u Oracle, DB2, PostgreSQL, SAPDB i McKoi bazama (svaka  koristi razlicitu SQL sintaksu prilikom definisanja seme baze).
Primer vezan za ovaj entity podrazumeva koriscenje Postgres baze (SQL skript nece moci da se izvrsi na MySQL bazi).

Klasa `PrimerTable` koristi `TABLE` tip generisanja vrednosti primarnog kljuca.
U ovom slucaju koristi se posebna tabela sa potencijalno vise brojaca iz koje se brojevi zahvataju uz pesimisticko zakljucavanje.
Ovaj tip generisanja primarnog kljuca je prenosiv izmedju razlicitih baza podataka, jer se ne oslanja na specificne funkcije pojedinacnih konkretnih baza.
Znacajno je sporija opcija od IDENTITY i SEQUENCE strategija.

Klasa `PrimerUUID` demonstrira korišćenje UUID (Universally unique identifier) kao primarnog ključa.

Klasa `PrimerHibernateUUID` demonistrira korišćenje Hibernate `uuid2` generatora za generisanje primarnog ključa.

Klase `PrimerCustomSequence` i `CustomSequenceIdGenerator` demonstiraju pravljenje generatora koji može da generiše ključeve po definisanom šablonu.