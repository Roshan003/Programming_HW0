import java.lang.Thread;
import java.util.Scanner;

//Hannah Ajayi and Granit Dedushi

public class Prime extends Thread
{
	private int givenNum;
	
	public Prime(int givenNum)
	{
		this.givenNum = givenNum;
	}
	
	public void SmallerPrimeNumbers() {
		int count = 0;
		for (int i = 2; i <= givenNum; i++) {

			if (isPrime(i)) {
				System.out.print(i + " ");
			}
		}
	}
	
	public static boolean isPrime(int n)
	{
		for(int i = 2; i < n; i++)
		{
			if(n % i == 0)
				return false;
		}
		return true;
	}
	
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		System.out.print("Prime number you choose: ");
		int num = in.nextInt();
		in.close();
		Prime p = new Prime(num);
		p.start();
		Thread.yield();
		
		p.SmallerPrimeNumbers();
		
	}

}
