package com.godoro.pattern;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductRepository {
	
	private String driver="com.mysql.cj.jdbc.Driver";
	//String url="jdbc:mysql://localhost:3306/madb"+"?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=Turkey";
	private String url="jdbc:mysql://localhost:3306/madb"		
	+ "?allowPublicKeyRetrieval=true"			
	+ "&useSSL=false"			
	+ "&useUnicode=true"		
	+ "&useLegacyDatetimeCode=false"		
	+ "&serverTimezone=Turkey";
	
	private String user="root";
	
	
	private String passwor="2020*";


	public ProductRepository() {
		try {
			Class.forName(driver);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public boolean insert(Product product) throws Exception
	{

		Connection connection=DriverManager.getConnection(url,user,passwor);
		

		String sql="insert into Product (productNam,salesPrice) values(?,?)";
		
		PreparedStatement statement=connection.prepareStatement(sql);
		statement.setString(1, product.getProductName());
		statement.setDouble(2, product.getSalesPrice());
		int affected=statement.executeUpdate();
		
		return affected>0;
		
		
		
	}
	
	public List<Product> list() throws Exception
	{
		List<Product> productList=new ArrayList<Product>();
		

		Connection connection=DriverManager.getConnection(url,user,passwor);
		

		String sql="select *from Product";
		PreparedStatement statement=connection.prepareStatement(sql);
		ResultSet resultSet=statement.executeQuery();
		while(resultSet.next())
		{
			long productId=resultSet.getLong("productId");
			String productName=resultSet.getString("productNam");
			double salesPrice=resultSet.getDouble("salesPrice");
			Product product=new Product(productId,productName,salesPrice);
			productList.add(product);
		}
		connection.close();
		
		return productList;
		
		
	}
	

}
