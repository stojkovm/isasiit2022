# Primer mapiranja nasleđivanja pomoću Hibernate ORM

Primer demonstrira mapiranje nasleđivanja pomoću Hibernate ORM.
U primeru se koristi H2 baza podataka.

## Korisne stvari

* [Eclipse](https://www.eclipse.org)
* [IntelliJ IDEA](https://www.jetbrains.com/idea/)

## Pokretanje primera

Iz primera pokrenuti klasu `rs.ac.uns.ftn.isa.InheritanceExampleApplication` iz razvojnog okruženja.

## Sadržaj primera

Primeri tri varijante za mapiranje nasleđivanja. U svim varijantama koriste se sledeće klase:
`BillingDetails` - apstraktna klasa sa jednim atributom
`CreditCard`     - konkretna klasa sa podacima o kreditnoj kartici
`BankAccount`    - konkretna klasa sa podacima o bankovnom racunu

Paket `rs.ac.uns.ftn.isa.v1` sadrži klase `BillingDetails`, `BankAccount` i `CreditCard` koje predstavljaju hijerarhiju.
Primer demonstrira strategiju kreiranja po jedne tabele po konkretnoj klasi.
Ovde se i apstraktna klasa proglasava za entity (iako nece biti mapirana na tabelu, naznacava se nacin mapiranja nasledjivanja posebnom `@Inheritance` anotacijom).
Na taj nacin se moze koristiti u JPAQL upitima.

Paket `rs.ac.uns.ftn.isa.v2` sadrži klase `BillingDetails`, `BankAccount` i `CreditCard` koje predstavljaju hijerarhiju.
Primer demonstrira strategiju kreiranja jedne tabele za celu hijerarhiju nasleđivanja.
Za svaku (celu) hijerarhiju nasledjivanja formira se jedna tabela, sa unijom svih kolona koje su potrebne za sve klase naslednice.
Tip svakog objekta predstavljenim jednim redom u bazi odredjuje se pomocu vrednosti posebne kolone ("discriminator column").
U roditeljskoj klasi mora se navesti koja je to kolona.

Paket `rs.ac.uns.ftn.isa.v3` sadrži klase `BillingDetails`, `BankAccount` i `CreditCard` koje predstavljaju hijerarhiju.
Primer demonstrira strategiju kreiranja po jedne tabele za svaku klasu.
Veze nasledjivanja se ovde prikazuju pomocu spoljnih kljuceva. Cak i apstraktne klase se mapiraju na tabele u bazi.
U tabelama koje odgovaraju klasama naslednicama ne ponavljaju se nasledjeni propertiji.
