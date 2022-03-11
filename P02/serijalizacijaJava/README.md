# Predavanja 2 - primeri serijalizacije

## Korisne stvari

* [Eclipse](https://www.eclipse.org)
* [IntelliJ IDEA](https://www.jetbrains.com/idea/)
* [Postman](https://www.getpostman.com)

## instaliranje dependency-ja iz pom.xml

Kada učitamo Maven projekat u workspace, sve biblioteke od kojih naš prjekat zavisi i koje su navedene u pom.xml fajlu se prvo traže u lokalnom Maven repozitorijumu (folder čiji je naziv _.m2_). Tek ukoliko se ne pronađu tu, biblioteke će se potražiti na remote Maven repozitorujumu i ubaciti u lokalni repozitorijum. Maven kada pronađe sve zavisnosti, uvezaće ih sa projektom. Nakon import-a projekta u workspace, u donjem desnom uglu status bara se nalazi progress učitavanja i build-ovanja Maven projekta. Ukoliko nakon build-a projekat i dalje ima greške, potrebno je ručno uvezati sve zavisnosti iz pom.xml sa projektom. Ovo može da se uradi na sledeći način:

* desni klik na projekat -> Run as -> Maven build... -> u polje _goals_ uneti _clean compile install_ -> Apply -> Run. Da bi ovo radilo, voditi računa da je za pokretanje Maven ciljeva postavljen JDK, a ne JRE. Ovo možete podesiti u tabu _JRE_ kada otvorite _Maven build..._ dijalog.
* desni klik na projekat -> Maven -> Update Project

Kada dodate novu zavisnost u pom.xml, na snimanje izmena će se automatski pokrenuti uvezivanje zavisnosti sa projektom. Ukoliko se to ne desi, pokrenuti ručno uvezivanje zavisnosti sa projektom.


## primer serijalizacijaJSON

Klijent je [Postman](https://www.getpostman.com).
Iz Postmana poslati sledeće GET zahteve:

 * JSON Serijalizacija sa ugnježdavanjem
   * Podaci o jednom studentu, sa ugnježdenim ocenama i predmetima: 
     http://localhost:4567/api/studenti/E1234?format=json1
   * Podaci o svim studentima, sa ugnježdenim ocenama i predmetima: 
     http://localhost:4567/api/studenti?format=json1
   * Podaci o jednoj oceni, sa ugnježdenim predmetom i studentom
     http://localhost:4567/api/ocene/1?format=json1

  * JSON Serijalizacija sa referenciranjem
    * Podaci o oceni, sa referencama na predmet i studenta
      http://localhost:4567/api/ocene/1?format=json2
    * Podaci o svim ocenama, sa referencama na predmet i studenta
      http://localhost:4567/api/ocene?format=json2

## primeri serijalizacijaProto (server), serijalizacijaJavaProto (klijent) i serijalizacijaPythonProto (klijent)

Klasa modela izgenerisana je pomoću [uputstva](https://developers.google.com/protocol-buffers/docs/javatutorial) i [uputstva](https://developers.google.com/protocol-buffers/docs/pythontutorial).
Potrebno je prvo pokrenuti serversku aplikaciju, a zatim klijentske.

Za **serijalizacijaPythonProto** pre pokretanja instalirati [requests](https://requests.readthedocs.io/en/latest/user/quickstart/).