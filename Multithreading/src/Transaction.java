/* program for Synchronization */

class Account 
{
	int acc_no;
	String name;
	int bal ;
	int min_bal = 1000;
	
	Account()
	{
		bal = 5000;
	}

	  public void withDraw(int amt)			//synchronized
	{
		int temp=0;
		//System.out.println("WPrev Balance is "+ bal);
		temp = bal - amt;
		if(temp < min_bal)
		{
			System.out.println("Can't withdraw : "+ amt + " Resulting in Minimum bal");
		}
		else
		{
			try
			{
				Thread.sleep(100);
			}
			catch(InterruptedException e)
			{
				System.out.println(e);
			}
			
			bal = bal - amt;
		}
		
		System.out.println("Ur current balance after Withdraw is " + bal);
	}

	 public void deposit(int amt)
	{
		//System.out.println("DPrev Balance is "+ bal);
		if(amt <= 0)
		{
			System.out.println("Can't deposit : "+ amt + " amt must be > 0");
		}
		else
		{
			bal = bal + amt;
			try
			{
				Thread.sleep(100);
			}
			catch(InterruptedException e)
			{
				System.out.println(e);
			}
		}
		System.out.println("Ur current balance after Deposit is " + bal);

	}
}

class Transaction extends Thread
{
	
	Account a;
	boolean operation;
	int amt;

	Transaction(Account a, boolean operation, int amt)
	{
		this.a = a;
		this.operation = operation;
		this.amt = amt;
	}
	
	public void run()
	{
		//1//synchronized(a)
		{
			if(operation == true) // withdraw
			{
				a.withDraw(amt);
			}
			else				  // deposit
			{
				a.deposit(amt);
			}
		}
	
	}
	
	public static void main(String[] args) 
	{
		final boolean withdraw = true, deposit = false;
		Account a1 = new Account();

		Transaction t1 = new Transaction(a1,withdraw,1000);
		Transaction t2 = new Transaction(a1,withdraw,2000);
		//Transaction c3 = new Transaction(a1,withdraw,100);
		t1.start();
		t2.start();
		//c3.start();
	}
};

