package com.imaginea.restaurant.search;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.imaginea.restaurant.model.Restaurant;

public class CSVParser {
	private String cvsSplitBy = ",";
	
	public CSVParser(){
	}
	
	public Map<Integer, Restaurant> readCSVFile(String csvFile) {
		Map<Integer, Restaurant> restMap = new ConcurrentHashMap<Integer, Restaurant>();
		BufferedReader br = null;
		String line;
		try {
			br = new BufferedReader(new FileReader(csvFile));
			while ((line = br.readLine()) != null) {
				String[] csvLine = line.split(cvsSplitBy);
				int restId = Integer.parseInt(csvLine[0]);
				Double itemPrice = Double.parseDouble(csvLine[1]);
				if(restMap.get(restId)==null){
					Map<String, Double> item_Price_Map = new HashMap<String, Double>();
					item_Price_Map.put(getItemLabel(csvLine), itemPrice);
					restMap.put(restId, new Restaurant(restId, item_Price_Map));
				}else{
					restMap.get(restId).getItem_PriceMap().put(getItemLabel(csvLine), itemPrice);
				}
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
	
	private String getItemLabel( String[] iDetails ){
		String itemLabel = null;
		if(iDetails.length >=2 ){
			itemLabel = iDetails[2].trim();
			for(int i=3;i<iDetails.length;i++){
				itemLabel += ", "+iDetails[i].trim();
			}
		}
		return itemLabel;
	}
}
