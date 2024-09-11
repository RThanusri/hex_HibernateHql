package com.Dao;

public interface DaoInterface {
	boolean addNewItem (int pid, String name,Double price,int quantity);
	
    boolean removeItem(int pid);
    
	boolean updatePrice (int pid);
	boolean calculateTotalBill (int pid , int quantity);

}
