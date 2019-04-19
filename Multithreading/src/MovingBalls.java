/* *****************************************************************
Program For :-  wait & notifyAll Demo using moving balls

                 SangeetaJ
                Mphasis Ltd

******************************************************************** */

import java.awt.*;

public class MovingBalls extends Frame implements Runnable
{
	Thread t1, t2, t3; 
	int x1 = 10, x2 = 10, x3 = 10;
	
	public MovingBalls()
	{
		t1 = new Thread(this, "ball1");
		t2 = new Thread(this, "ball2");
		t3 = new Thread(this, "ball3");
		
		t1.start();
		t2.start();
		t3.start();
	}

	public void run()
	{
		try
		{
			if(Thread.currentThread() == t1)
			{
				while(true)
				{
					x1 = x1 + 10;
					repaint();
					Thread.sleep(100);
					synchronized(this)
					{
						if(x1 == 400)
						{
							wait();
							x1 = 10;
						}
					}
				} // end of for
			} // end of if
			else
			{
				if(Thread.currentThread() == t2)
				{
					while(true)
					{
						x2 = x2 + 10;
						repaint();
						Thread.sleep(200);
						//synchronized(this)  //1//
						{
							if( x2 == 400)
							{
								wait();
								x2 = 10;
							}
						}
						
					} // end of for
				} // end of if
				else
				{
					while(true)
					{
						x3 = x3 + 10;
						repaint();
						Thread.sleep(300);
						synchronized(this)
						{
							if( x3 == 400)
							{
								notifyAll();
								x3 = 10;
							}
						}
					} // end of for
				} // end of else
			} // end of outer else
		} // end of try
		catch(InterruptedException ie)
		{

		}
	}

	public void paint(Graphics g)
	{
		g.setColor(Color.red);
		g.fillOval(x1, 100, 50, 50);

		g.setColor(Color.green);
		g.fillOval(x2, 200, 50, 50);

		g.setColor(Color.blue);
		g.fillOval(x3, 300, 50, 50);
	}
		
	public static void main(String[] args) 
	{
		MovingBalls m1 = new MovingBalls();
		m1.setSize(500, 500);
		m1.setVisible(true);
	}
}











/*
If a block is synchronized - then lock is put onto the object 

*/
/*	public void update(Graphics g){
		super.update(g);
}*/
