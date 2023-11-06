package com.vibol.phoneshop.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.vibol.phoneshop.dto.BrandDTO;
import com.vibol.phoneshop.entity.Brand;

@Mapper
public interface BrandMapper {
// where we want to mapper 
// DTO to Entity

	BrandMapper INSTANCE = Mappers.getMapper(BrandMapper.class);

	//BrandDTO convert to Brand 
	// ពីក្រៅមកក្នុង
	Brand toBrand(BrandDTO dto);
	
	// Brand (entity=table) convert to DTO ving 
	// ពីក្នុងទៅក្រៅវិញ
	BrandDTO toBrandDTO(Brand entity);
	
	
}
