# Pesimističko i optimističko zaključavanje

Ilustracija pesimističkog i optimističkog zaključavanja prilikom
pristupa jednoj tabeli.

Primer preuzet sa [linka](https://github.com/mbranko/isa19/tree/master/08-tx/pr02)

## Korisne stvari

* [Eclipse](https://www.eclipse.org)
* [IntelliJ IDEA](https://www.jetbrains.com/idea/)

## Kreiranje baze podataka

Za pokretanje primera potrebna je MySQL ili MariaDB baza podataka sa
sledećom šemom i korisnikom:

```sql
CREATE DATABASE txtest CHARACTER SET utf8;
CREATE USER 'txtest'@'localhost' IDENTIFIED BY 'txtest';
GRANT ALL PRIVILEGES ON txtest.* to 'txtest'@'localhost';
FLUSH PRIVILEGES;
```

ili promeniti parametre u `persistence.xml` iz `src/main/resources/META-INF` foldera.

## Pokretanje primera

Iz primera pokrenuti klasu `rs.ac.uns.ftn.isa.Test` iz razvojnog okruženja.

## Sadržaj primera

Klase `BankAccountPes` i `BankAccountOpt` u oba primera je predstavlja entity oko koga se vrši 
zaključavanje pristupa. U oba primera kreiraju se dva threada koji rade
sledeće:
 * **prvi thread** učitava objekat, čeka tri sekunde (da bi drugi thread 
   dobio priliku da radi), dodaje 10000 na račun i završava transakciju.
 * **drugi thread** čeka 2 sekunde, učitava objekat, skida 500 sa računa
   i završava transakciju.
   
U slučaju optimističkog zaključavanja prvi thread će dobiti 
`OptimisticLockException` kao signal da je druga transakcija u međuvremenu
promenila objekat.

U slučaju pesimističkog zaključavanja obe transakcije će se uspešno
završiti uz odgovarajuće čekanje izazvano zaključavanjem i operacije
čitanja za dati objekat odnosno red u bazi. Ovakav način zaključavanja
zove se *exclusive lock*, za razliku od *shared lock* gde je se dopušta
da više paralelnih transakcija čita isti objekat.
