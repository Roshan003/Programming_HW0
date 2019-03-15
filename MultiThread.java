import java.util.Scanner;

//Mohit Khan

public class MultiThread {

	 public static void main(String []args){
		int n;
		int[] arr;
		final int[] minmax = new int[2]; 
	final double[] avgs = new double[1]; 
		Scanner s = new Scanner(System.in);
		System.out.print("Enter the number of elements :");
		n = s.nextInt();
		arr = new int[n];
	System.out.println("Enter the elements :");
		for (int i = 0; i < n; i++)
			arr[i] = s.nextInt();
		Thread avgThread = new Thread(new Runnable() {
			@Override
			public void run() {
		double avg = 0;
				for (int i = 0; i < n ; i++)
					avg += arr[i];
				avg = avg / n;
		avgs[0] = avg;
			}
		});
		Thread minThread = new Thread(new Runnable() {
			@Override
			public void run() {
				int min = arr[0];
				for (int i = 1; i < n ; i++)
					if (min > arr[i])
						min = arr[i];
				minmax[0] = min;
			}
		});
		Thread maxThread = new Thread(new Runnable() {
			@Override
			public void run() {
				int max = arr[0];
				for (int i = 1; i < n ; i++)
					if (max < arr[i])
						max = arr[i];
				minmax[1] = max;
			}
		});
		avgThread.start();
		minThread.start();
		maxThread.start();
	try {
		avgThread.join();
		minThread.join();
		maxThread.join();
	}
	catch (Exception e) {
	}
   
		System.out.println("Avarage Value :" + avgs[0] + "\n"+ "Minimum Value : " + minmax[0] + "\n" + "Maximum Value : " + minmax[1]);
	 }
	 
}
