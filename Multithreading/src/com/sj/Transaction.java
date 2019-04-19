package com.sj;

public class Transaction extends Thread {
     Thread t1,t2;
     Account a1;
       
     public Transaction() {
		super();
		// TODO Auto-generated constructor stub
		a1 = new Account(1,"aaa",5000);
		t1=new Thread(this,"t1");
		t2=new Thread(this,"t2");
		t1.start();
		t2.start();
		
		
     }

	public void run()
     {
    	 if(Thread.currentThread()==t1)
    	 {
    		 a1.withdraw(3000);
    		 try {
    				Thread.sleep(300);
    			} catch (InterruptedException e) {
    				// TODO Auto-generated catch block
    				e.printStackTrace();
    			}
    		 System.out.println("withdrawn by t1");
    		 
    	 }
    	 if(Thread.currentThread()==t2)
    	 {
    		 a1.withdraw(3000);
    		 System.out.println("withdrawn by t2");
    	 }
    	 try {
			Thread.sleep(400);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	 
     }
     
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	     Transaction tr = new Transaction();
	
	}

}
