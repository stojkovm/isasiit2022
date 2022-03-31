package rs.ac.uns.ftn.isa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import rs.ac.uns.ftn.isa.v1.BankAccount;

public interface BankAccountV1Repository extends JpaRepository<BankAccount, Integer> {

}
