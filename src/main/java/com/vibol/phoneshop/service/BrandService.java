package com.vibol.phoneshop.service;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;

import com.vibol.phoneshop.entity.Brand;

public interface BrandService {
	
	// Save Brand to Database 	
	Brand create(Brand brand); 
	Brand getById(Integer id);	
	// Update 	
	Brand update(Integer id, Brand brandUpdate);
	
	// List Bran 
	List<Brand> getBrands(String name);
	//List<Brand> getBrands(Map<String, String> params);
	
	Page<Brand> getBrands(Map<String, String> params);
	
}
