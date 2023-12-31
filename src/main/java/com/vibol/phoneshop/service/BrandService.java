package com.vibol.phoneshop.service;

import java.util.List;

import com.vibol.phoneshop.entity.Brand;

public interface BrandService {
	
	// Save Brand to Database 	
	Brand create(Brand brand); 
	Brand getById(Integer id);	
	// Update 	
	Brand update(Integer id, Brand brandUpdate);
	
	// List Bran 
	
	List<Brand> getBrands();
	List<Brand> getBrands(String name);
	
	
}
