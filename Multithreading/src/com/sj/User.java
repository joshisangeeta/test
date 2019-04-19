package com.sj;

public class User {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	     Thread tobj = new IncrementThread();
	    Thread t1 = new Thread(tobj,"t1");
	     Thread t2 = new Thread(tobj,"t2");
	       t1.setName("t1");
	       t2.setName("t2");
	        t1.start();
	       t2.start();
	       System.out.println("main thread running...");
	       
	}

}
