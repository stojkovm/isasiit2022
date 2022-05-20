package rs.ac.uns.ftn.isa.cache.service;

import java.util.List;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;

import rs.ac.uns.ftn.isa.cache.domain.Product;

public interface ProductService {
	
	List<Product> findAll();
	
	@CachePut(cacheNames = "product", key = "#product.id")
	Product saveProduct(Product product);
	
	/*
	 * Anotacijom @Cacheable i nazivom "product"
	 * naznaceno je da se objekti tipa Product koji se dobave
	 * metodom findOne smestaju u kes kolekciju "product"
	 * kao i u ehcache.xml konfiguraciji
	 */
	@Cacheable("product")
	Product findOne(long id);
	
	@CacheEvict(cacheNames = "product", key = "#id")
	void delete(long id);
	
	List<Product> findByName(String name);
	
	List<Product> findByPrice(long price);
	
	List<Product> findByPriceRange(long price1, long price2);
	
	List<Product> findByNameMatch(String name);
	
	List<Product> findByNamedParam(String name, String origin, long price);
	
	@CacheEvict(cacheNames = {"product"}, allEntries = true)
	void removeFromCache();
}
