package com.vibol.phoneshop.phoneshop.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Configuration;

import com.vibol.phoneshop.entity.Brand;
import com.vibol.phoneshop.repository.BrandRepository;

@DataJpaTest
//វាបង្កើត Autowired in h2
public class BrandRepositoryTest {
	
	@Autowired
	// want to test RandRepository
	private BrandRepository brandRepository;

	@Test
	public void TestFindByNameLike() {
		// given
	
		Brand brand = new Brand();
		brand.setName("Apple");
		
		Brand brand2 = new Brand();
		brand2.setName("SAmsung");

		brandRepository.save(brand);
		brandRepository.save(brand2);

		// when

		List<Brand> brands = brandRepository.findByNameLike("%A%");

		// then

		assertEquals(2, brands.size());
		assertEquals("Apple", brands.get(0).getName());
		assertEquals(1, brands.get(0).getId());

	}
	
	
	/*
	@Test
	public void TestFindByNameContaining() {
		// given
	
		Brand brand = new Brand();
		brand.setName("Apple");

		brandRepository.save(brand);
		brandRepository.save(brand2);

		// when

		List<Brand> brands = brandRepository.TestFindByNameContaining("%A%");

		// then

		assertEquals(2, brands.size());
		assertEquals("Apple", brands.get(0).getName());
		assertEquals(1, brands.get(0).getId());

	}
	*/

}
