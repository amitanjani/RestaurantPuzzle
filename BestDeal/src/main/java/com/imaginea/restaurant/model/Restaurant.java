package com.imaginea.restaurant.model;

import java.util.List;
import java.util.Map;

public class Restaurant {
	private int restaurantId;
	private List<String> itemList;
	private Map<String, Double> priceMap;
	
	public Restaurant() {}
	
	public Restaurant(int restaurantId, List<String> itemList, Map<String, Double> priceMap) {
		this.restaurantId = restaurantId;
		this.itemList = itemList;
		this.priceMap = priceMap;
	}
	
	public int getRestaurantId() {
		return restaurantId;
	}
	
	public List<String> getItemList() {
		return itemList;
	}

	public void setItemList(List<String> itemList) {
		this.itemList = itemList;
	}

	public Map<String, Double> getPriceMap() {
		return priceMap;
	}

	public void setPriceMap(Map<String, Double> priceMap) {
		this.priceMap = priceMap;
	}

	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}
	
	
	@Override
	public String toString() {
		return "[RestaurantId="+restaurantId+" Item List="+itemList+" PriceMap="+priceMap+"]";
	}
}
