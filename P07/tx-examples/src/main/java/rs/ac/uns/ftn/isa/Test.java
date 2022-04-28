package rs.ac.uns.ftn.isa;

import rs.ac.uns.ftn.isa.optimistic.OptimisticTest;
import rs.ac.uns.ftn.isa.pessimistic.PessimisticTest;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Test {
  public static void main(String[] args) throws Exception {
    Logger.getLogger("").setLevel(Level.OFF);
    final EntityManagerFactory factory =
        Persistence.createEntityManagerFactory("Bank");

    System.out.println("\n\n===== OPTIMISTIC TEST =====");
    OptimisticTest.run(factory);

    System.out.println("\n\n===== PESSIMISTIC TEST =====");
    PessimisticTest.run(factory);

    System.exit(0);
  }
}
