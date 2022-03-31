# Primer definisanja veza pomoću Hibernate ORM

Primer demonstrira korišćenje Hibernate ORM za mapiranje veza između objekata na relacionu bazu.
U primeru se koristi H2 baza podataka.

## Korisne stvari

* [Eclipse](https://www.eclipse.org)
* [IntelliJ IDEA](https://www.jetbrains.com/idea/)

## Pokretanje primera

Iz primera pokrenuti klasu `rs.ac.uns.ftn.isa.JPAExampleEApplication` iz razvojnog okruženja.

## Sadržaj primera

Klase `Student` i `Address` predstavljaju domen model klase koje su povezane 1:1 vezom. Demonistrirano je korišćenje `@MapsId` anotacije kojom entiteti tipa `Address` preuzimaju ključ entiteta `Student`.
Klase `Student`, `TeacherSet` i `TeacherList` sadrže pomoćne metode `add*()` i `remove*()` koje služe za držanje veze povezanih entiteta sinhronizovanima.
Klase `Student` i `Project` predstavljaju domen model klase koje su povezane 1:n vezom. Demonstrirano je korišćenje `cascade` i `fetch` atributa pri mapiranju,
kao i pisanje specijalnih upita korišćenjem `FETCH JOIN` u `StudentRepository` i `ProjectRepository` interfejsima kako bi se pravilno dohvatili povezani entiteti za koje je `fetch` postavljen na `LAZY` kako bi se izbegao `LazyInitializationException` izuzetak.
Klase `TeacherSet`, `TeacherList`, `CourseSet` i `CourseList` predstavljaju domen model klase koje su povezane n:n vezom. Demonstrirana je prednost korišćenja `Set`-a umesto `List`-e pri definisanju tipa kolekcije.

## Efikasnost asocijacija:

__One-To-One__:
* Unidirekcione/bidirekcione `@OneToOne` veze sa `@MapsId` su efikasne
* Bidirekcione @OneToOne bez `@MapsId` su manje efikasne


__One-To-Many__:
* Bidirekcione `@OneToMany` i unidirekcione `@ManyToOne` su efikasne
* Unidirekcione `@OneToMany` sa `Set` kolekcijom su manje efikasne
* Unidirekcione `@OneToMany` sa `List` kolekcijom su prilično neefikasne


__Many-To-Many__:
* Unidirekcione/bidirekcione `@ManyToMany` sa `Set` kolekcijom su efikasne
* Unidirekcione/bidirekcione `@ManyToMany` sa `List` kolekcijom su prilično neefikasne
