# Ilustracija pristupa bazi iz servleta

Ovaj primer predstavlja naivni pokušaj pristupa relacionoj bazi iz
servleta. Servlet će otvoriti konekciju prema bazi u svojoj `init` metodi
a zatvoriće je u svojoj `destroy` metodi. Na ovaj način, sve niti u kojima
se obrađuju zahtevi pomoću ovog servleta koriste istu konekciju prema
bazi podataka što nije ispravno. Jedna konekcija prema bazi podataka može
se koristiti iz samo jedne niti.


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
predstavlja primer *neispravnog* korišćenja konekcija za pristup bazi iz
servleta jer će na ovaj način ista konekcija biti korišćena iz više
različitih niti.