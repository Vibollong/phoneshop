package com.vibol.phoneshop.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import com.vibol.phoneshop.entity.Brand;
import com.vibol.phoneshop.exception.ApiException;
import com.vibol.phoneshop.exception.ResourceNotFoundException;
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

	@Override
	public Brand getById(Integer id) {
		/*
		Optional<Brand> brandOptional = brandRepository.findById(id);
		if(brandOptional.isPresent()) {
			return brandOptional.get();
		}
		{
			//throw new HttpClientErrorException(HttpStatus.NOT_FOUND, "Brand with id = " + id + " Not Found ");
			// Java 8: throw new HttpClientErrorException(HttpStatus.NOT_FOUND, String.format("Brand with id = %d Not Found ",id));
			throw new HttpClientErrorException(HttpStatus.NOT_FOUND, "Brand with id = %d Not Found ".formatted(id));
		}
		*/
		
		return brandRepository.findById(id)
				//.orElseThrow(()-> new HttpClientErrorException(HttpStatus.NOT_FOUND, "Brand with id = %d Not Found ".formatted(id)));
				.orElseThrow(()-> new ResourceNotFoundException("Brand", id));
	}

	// update
	@Override
	public Brand update(Integer id, Brand brandUpdate) {
		Brand brand = getById(id);
		brand.setName(brandUpdate.getName());
		return brandRepository.save(brand);
	}

}
