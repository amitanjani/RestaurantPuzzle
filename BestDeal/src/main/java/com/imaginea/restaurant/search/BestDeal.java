package com.imaginea.restaurant.search;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.imaginea.restaurant.model.Restaurant;

public class BestDeal {
	private String[] itemLabels;
	private Map<Integer, Restaurant> restaurantsMenuCard;
	
	public BestDeal(String csvFile) {
		CSVParser parser = new CSVParser();
		restaurantsMenuCard = parser.readCSVFile(csvFile);
	}

	public void pickBestDeal(String inputItem){
		if(inputItem== null || inputItem.isEmpty()){
			System.out.println("Item is empty.");
			return;
		}
		// inputItem.replaceAll("( )+", " ") to replace one or more space in string
		itemLabels = inputItem.replaceAll("( )+", " ").trim().split(" ");
		getRestaurantBasedOnItem(itemLabels);
		if (restaurantsMenuCard.isEmpty()) {
			System.out.println("No Restaurant found for given items.");
		} else {
			printBestDeal();
		}
	}

	private void printBestDeal(){
		Map<Double, Integer> resultMap = new HashMap<Double, Integer>();
		List<Double> priceTotal = new ArrayList<Double>();
		Set<Integer> restIds = restaurantsMenuCard.keySet();
		for (Integer restId : restIds) {
			Double total = 0.0;
			for (String item : itemLabels) {
				Map<String, Double> priceMap =((Restaurant) restaurantsMenuCard.get(restId)).getPriceMap();
				Double itemPrice = priceMap.get(item);
				// check item in value meal
				if(itemPrice == null){
					item = getItemKey(item, priceMap);
					itemPrice = priceMap.get(item);
				}
				total += itemPrice;
			}
			priceTotal.add(total);
			resultMap.put(total, restId);
		}
		Double minimumPrice = Utils.getMinimumVal(priceTotal.toArray());
		System.out.println("Selected Restaurant::"+ resultMap.get(minimumPrice )+"\nMinimum Price::"+minimumPrice);

	}

	// prepare ItemKey of Value meal
	private String getItemKey(String item, Map<String, Double> priceMap){
		Iterator<String> keySetItr = priceMap.keySet().iterator();
		while(keySetItr.hasNext()){
			String itemKey = keySetItr.next().toString();
			if(itemKey.length() > item.length() && itemKey.contains(item))
				return itemKey;
		}
		return null;
	}

	private void getRestaurantBasedOnItem(String[] inputItems){
		Set<Integer> restIds= restaurantsMenuCard.keySet();
		for(String item:inputItems){
			for(Integer restId:restIds){
				if(!((Restaurant)restaurantsMenuCard.get(restId)).getItemList().contains(item)){
					restaurantsMenuCard.remove(restId);
				}
			}
		}
	}
}
