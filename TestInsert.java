package com.godoro.pattern;

public class TestInsert {
	
	public static void main(String[] args) throws Exception {
		Product product=new Product(0,"Fritoz",195);
		ProductRepository productRepository=new ProductRepository();
				boolean inserted=productRepository.insert(product);
		System.out.println("Eklenmiş: "+inserted);
	}

}
