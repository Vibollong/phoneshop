package com.vibol.phoneshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.vibol.phoneshop.dto.BrandDTO;
import com.vibol.phoneshop.entity.Brand;
import com.vibol.phoneshop.service.BrandService;
import com.vibol.phoneshop.service.util.Mapper;

// we use concept spring MVC create API 


@RestController // come with respond body with RestController 
@RequestMapping("brands")

//RequestMapping is map to brands entity 
//@ResponseBody វា return body Mok ving (it come with RestController) => we no need to put 

public class BrandController {
	// save server Bran 
	@Autowired
	private BrandService brandService;	
	
//create handler method 
	@RequestMapping(method= RequestMethod.POST)
	
	public ResponseEntity<?> create(@RequestBody BrandDTO brandDTO) {
	// RequestBody ជាអ្វីដែលយើង submit ពីរ FrontEnd មក
		// save to database 
		// so we save Brand 
		
		Brand brand = Mapper.toBrand(brandDTO);
		brand = brandService.create(brand);			
		return ResponseEntity.ok(Mapper.toBrandDTO(brand));		
	}
	
	public  ResponseEntity<?> getOneBrand(){
		return null;
	}
	
	
	
}
