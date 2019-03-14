import java.lang.Thread;
import java.util.Scanner;

public class Fibonacci extends Thread
{
	private int x;
	public  int answer;

	public Fibonacci(int x) 
	{
		this.x = x;
	}

	public void run() 
	{
		if( x < 2 )
			answer = 1;
		else 
		{
			try 
			{
				Fibonacci f1= new Fibonacci(x-1);
				Fibonacci f2= new Fibonacci(x-2);
				Thread threadf1= new Thread(f1);
				Thread threadf2= new Thread(f2);
				threadf1.start();
				threadf2.start();
				threadf1.join();
				threadf2.join();

				answer = f1.answer + f2.answer;

			}
			catch(InterruptedException ex) { }
		}
	}

	public static void main(String[] args)
	{
		try 
		{
			Scanner in = new Scanner(System.in);
			System.out.print("How many Fibonacci numbers: ");
			int n = in.nextInt();
			in.close();
				for (int i=0;i<n;i++)
				{
					Fibonacci f= new Fibonacci(i);
					Thread threadf= new Thread(f);
					threadf.start();
					threadf.join();

					System.out.print(f.answer + " ");

				}
			}

		catch(Exception e) 
		{
			System.out.println("usage: java Fib NUMBER");
		}
	  }
}