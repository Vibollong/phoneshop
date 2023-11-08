package com.vibol.phoneshop.phoneshop.util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.couchbase.CouchbaseProperties.Env;

import com.vibol.phoneshop.utils.GeneralUtils;

import jakarta.persistence.criteria.CriteriaBuilder.In;

public class GeneralUtilsTest {
	@Test
	public void testToIntegerList() {
		//Given
		List<String> names = List.of("Dara","Thida","Seyha");
		
		//When = call our function
		List<Integer> list = GeneralUtils.toIntergerList(names);
		
		//Then
		assertEquals(3, list.size());
		assertEquals(4, list.get(0));
		assertEquals(5, list.get(1));
		assertEquals(5, list.get(2));		
	}
	@Test
	public void testGetEvenNumber() {
		// given
		
		List<Integer> list = List.of(4,5,3,20,6,8);
		
		// when
		
		List<Integer> evenNumber = GeneralUtils.getEventNumber(list);
		
		//then
		
		assertEquals(4, evenNumber.size());
		assertEquals(4, evenNumber.get(0));
		//assertEquals(5, evenNumber.equals(null));
		
	}
	
}
