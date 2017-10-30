package com.manager;

import java.io.File;

import com.common.DataClassManager;
import com.product.Product;

public class Admin_ProductManager {
	DataClassManager dcm;
	public Admin_ProductManager(){
		dcm = new DataClassManager();
	}
	
	public boolean createProduct(String path , Product product){
		
		String num = product.getProduct_num();
		String newPath = path+"/"+num;
		File file = new File(newPath);
		if(!file.exists())
			file.mkdirs();
		dcm.save(product, newPath+"/product.data");
		return true;
	}
	
	public Product getProduct(String path , String num){
		Product output = null;
		output = (Product)dcm.load(path+"/"+num+"/product.data");
		return output;
	}
	public void fixProduct(String path, Product product){
		String num = product.getProduct_num();
		String newPath = path+"/"+num;
		File file = new File(newPath);
		dcm.save(product, newPath+"/product.data");
		System.out.println("변경 성공 ");
	}
	
	
	
	
	
	
	public void Admin_Product_Init(String path){
		
	}
	
	public void Admin_Product_Add(String path , Product p){
		
	}
	
	public void Admin_Product_Delete(String path){
		
	}
	
	public void Admin_Product_Fix(String path , Product p){
		
	}
	
	public void Admin_Product_Save(String path){
		
	}
}
