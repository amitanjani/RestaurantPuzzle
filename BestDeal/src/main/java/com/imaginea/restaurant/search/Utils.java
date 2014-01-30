package com.imaginea.restaurant.search;


public class Utils {
	
	public static Double getMinimumVal(Object []array) {
		Double min =Double.parseDouble(array[0].toString());
		for (int i = 1; i < array.length; i++) {
			Double tmp = Double.parseDouble(array[i].toString());
			if(min > tmp){
				min = tmp;
			}
		}
		return min;
	}
}
