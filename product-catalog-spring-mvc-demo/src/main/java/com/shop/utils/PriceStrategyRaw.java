package com.shop.utils;

import java.util.List;

import com.shop.model.ShoppingCartEntry;

public class PriceStrategyRaw implements PriceStrategy {

	@Override
	public double getTotal(List<ShoppingCartEntry> shoppingCartEntries) {
		double total = 0.0;
		
		for(ShoppingCartEntry e : shoppingCartEntries) {
			total += e.getProductTotalPrice();
		}
		
		return total;
	}

}
