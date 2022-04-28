# Primeri za klasične probleme u transakcionom radu

 * *lost update*: kada transakcioni režim zapravo i ne postoji, rollback
   jedne transakcije može da poništi i rezultate druge uspešne transakcije
 * *read uncommitted*: posledica čitanja podataka koji su parcijalni
   rezultat druge transakcije koja je u toku i nije još potvrđena
 * *unrepeatable read*: čitanje potvrđenih izmena, ali dva puta u toku iste
   transakcije može da vrati različite rezultate
 * *phantom read*: čitanje potvrđenih izmena, ali dva puta u toku iste
   transakcije može da vrati različiti broj redova u rezultatu

Primer preuzet sa [linka](https://github.com/mbranko/isa19/tree/master/08-tx/pr03)

## Korisne stvari

* [Eclipse](https://www.eclipse.org)
* [IntelliJ IDEA](https://www.jetbrains.com/idea/)
* [MySQL](https://mysql.com) ili [MariaDB](https://mariadb.org)

## Kreiranje baze podataka

Za pokretanje primera potrebna je MySQL ili MariaDB baza podataka sa
sledećom šemom i korisnikom:

```sql
CREATE DATABASE txtest CHARACTER SET utf8;
CREATE USER 'txtest'@'localhost' IDENTIFIED BY 'txtest';
GRANT ALL PRIVILEGES ON txtest.* to 'txtest'@'localhost';
FLUSH PRIVILEGES;
```

## Pokretanje primera

Iz primera pokrenuti klasu `rs.ac.uns.ftn.isa.Main` iz razvojnog okruženja.

## Sadržaj primera

Klasa `Main` sadrži `main` metodu. Pokreće četiri primera koji ilustruju različite
probleme u radu sa transakcijama.
