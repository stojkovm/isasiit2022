package rs.ac.uns.ftn.isa;

import java.math.BigDecimal;
import java.sql.Connection;
import java.util.concurrent.CountDownLatch;

public class PhantomRead extends Demo {

  public static void run(String script) throws Exception {
    setup(script, Connection.TRANSACTION_REPEATABLE_READ);
    final CountDownLatch latch = new CountDownLatch(2);

    BigDecimal original = new BigDecimal(1000);
    System.out.println("Original value: " + original);

    Runnable r1 = () -> {
      try {
        System.out.println("Thread 1: SELECT --> " + getBalance(conn1));
        Thread.sleep(2000);
        System.out.println("Thread 1: SELECT --> " + getBalances(conn1));
        System.out.println("Thread 1: COMMIT");
        conn1.commit();
        latch.countDown();
      } catch (Exception ex) {
        ex.printStackTrace();
      }
    };

    Runnable r2 = () -> {
      try {
        Thread.sleep(500);
        System.out.println("\t\t\t\tThread 2: INSERT --> " + insertAccount(conn2));
        System.out.println("\t\t\t\tThread 2: COMMIT");
        conn2.commit();
        latch.countDown();
      } catch (Exception ex) {
        ex.printStackTrace();
      }
    };

    new Thread(r1).start();
    new Thread(r2).start();
    latch.await();
    String balance1 = getBalances(conn1);
    String balance2 = getBalances(conn2);
    System.out.print("\nFinally in DB [conn1]: " + balance1);
    System.out.println("\tFinally in DB [conn2]: " + balance2);
    teardown();
  }

}