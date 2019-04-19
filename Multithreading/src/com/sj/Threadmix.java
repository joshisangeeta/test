package com.sj;
import java.awt.*;
import java.util.*;
class Threadmix extends Frame implements Runnable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	Thread t1,t2,t3;
	
	String s="String 1";
	String s1="String 2";
	int x1=0,x2=450;
	int x,y;
    public Threadmix()
	{
		t1=new Thread(this,"t1");
		t2=new Thread(this,"t1");
		t3=new Thread(this,"t1");
        t1.start();
		t2.start();
		t3.start();
		

	 }
	public void paint(Graphics g)
	{
		g.setColor(Color.blue);
		Font f=new Font("Ariel",Font.ITALIC,30);
		g.setFont(f);
        g.drawString(s,x1,200);
		g.drawString(s1,x2,200);
		
		
	}
	public void run()
	{
		try
		{
			for(;;)
		  {
		     if(Thread.currentThread()==t1)
			  {
			if(x1<400)
		   {
			x1=x1+5;
		   Thread.sleep(100);
		   repaint();
		   }
		   else 
			   x1=0;
			  }
           if(Thread.currentThread()==t2)
			  {
		     if(x2>10)
		      {
			    x2=x2-5;
			 
		       Thread.sleep(100);
		       repaint();
		       }
			   else
				  x2=400;
              }
		   
		  }
		}
		catch (Exception e)
		{
		}
	}

	public static void main(String[] args) 
	{
        Threadmix tm=new Threadmix();
		tm.setSize(500,500);
		tm.setVisible(true);
		System.out.println("Hello World!");
	}
}
