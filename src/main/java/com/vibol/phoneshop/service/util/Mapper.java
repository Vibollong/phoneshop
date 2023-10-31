package com.vibol.phoneshop.service.util;

import com.vibol.phoneshop.dto.BrandDTO;
import com.vibol.phoneshop.entity.Brand;

public class Mapper {

	public static Brand toBrand(BrandDTO dto) {
		
		// convert from dto to entity 
		Brand brand = new Brand();
		
		//brand.setId(dto.getId());
		brand.setName(dto.getName());
		
		return brand;		
	}
	
	public static BrandDTO toBrandDTO(Brand brand) {
		BrandDTO brandDTO = new BrandDTO();
		brandDTO.setName(brand.getName());
		return brandDTO;
	}
}
