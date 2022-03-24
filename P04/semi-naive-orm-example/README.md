# Kreiranje ORM mapera pomoću Spring RowMapper API

Primer demonstrira korišćenje Spring RowMapper interfejsa za konverziju ResultSet objekata u Java POJO objekte i predstavlja primer kreiranja polu-naivnog ORM.
U primeru se koristi Postgres baza podataka.

## Korisne stvari

* [Eclipse](https://www.eclipse.org)
* [IntelliJ IDEA](https://www.jetbrains.com/idea/)

## Pokretanje primera

Potrebno je kroz PgAdmin kreirati šemu pod nazivom `rowmapper` i u `application.properties` fajlu navesti odgovarajuće kredencijale.
Iz primera pokrenuti test klasu `src/test/java/rs.ac.uns.ftn.isa.jdbc.JdbcExampleApplicationTests` iz razvojnog okruženja.

## Sadržaj primera

Klasa `User` predstavlja domen model klasu koja se mapira na tabelu u bazi.
Skripta `schema-postgres.sql` sadrži naredbu za kreiranje tabele u bazi koja odgovara klasi `User`.
Klasa `UserRowMapper` implementira interfejs `RowMapper` koji zahteva da se odradi redefinisanje metode `mapRow` gde se objekat tipa `ResultSet` konvertuje u objekat tipa `User`.
Klasa `UserRepository` koristi Spring `JdbcTemplate` objekat za komunikaciju sa bazom.