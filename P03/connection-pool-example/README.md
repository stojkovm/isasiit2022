# Ilustracija pristupa bazi iz servleta

Prethodni primer je prerađen tako da se za svaku nit za obradu zahteva na serveru
koristi posebna konekcija, a konekcije se pri tome recikliraju u okviru
connection pool strukture.

## Korisne stvari

* [Eclipse](https://www.eclipse.org)
* [IntelliJ IDEA](https://www.jetbrains.com/idea/)

## Pokretanje primera

Iz osnovnog foldera pokrenuti

`mvn tomcat7:run`

pa zatim otvoriti browser na adresi (GET zahtev): http://localhost:8080/list

ili

iz razvojnog okruženja preko `pom.xml` kroz Maven build dijalog u Goals kucati `tomcat7:run`

## Sadržaj primera

Web aplikacija ima dva servleta. `InitDbServlet` ima zadatak samo da kreira
šemu baze podataka i napuni je početnim podacima. `ListTeachersServlet`
sada uzima konekcije iz *resource pool*-a na takav način da svaka nit koristi
posebnu konekciju prema bazi. Nakon upotrebe konekcija se ne zatvara već se
vraća u pool za kasnije korišćenje.

Prilikom uzimanja svake konekcije iz poola na konzoli servera se ispisuje
podatak o tome koja konekcija iz poola je u pitanju.