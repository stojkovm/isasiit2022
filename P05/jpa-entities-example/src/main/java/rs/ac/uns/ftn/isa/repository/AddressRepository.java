package rs.ac.uns.ftn.isa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import rs.ac.uns.ftn.isa.model.Address;

public interface AddressRepository extends JpaRepository<Address, Integer> {

}
