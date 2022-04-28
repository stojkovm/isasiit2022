package rs.ac.uns.ftn.isa.pessimistic;

import java.math.BigDecimal;
import java.util.concurrent.CountDownLatch;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class PessimisticTest {
  
  public static void run(EntityManagerFactory factory) throws Exception {
    final CountDownLatch latch = new CountDownLatch(2);
    Runnable r1 = () -> {
    	
      try {
    	 EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        // ucitaj objekat
        System.out.println("[Thread 1] Ucitavam i zakljucavam objekat...");
        BankAccountPes account = (BankAccountPes) em.createNativeQuery("SELECT * FROM bank_account_pes WHERE acct_id=? FOR UPDATE", BankAccountPes.class).setParameter(1, 1L).getSingleResult();
        System.out.println("[Thread 1] acc: " + account);
        // cekaj 3 sekunde
        System.out.println("[Thread 1] Cekam 3 sekunde...");
        try { Thread.sleep(3000); } catch (InterruptedException e) { }
        // dodaj 10000 na racun
        System.out.println("[Thread 1] Dodajem 10000 na racun...");
        account.deposit(new BigDecimal(10000));

        System.out.println("[Thread 1] Zavrsavam transakciju...");
        em.getTransaction().commit();
        em.close();
      } catch (Exception e) {
    	  System.out.println("GRESKA!!! [Thread 1] " + e.getClass().getName() + ": " + e.getMessage());
      }
      latch.countDown();
    };
    
    Runnable r2 = () -> {
      try {
        // cekaj 2 sekunde
        System.out.println("[Thread 2] Cekam 2 sekunde...");
        try { Thread.sleep(2000); } catch (InterruptedException e) { }

        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        // ucitaj objekat
        System.out.println("[Thread 2] Ucitavam i zakljucavam objekat...");
        BankAccountPes account = (BankAccountPes) em.createNativeQuery("SELECT * FROM bank_account_pes WHERE acct_id=? FOR UPDATE NOWAIT", BankAccountPes.class).setParameter(1, 1L).getSingleResult();
        System.out.println("[Thread 2] acc: " + account);
        // skini 500 sa racuna
        System.out.println("[Thread 2] Skidam 500 sa racuna...");
        account.withdraw(new BigDecimal(500));
        System.out.println("[Thread 2] Zavrsavam transakciju...");
        em.getTransaction().commit();
        em.close();
      } catch (Exception e) {
        System.out.println("GRESKA!!! [Thread 2] " + e.getClass().getName() + ": " + e.getMessage());
      }
      latch.countDown();
    };

    new Thread(r1).start();
    new Thread(r2).start();
    latch.await();
  }
}
