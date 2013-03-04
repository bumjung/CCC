import java.io.*;

public class Bowling
{
	public static int high = 0;
	public static void recursive (int [] pin, int adj, int sum, int index, int count, String hist)
	{	
		
		if(count == 0)
		{		
			if (sum > high)
			{
				high = sum;
			}
			
			System.out.println(hist + " = " + sum);
			return;	
		}	
			
		for (int i = index; i <= pin.length-adj; i++)
		{
			int temp=sum;
			String st = "";
			
			for (int j = i; j < adj+i; j++)
			{
				temp+= pin[j];
				st += pin[j];
				//System.out.println(pin[j]);
			}
			
			//System.out.print(" " + temp);
			
			st += ", ";
			
			recursive(pin, adj, temp, i+adj , count-1, hist + st);
			
		}
	}
	
	public static void main(String args[]) throws IOException
	{
		DataInputStream in = new DataInputStream(System.in);
		
		int n = Integer.parseInt(in.readLine());
		int bowling = Integer.parseInt(in.readLine());
		int adj = Integer.parseInt(in.readLine());
		
		int [] pin = new int [n];
		
		for (int i = 0; i < n; i ++)
		{
			pin[i] = Integer.parseInt(in.readLine());
		}

		recursive(pin, adj, 0, 0, bowling, "");
		
		System.out.println(high);
	}
}
