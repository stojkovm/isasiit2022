# Primer korišćenja ORMLite ORM

Primer demonstrira korišćenje [ORMLite](https://ormlite.com/) ORM.
U primeru se koristi H2 baza podataka.

## Korisne stvari

* [Eclipse](https://www.eclipse.org)
* [IntelliJ IDEA](https://www.jetbrains.com/idea/)
* [Postman](https://www.getpostman.com)

## Pokretanje primera

Iz primera pokrenuti klasu `rs.ac.uns.ftn.isa.OrmliteExampleApplication` iz razvojnog okruženja.
Endpointi kontrolera se mogu pogoditi pomoću Postman REST klijenta.
Podaci u bazi se mogu videti na [http://localhost:8080/h2-console](http://localhost:8080/h2-console)
Parametri za konekciju na H2 nalaze se u klasi `OrmliteExampleApplication` u metodi `getDataSource()`.

## Sadržaj primera

Klasa `Greeting` predstavlja domen model klasu koja se mapira na tabelu u bazi na osnovu anotacija.
Klasa `OrmliteExampleApplication` u `initDB` metodi pomoću kreira tabelu na osnovu anotacija u modelu.
Klasa `GreetingDAOImpl` predstavlja implementaciju DAO šabolona gde se koriste metode za ugrađene CRUD operacije nad entitetom tipa `Greeting`.