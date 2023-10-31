package com.vibol.phoneshop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vibol.phoneshop.entity.Brand;
import com.vibol.phoneshop.repository.BrandRepository;
import com.vibol.phoneshop.service.BrandService;

@Service
// at Service in order to create Bean or we can put Component 
public class BrandServiceImpl implements BrandService{
	//អ្នកទទួលមុខងា save ចូលក្នុង Database is Repository 
	
	@Autowired
	//អោយ Spring create object ory yerng 
	private BrandRepository brandRepository;
	//it call dependency injection 
	
	@Override
	public Brand create(Brand brand) {
		//Brand brand2 = brandRepository.save(brand);	
		
		return brandRepository.save(brand);
	}

}
