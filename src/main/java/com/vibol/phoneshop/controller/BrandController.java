package com.vibol.phoneshop.controller;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.vibol.phoneshop.dto.BrandDTO;
import com.vibol.phoneshop.dto.PageDTO;
import com.vibol.phoneshop.entity.Brand;
import com.vibol.phoneshop.service.BrandService;
import com.vibol.phoneshop.service.mapper.BrandMapper;
import com.vibol.phoneshop.service.util.Mapper;

import ch.qos.logback.core.model.processor.PhaseIndicator;

// we use concept spring MVC create API 

@RestController // come with respond body with RestController
@RequestMapping("brands")
//RequestMapping is map to brands entity 
//@ResponseBody វា return body Mok ving (it come with RestController) => we no need to put 

public class BrandController {
	// save server Bran
	@Autowired
	private BrandService brandService;

	// create handler method
	@RequestMapping(method = RequestMethod.POST)

	public ResponseEntity<?> create(@RequestBody BrandDTO brandDTO) {
		// RequestBody ជាអ្វីដែលយើង submit ពីរ FrontEnd មក
		// save to database
		// so we save Brand

		Brand brand = BrandMapper.INSTANCE.toBrand(brandDTO);
		brand = brandService.create(brand);
		return ResponseEntity.ok(BrandMapper.INSTANCE.toBrandDTO(brand));
		// create in database only name no need to put id

	}

	// get id
	@GetMapping("{id}")
	// Error : public ResponseEntity<?> getOneBrand(@PathVariable Integer brandId){
	public ResponseEntity<?> getOneBrand(@PathVariable("id") Integer brandId) {
		Brand brand = brandService.getById(brandId);
		return ResponseEntity.ok(BrandMapper.INSTANCE.toBrandDTO(brand));
	}

	// update
	@PutMapping("{id}")
	public ResponseEntity<?> update(@PathVariable("id") Integer brandId, @RequestBody BrandDTO brandDTO) {
		// Brand brand = Mapper.toBrand(brandDTO);

		Brand brand = BrandMapper.INSTANCE.toBrand(brandDTO);
		Brand updateBrand = brandService.update(brandId, brand);

		return ResponseEntity.ok(BrandMapper.INSTANCE.toBrandDTO(updateBrand));
	}


	@GetMapping
	public ResponseEntity<?> getBrands(@RequestParam Map<String, String> params) {
		
		Page<Brand> page = brandService.getBrands(params);
		PageDTO pageDTO = new PageDTO(page);
		
		
		/*
		List<BrandDTO> list = brandService.getBrands(params)
				.stream().map(brand -> BrandMapper.INSTANCE.toBrandDTO(brand))
				.collect(Collectors.toList());		
		return ResponseEntity.ok(list);
		
		*/
		
		return ResponseEntity.ok(pageDTO);
		
	}
	

}
