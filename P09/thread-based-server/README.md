# Primer osnovnog HTTP servera

Ovaj primer predstavlja implementaciju elementarnog HTTP servera u Javi.
Primer je preuzet sa [linka](https://github.com/mbranko/isa19/tree/master/01-threads).

## Potrebne stvari

* [Eclipse](https://www.eclipse.org)
* [Postman](https://www.getpostman.com)

## Pokretanje primera

Pokrenuti klasu `rs.ac.uns.ftn.isa.Server` iz razvojnog okruženja.

Potom u browseru ili Postmanu poslati GET zahtev na adresu `http://localhost:8080`. Nakon toga isprobati i slanje POST
zahteva na isti URL.

## Sadržaj primera

Klasa `rs.ac.uns.ftn.isa.Server` je ulazna tačka programa gde se zauzima port 8080 i u beskonačnoj petlji čeka na otvaranje TCP
konekcije. Za svaku otvorenu konekciju pokreće se posebna nit za obradu zahteva.

Klasa `RequestThread` predstavlja nit za obradu zahteva. Analizira se samo prvi red HTTP zahteva, odnosno samo
HTTP metoda u okviru prvog reda. Ako je u pitanju `GET` metoda, vraća se odgovor sa statusom `200` i pozdravnom HTML
stranicom a u suprotnom šalje se odgovor sa statusom `405` (*Method not allowed*).

## HTTP statusi

Pregledna i čitka lista HTTP status kodova nalazi se na https://httpstatuses.com

