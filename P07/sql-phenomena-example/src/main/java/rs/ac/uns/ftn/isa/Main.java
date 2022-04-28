package rs.ac.uns.ftn.isa;

public class Main {
  public static void main(String[] args) throws Exception {

	System.out.println("\nMySQL INNODB engine");
    System.out.println("\n### DIRTY READ ###");
    DirtyRead.run("schema.sql");

    System.out.println("\n### UNREPEATABLE READ ###");
    UnrepeatableRead.run("schema.sql");

    System.out.println("\n### PHANTOM READ ###");
    PhantomRead.run("schema.sql");
  }
}