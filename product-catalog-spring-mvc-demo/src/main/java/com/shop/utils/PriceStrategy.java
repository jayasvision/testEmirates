package com.shop.utils;

import java.util.List;

import com.shop.model.ShoppingCartEntry;

public interface PriceStrategy {
	
	public double getTotal(List<ShoppingCartEntry> shoppingCartEntries);
	
}
