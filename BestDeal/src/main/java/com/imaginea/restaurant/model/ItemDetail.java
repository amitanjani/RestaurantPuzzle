package com.imaginea.restaurant.model;

import java.util.List;
import java.util.Map;

public class ItemDetail {

	List<String> itemList;
	Map<String,Double> priceMap;
	
	public ItemDetail(){}
	
	public ItemDetail(List<String> itemList, Map<String,Double> priceMap){
		this.itemList = itemList;
		this.priceMap = priceMap;
	}
	
	public List<String> getItemList( ) {
		return itemList;
	}
	public void setItemList(List<String> itemList) {
		this.itemList = itemList;
	}
	public Map<String,Double> getPriceMap() {
		return priceMap;
	}
	public void setPriceMap(Map<String,Double> priceMap) {
		this.priceMap = priceMap;
	}
	
}
