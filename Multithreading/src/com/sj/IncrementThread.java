package com.sj;

public class IncrementThread extends Thread {
       int i1;
         @Override
	     public void run()
         {
        	if(Thread.currentThread().getName().equals("t1")) 
        	{   
        		this.i1++;
        		System.out.println("t1 running..i1 is "+i1);
        		
        	}
        	else
        	{
        		i1--;
        		System.out.println("t2 is running..i1 is"+ i1);
        	}
        		
        		
        		try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        		
        		
         }







}
