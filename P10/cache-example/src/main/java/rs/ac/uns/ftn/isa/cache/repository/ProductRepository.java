package rs.ac.uns.ftn.isa.cache.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import rs.ac.uns.ftn.isa.cache.domain.Product;

public interface ProductRepository extends JpaRepository<Product,Long> {

}
