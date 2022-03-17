# Pristup relacionoj bazi putem JDBC API

Primer demonstrira korišćenje osnovnih elemenata JDBC API-ja za pristup
relacionim bazama podataka. U primeru se koristi H2 baza podataka, u 
in-memory konfiguraciji.

## Korisne stvari

* [Eclipse](https://www.eclipse.org)
* [IntelliJ IDEA](https://www.jetbrains.com/idea/)

## Pokretanje primera

Iz primera pokrenuti klasu `rs.ac.uns.ftn.isa.jdbc.DbDemo` iz razvojnog okruženja.

## Sadržaj primera

Klasa `DbDemo` je konzolna aplikacija iz koje se pristupa H2 bazi.

Metode `createSchema` i `initData` služe da inicijalizuju bazu sa nekim
sadržajem kako bi se naredni primeri lakše pratili. Skriptovi za kreiranje
baze i punjenje podataka su u fajlovima `schema.sql` i `data.sql`. 

Metoda `select` demonstrira slanje SELECT komande na server i čitanje
rezultata.

Metoda `preparedStatement` demonstrira slanje više uzastopnih INSERT
naredbi na server.

Metoda `callableStatement` prikazuje pozivanje uskladištene procedure
na serveru. Uskladištena procedura je definisana metodom `povezi` odnosno
skriptom `storedprocedure-h2.sql`. Pošto je H2 baza za koju se
uskladištene procedure pišu u Javi umesto u nekom od proceduralnih
dijalekata SQL-a, ovaj primer je atipičan. Primer ekvivalentne procedure
napisane za MySQL je u fajlu `storedprocedure-mysql.sql`.
