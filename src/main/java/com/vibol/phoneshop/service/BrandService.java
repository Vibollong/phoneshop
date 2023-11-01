package com.vibol.phoneshop.service;

import com.vibol.phoneshop.entity.Brand;

public interface BrandService {

	
	// Save Brand to Database 
	
	Brand create(Brand brand); 
	Brand getById(Integer id);
	
	// Update 
	
	Brand update(Integer id, Brand brandUpdate);
	
}
