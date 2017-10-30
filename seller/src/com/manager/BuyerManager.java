package com.manager;

import java.io.File;

import com.buyer.Buyer;
import com.common.DataClassManager;

public class BuyerManager {
	DataClassManager dcm;
	
	public BuyerManager(){
		dcm = new DataClassManager();
	}
	
	public boolean createBuyer(String path , Buyer buyer){
		//�⺻ ������ path�� �ؾ���
		
		String id = buyer.getId();
		String newPath = path+"/"+id;
		File file = new File(newPath);
		if(file.exists())
			return false;
		else
			file.mkdirs();
		dcm.save(buyer, newPath+"/buyer.data");
		return true;
	}
	public Buyer getBuyer(String path , String id){
		//path �� �⺻������ ���̵� �߰��Ǿ����.
		Buyer output = null;
		output = (Buyer)dcm.load(path+"/"+id+"/buyer.data");
		return output;
	}
}
