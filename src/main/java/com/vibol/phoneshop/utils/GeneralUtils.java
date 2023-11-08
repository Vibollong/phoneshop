package com.vibol.phoneshop.utils;

import java.util.List;

public class GeneralUtils {
//Convert from list to string to list of integer
	// ["Dara","Thida","Seyha"]
	// == [4,5,5]
	
	public static List<Integer> toIntergerList(List<String>list){
		return list.stream().map(s -> s.length())
		.toList();
		
	}
	
	public static List<Integer> getEventNumber (List<Integer> list){
		return list.stream()
			.filter(x ->x%2 == 0)
			.toList();
	}

}
