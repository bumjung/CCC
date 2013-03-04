import java.io.*;

public class WaterPark
{
	public static int count = 0;
	public static int n;
	public static void recursive (int [][] a, int pos, int size)
	{
		if (pos == n)
		{
			count++;
			return;
		}
		
		for (int i = 0; i < size; i ++)
		{
			//System.out.println("Array: " + a[i][0] + " " + a[i][1]);
			//System.out.println("pos :" + pos + " " + n);
			if (a[i][0] == pos)
			{
				//System.out.println("nPos: " + nPos);
				recursive(a, a[i][1]);
			}
			//System.out.println("nPos: " + nPos);
		}
	}
	
	public static void main(String args[]) throws IOException
	{
		DataInputStream in = new DataInputStream(System.in);
		
		int [][] temp = new int [100][2];
		
		n = Integer.parseInt(in.readLine());
		
		int a = -1,b = -1;
		int tempR = 0;
		
		while(a != 0 || b != 0)
		{
			a = Integer.parseInt(in.readLine());
			temp[tempR][0] = a;
			b = Integer.parseInt(in.readLine());
			temp[tempR][1] = b;
			
			tempR ++;
		}
		
		//for (int i = 0; i < 100; i ++)
		//{
		//	System.out.println(temp[i][0] + " " + temp[i][1]);
		//}
		
		recursive(temp, 1, tempR);
		System.out.println(count);
		
	}
}