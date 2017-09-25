package com.shop.utils;

import java.util.List;

import com.shop.model.ShoppingCartEntry;

public class PriceStrategyTax implements PriceStrategy {

	@Override
	public double getTotal(List<ShoppingCartEntry> shoppingCartEntries) {
		double total = 0.0;
		
		for(ShoppingCartEntry e : shoppingCartEntries) {
			total += e.getProductTotalPrice() * 0.18;
		}
		
		return total;
	}

}
