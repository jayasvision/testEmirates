package com.shop.business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.shop.model.Product;
import com.shop.model.ShoppingCartEntry;
import com.shop.model.ShoppingCartMap;
import com.shop.service.ProductService;
import com.shop.utils.PriceStrategy;
import com.shop.utils.PriceStrategyRaw;
import com.shop.utils.PriceStrategyTax;
import com.shop.utils.PriceUtilities;

@Component
public class ShoppingHandlerImpl implements ShoppingHandler {
	
	@Autowired
	private ProductService productService;
	
	private PriceStrategy priceHandler;
	
	@Override
	public List<ShoppingCartEntry> getShoppingCartEntries(ShoppingCartMap shoppingCartMap) {
		List<ShoppingCartEntry> shoppingCarts = new ArrayList<>();
		
		for(String productCode : shoppingCartMap.getCartItems().keySet() ) {
			Product p = productService.findByProductCode(productCode);
			
			ShoppingCartEntry s = new ShoppingCartEntry();
			
			int quantity = shoppingCartMap.getQuantity(productCode);
			
			s.setImageUrl(p.getImageUrl());
			s.setProductName(p.getProductName());
			s.setPrice(p.getPrice());
			s.setProductTotalPrice( p.getPrice() * quantity );
			s.setQuantity(quantity);
			
			shoppingCarts.add(s);
		}
		
		return shoppingCarts;
	}

	@Override
	public String getTotalPrice(List<ShoppingCartEntry> shoppingCartEntries) {
		priceHandler = new PriceStrategyRaw();
		
		return PriceUtilities.roundToTwoDecimalPlaces(priceHandler.getTotal(shoppingCartEntries));
	}

	@Override
	public String getTotalTax(List<ShoppingCartEntry> shoppingCartEntries) {
		priceHandler = new PriceStrategyTax();
		
		return PriceUtilities.roundToTwoDecimalPlaces(priceHandler.getTotal(shoppingCartEntries));
	}
	
}
