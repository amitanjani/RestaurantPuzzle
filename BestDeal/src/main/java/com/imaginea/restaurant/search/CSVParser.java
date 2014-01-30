package com.imaginea.restaurant.search;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.imaginea.restaurant.model.ItemDetail;
import com.imaginea.restaurant.model.Restaurant;

public class CSVParser {
	private String cvsSplitBy = ",";
	
	public CSVParser(){
	}
	
	public Map<Integer, Restaurant> readCSVFile(String csvFile) {
		Map<Integer, Restaurant> restMap = new HashMap<Integer, Restaurant>();
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(csvFile));
			Set<Integer> restIds = getRestaurantIds(br);
			Iterator<Integer> itr = restIds.iterator();
			while(itr.hasNext()){
				int restId= itr.next();
				//Reinitialize bufferedReader to read it from beginning for second time.
				if(br.readLine() == null){
					br = new BufferedReader(new FileReader(csvFile));
				}
				ItemDetail itemDetail = getItemDetails(br,restId);
				restMap.put(restId, new Restaurant(restId,itemDetail.getItemList(),itemDetail.getPriceMap()));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return restMap;
	  }
	
	private ItemDetail getItemDetails(BufferedReader br, int restId) throws IOException{
		List<String> itemList = new ArrayList<String>();
		Map<String,Double> priceMap = new HashMap<String,Double>();
		String key=null;
		String line;
		while ((line = br.readLine()) != null) {
			String[] csvLine = line.split(cvsSplitBy);
			if(Integer.parseInt(csvLine[0]) == restId){
				key = csvLine[2].trim();
				itemList.add(csvLine[2].trim());
				for(int i=3;i<csvLine.length;i++){
					itemList.add(csvLine[i].trim());
					key += ", "+csvLine[i].trim();
				}
				priceMap.put(key, Double.parseDouble((csvLine[1].toString().trim())));
			}
		}
		return new ItemDetail(itemList, priceMap);
	}
	
	private Set<Integer> getRestaurantIds(BufferedReader br) throws IOException{
		Set<Integer> restIds = new HashSet<Integer>();
		String line;
		while ((line = br.readLine()) != null) {
			String[] csvLine = line.split(cvsSplitBy);
			restIds.add(Integer.parseInt(csvLine[0].trim()));
		}
		return restIds;
	}
}
