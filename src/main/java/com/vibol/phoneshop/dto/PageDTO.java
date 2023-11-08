package com.vibol.phoneshop.dto;

import java.util.List;

import org.springframework.data.domain.Page;

import lombok.Data;

@Data
public class PageDTO {

	private List<?> list;
	private PaginationDTO pagination;
	
	// contractor 
	
	public PageDTO(Page<?> page) {
		this.list = page.getContent();
		this.pagination = PaginationDTO.builder()
				.empty(page.isEmpty())
				.first(page.isFirst())
				.last(page.isLast())
				//.pageSize(page.getPageable().getPageSize())
				.pageSize(page.getSize())
				//.pageNumber(page.getPageable().getPageNumber()+1)
				.pageNumber(page.getNumber()+1)
				.totalPages(page.getTotalPages())
				.totalElements(page.getTotalElements())
				.numberOfElements(page.getNumberOfElements())				
				.build();
	}
	
	// Builder pater = យើងចង់កំណត់ property ប៉ន្មានក៏បានដែល វា return object នឹងទៅវិញ
	
	
}
