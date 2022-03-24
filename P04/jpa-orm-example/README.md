# Primer korišćenja Hibernate ORM

Primer demonstrira korišćenje Hibernate ORM pomoću EntityManager objekta.
U primeru se koristi H2 baza podataka.

## Korisne stvari

* [Eclipse](https://www.eclipse.org)
* [IntelliJ IDEA](https://www.jetbrains.com/idea/)

## Pokretanje primera

Iz primera pokrenuti klasu `rs.ac.uns.ftn.isa.JpaOrmExampleApplication` iz razvojnog okruženja.

## Sadržaj primera

Klasa `Admin` predstavlja domen model klasu koja se mapira na tabelu u bazi na osnovu anotacija.
Klasa `JpaOrmExampleApplication` u `main` metodi pomoću `EntityManagerFactory` objekta učitava Persistence Unit definisan kroz XML `persistence.xml` u `src/main/resources/META/INF` folderu.
Persistence Unit sadrži podatke o konekciji na bazu i načinu na koji ORM kreira šemu baze i tabele.
`EntityManager` kreira transakciju, obavlja operacije nad bazom i komituje transakciju.
