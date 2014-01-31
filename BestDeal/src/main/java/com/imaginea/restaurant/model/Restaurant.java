package com.imaginea.restaurant.model;

import java.util.Map;

public class Restaurant {
	private int restaurantId;
	private Map<String, Double> item_PriceMap;
	
	public Restaurant() {}
	
	public Restaurant(int restaurantId, Map<String, Double> item_PriceMap) {
		this.restaurantId = restaurantId;
		this.item_PriceMap = item_PriceMap;
	}
	
	public Map<String, Double> getItem_PriceMap() {
		return item_PriceMap;
	}

	public void setItem_PriceMap(Map<String, Double> item_PriceMap) {
		this.item_PriceMap = item_PriceMap;
	}

	public int getRestaurantId() {
		return restaurantId;
	}
	
	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}
	
	
	@Override
	public String toString() {
		return "[RestaurantId="+restaurantId+" PriceItemMap="+item_PriceMap+"]";
	}
}
