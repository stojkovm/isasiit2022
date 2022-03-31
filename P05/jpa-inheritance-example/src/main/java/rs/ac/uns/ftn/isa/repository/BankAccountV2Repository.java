package rs.ac.uns.ftn.isa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import rs.ac.uns.ftn.isa.v2.BankAccount;

public interface BankAccountV2Repository extends JpaRepository<BankAccount, Integer> {

}
