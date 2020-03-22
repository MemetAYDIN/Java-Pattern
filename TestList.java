package com.godoro.pattern;

import java.util.List;

public class TestList {
	
	public static void main(String[] args) throws Exception {
		
		
		ProductRepository productRepository=new ProductRepository();
		List<Product> productList=productRepository.list();
		for(Product product:productList)
		{
			System.out.println(product.getProductId()+" "
					+product.getProductName()+
					" "+product.getSalesPrice());
		}
		
	}

}
