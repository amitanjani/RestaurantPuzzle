package com.imaginea.restaurant.search.test;

import junit.framework.TestCase;

import com.imaginea.restaurant.search.BestDeal;

public class BestDealTest extends TestCase {
	
	public void testCase1() {
		System.out.println("Running TestCase1...");
		String csvFile = "src/main/resources/TestCase1.csv";
		BestDeal deal = new BestDeal(csvFile);
		String inputItem ="tofu_log   burger"; 
		deal.pickBestDeal(inputItem);
	}
	
	public void testCase2() {
		System.out.println("Running TestCase2...");
		String csvFile = "src/main/resources/TestCase2.csv";
		BestDeal deal = new BestDeal(csvFile);
		String inputItem = "chef_salad wine_spritzer";
		deal.pickBestDeal(inputItem);
	}
	
	public void testCase3() {
		System.out.println("Running TestCase3...");
		String csvFile = "src/main/resources/TestCase3.csv";
		BestDeal deal = new BestDeal(csvFile);
		String inputItem = " fancy_european_water extreme_fajita";
		deal.pickBestDeal(inputItem);
	}

}
