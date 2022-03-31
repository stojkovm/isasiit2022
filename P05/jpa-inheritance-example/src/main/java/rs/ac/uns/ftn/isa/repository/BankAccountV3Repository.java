package rs.ac.uns.ftn.isa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import rs.ac.uns.ftn.isa.v3.BankAccount;

public interface BankAccountV3Repository extends JpaRepository<BankAccount, Integer> {

}
