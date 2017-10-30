package com.common;

import com.buyer.Buyer;
import com.order.*;
import com.product.Product;
import com.seller.Seller;

import java.util.ArrayList;
public class SortArrayList {
	public SortArrayList(){
		
	}
	public ArrayList<Order> SortOrder(ArrayList<Order> order_list){
		
		if(order_list == null)
			return null;
		else {
			ArrayList<Order> temp = new ArrayList<Order>();
			for(int i = order_list.size()-1 ; i >=0  ; i --){
				temp.add(order_list.get(i));
			}
			return temp;
		}
		
	}
	public ArrayList<Product> SortProduct(ArrayList<Product> product_list){
		
		if(product_list == null)
			return null;
		else {
			ArrayList<Product> temp = new ArrayList<Product>();
			for(int i = product_list.size()-1 ; i >=0  ; i --){
				temp.add(product_list.get(i));
			}
			return temp;
		}
		
	}
	public ArrayList<Buyer> SortBuyer(ArrayList<Buyer> buyer_list){
		
		if(buyer_list == null)
			return null;
		else {
			ArrayList<Buyer> temp = new ArrayList<Buyer>();
			for(int i = buyer_list.size()-1 ; i >=0  ; i --){
				temp.add(buyer_list.get(i));
			}
			return temp;
		}
		
	}
	public ArrayList<Seller> SortSeller(ArrayList<Seller> seller_list){
		
		if(seller_list == null)
			return null;
		else {
			ArrayList<Seller> temp = new ArrayList<Seller>();
			for(int i = seller_list.size()-1 ; i >=0  ; i --){
				temp.add(seller_list.get(i));
			}
			return temp;
		}
		
	}
}
