package com.sj;

public class ThreadsDemo extends Thread{
     int x1,x2;
     Thread t1,t2;
     int ctr;
     public ThreadsDemo()
     {   ctr=1;
    	 x1 =0;
    	 x2=400;
    	 t1=new Thread(this,"t1");
    	 t2=new Thread(this,"t2");
    	 t1.start();
    	 t2.start();
     }
     public void run()
     {
    	 while(ctr<20){
    	 if (Thread.currentThread()== t1)
    	 {
    		 if(x1<400)
    		 { 
    			 x1=x1+10;
    			 System.out.println(x1);
    		 }
    		 else
    			 x1=0;
    	 }
    	 if (Thread.currentThread()== t2)
    	 { 
    		 if(x2>0)
    		 { 
    			 x2=x2-10;
    			 System.out.println(x2);
    		 }
    		 else
    			 x2=400;
    		 
    	 }
    	   try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	   ctr++;
    	 }
     }
     
     
	public static void main(String[] args) {
		// TODO Auto-generated method stub
           ThreadsDemo d1 =new ThreadsDemo();
	}

}
