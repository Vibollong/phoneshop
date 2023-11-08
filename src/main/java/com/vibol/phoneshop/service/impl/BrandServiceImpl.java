package com.vibol.phoneshop.service.impl;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import com.vibol.phoneshop.entity.Brand;
import com.vibol.phoneshop.exception.ApiException;
import com.vibol.phoneshop.exception.ResourceNotFoundException;
import com.vibol.phoneshop.repository.BrandRepository;
import com.vibol.phoneshop.service.BrandService;
import com.vibol.phoneshop.service.util.PageUtil;
import com.vibol.phoneshop.spec.BrandFilter;
import com.vibol.phoneshop.spec.BrandSpec;

@Service
// at Service in order to create Bean or we can put Component 
public class BrandServiceImpl implements BrandService {
	// អ្នកទទួលមុខងា save ចូលក្នុង Database is Repository

	@Autowired
	// អោយ Spring create object ory yerng
	private BrandRepository brandRepository;
	// it call dependency injection

	@Override
	public Brand create(Brand brand) {
		// Brand brand2 = brandRepository.save(brand);

		return brandRepository.save(brand);
	}

	@Override
	public Brand getById(Integer id) {
		/*
		 * Optional<Brand> brandOptional = brandRepository.findById(id);
		 * if(brandOptional.isPresent()) { return brandOptional.get(); } { //throw new
		 * HttpClientErrorException(HttpStatus.NOT_FOUND, "Brand with id = " + id +
		 * " Not Found "); // Java 8: throw new
		 * HttpClientErrorException(HttpStatus.NOT_FOUND,
		 * String.format("Brand with id = %d Not Found ",id)); throw new
		 * HttpClientErrorException(HttpStatus.NOT_FOUND,
		 * "Brand with id = %d Not Found ".formatted(id)); }
		 */

		return brandRepository.findById(id)
				// .orElseThrow(()-> new HttpClientErrorException(HttpStatus.NOT_FOUND, "Brand
				// with id = %d Not Found ".formatted(id)));
				.orElseThrow(() -> new ResourceNotFoundException("Brand", id));
	}

	// update
	@Override
	public Brand update(Integer id, Brand brandUpdate) {
		Brand brand = getById(id);
		brand.setName(brandUpdate.getName());
		return brandRepository.save(brand);
	}

	@Override
	public List<Brand> getBrands(String name) {
		// return brandRepository.findByNameLike("%"+name+"%");
		return brandRepository.findByNameContaining(name);
	}

	/*
	 * @Override public List<Brand> getBrands(Map<String, String> params) {
	 * BrandFilter brandFilter = new BrandFilter();
	 * 
	 * if (params.containsKey("name")) { String name = params.get("name");
	 * brandFilter.setName(name); }
	 * 
	 * if(params.containsKey("id")) { String id = params.get("id");
	 * brandFilter.setId(Integer.parseInt(id)); }
	 * 
	 * BrandSpec brandSpec = new BrandSpec(brandFilter);
	 * 
	 * //Pageable //Page<Brand> findAll = brandRepository.findAll(brandSpec,
	 * org.springframework.data.domain.Pageable.ofSize(10));
	 * 
	 * return brandRepository.findAll(brandSpec); }
	 * 
	 */

	@Override
	public Page<Brand> getBrands(Map<String, String> params) {
		BrandFilter brandFilter = new BrandFilter();

		if (params.containsKey("name")) {
			String name = params.get("name");
			brandFilter.setName(name);
		}

		if (params.containsKey("id")) {
			String id = params.get("id");
			brandFilter.setId(Integer.parseInt(id));
		}

		int pageLimit = PageUtil.DEFAULT_PAGE_LIMIT;
		if (params.containsKey(PageUtil.PAGE_LIMIT)) {
			pageLimit = Integer.parseInt(params.get(PageUtil.PAGE_LIMIT));
		}

		int pageNumber = PageUtil.DEFAULT_PAGE_NUMBER;
		if (params.containsKey(PageUtil.PAGE_NUMBER)) {
			pageNumber = Integer.parseInt(params.get(PageUtil.PAGE_NUMBER));
		}

		BrandSpec brandSpec = new BrandSpec(brandFilter);

//		Pageable pageable = PageUtil.getPageable(pageNumber, pageLimit);

		Pageable pageable = PageUtil.getPageable(pageNumber, pageLimit);

		// Pageable
		// Page<Brand> findAll = brandRepository.findAll(brandSpec,
		// org.springframework.data.domain.Pageable.ofSize(10));

		Page<Brand> page = brandRepository.findAll(brandSpec, pageable);

		return page;
	}

}
