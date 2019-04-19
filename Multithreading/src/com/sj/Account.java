package com.sj;

import java.io.Serializable;

public class Account implements Serializable,Comparable {
       int id;String name;
       int balance;
	public Account(int id, String name, int balance) {
		super();
		this.id = id;
		this.name = name;
		this.balance = balance;
	}
	public Account() {
		// TODO Auto-generated constructor stub
	}
 synchronized    public void withdraw(int amount)
     {
    	 /*if(amount > balance)
			try {
				throw new InssufficientBalanceExc();
			} catch (InssufficientBalanceExc e) {
				// TODO Auto-generated catch block
				e.displayMsg();
				//e.printStackTrace();
			}
		else  */  	 
    	 balance =balance-amount;
    	 System.out.println("balance after withdrawal is"+balance);
     }
	@Override
	public String toString() {
		return "Account [id=" + id + ", name=" + name + ", balance=" + balance + "]";
	}
	@Override
	public int compareTo(Object arg0) {
		// TODO Auto-generated method stub
		return(this.id -((Account)arg0).id);
	}
}
