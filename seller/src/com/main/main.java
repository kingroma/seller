package com.main;

import com.buyer.Buyer;
import com.common.CurrentTime;
import com.common.ManagerStaticAttribute;
import com.common.ProductFileNumber;
import com.common.RefreshFileSystem;
import com.manager.Admin_BuyerManager;
import com.manager.Admin_ProductManager;
import com.manager.Admin_SellerManager;
import com.manager.BuyerManager;
import com.product.Product;
import com.seller.Seller;

public class main {
	
	public static String dataPath = "C:/Users/Test1/Place/data/data";
	public static String buyerDataPath = dataPath+"/buyer";
	public static String sellerDataPath = dataPath+"/seller";
	public static String productDataPath = dataPath+"/product";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CurrentTime ct = new CurrentTime();
		System.out.println(ct.getTime());
		
		
		//RefreshFileSystem rfs = new RefreshFileSystem();
		
		//ProductFileNumber pfn = new ProductFileNumber();
		//System.out.println(pfn.getFileNum());
		//System.out.println(ct.getTime());
		
		//AdminBuyerManagerTest();
		//BuyerManagerTest();
		AdminSellerManagerTest();
		//SellerManagerTest();
		//ProductManagerTest();
		
	}
	public static void ProductManagerTest(){
		Admin_ProductManager apm = new Admin_ProductManager();
		Product product = new Product();
		product.setProduct_num("A0");
		product.setPrice("1");
		product.setSeller("guest");
		product.setStatus("ing");
		product.setTextarea("hello");
		product.setTitle("test");
		apm.createProduct(productDataPath, product);
	}
	public static void SellerManagerTest(){
		
	}
	/*
	long time = System.currentTimeMillis(); 

	SimpleDateFormat dayTime = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
													 0123456789012345678
	String str = dayTime.format(new Date(time));

	//System.out.println(str);
	return str;
	 */
	public static void AdminSellerManagerTest(){
		
		Admin_SellerManager asm = new Admin_SellerManager();
		//Seller s = asm.getSeller(ManagerStaticAttribute.sellerDataPath, "kingroma");
		
		//System.out.println(s.getId());
		/*
		Seller s = asm.getSeller(ManagerStaticAttribute.sellerDataPath, "guest");
		//System.out.println(s.getSell_product().get(index));
		
		for(int i = 0 ; i < s.getSell_product().size() ; i ++){
			System.out.println(s.getSell_product().get(i).getProduct_num());
		}
		*/
		
		Seller seller = new Seller();
		seller.setId("test");
		seller.setAdress("서울");
		seller.setBirth("92");
		seller.setJoin_date("test");
		seller.setMail("test@a.com");
		seller.setPhone("010");
		seller.setPw("4235");
		
		asm.createSeller(ManagerStaticAttribute.sellerDataPath, seller);
		
		
		
		//String id = "guest";
		//Seller seller = asm.getSeller(sellerDataPath,id);//아이디까지 일치
		//System.out.println(seller.getPhone());
		
		
		
		//seller.getSell_product().add(arg0);
		
	}
	public static void BuyerManagerTest(){
		BuyerManager bm = new BuyerManager();
		
		Buyer buyer = new Buyer();
		buyer.setId("kingroma");
		bm.createBuyer(buyerDataPath,buyer);
		
		String id = "kingroma";
		Buyer buyer2 = bm.getBuyer(buyerDataPath,id);//아이디까지 일치
		System.out.println(buyer2.getId());
		
	}
	public static void AdminBuyerManagerTest(){
		Admin_BuyerManager abm = new Admin_BuyerManager();
		
		//Buyer buyer = new Buyer();
		//buyer.setId("kingroma3");
		//abm.createBuyer(buyerDataPath, buyer);
		
		//String id = "kingroma3";
		//Buyer buyer = abm.getBuyer(buyerDataPath,id);//아이디까지 일치
		//System.out.println(buyer.getId());
		
		
	}
	
}
