import java.io.*;

public class Friends
{
	public static int [][] friends;
	public static int posB;
	
	
	public static void recursive(String history, int pos, int target, int size, int h, int count)
	{
		
		if (history.indexOf("*" + pos + "*") >= 0)
		{
			//System.out.println("HISTORY");
			System.out.println("No");
			return ;
		}
		
		history += pos + "*";
		
		if (pos == target)
		{
			System.out.println("Yes " + count);
			return;
		}
		
		for (int i = 0; i < size; i ++)
		{
			//System.out.println("Array: " + friends[i][0] + " " + friends[i][1]);

			
			if (friends[i][0] == pos)
			{
				System.out.println(pos);
				//System.out.println(tempCount + " " + count);
				//System.out.println(friends[i][1] + " " + posB);
				
				recursive(history, friends[i][1], target, size, h, count++);
			}
		}
	}
	
	public static void main(String args[]) throws IOException
	{
		DataInputStream in = new DataInputStream(System.in);
		int n = Integer.parseInt(in.readLine());
		
		friends = new int [n][2];
		
		int [][] temp = new int [9999][2];
		
		String history = "*";
		
		int f1=-1, f2=-1, tempR=0, h =0, count=0;
		
		for (int i = 0; i < 6; i ++)
		{
			friends[i][0] = Integer.parseInt(in.readLine());
			friends[i][1] = Integer.parseInt(in.readLine());
		}
		
		while(f1 != 0 || f2 != 0)
		{
			f1 = Integer.parseInt(in.readLine());
			temp[tempR][0] = f1;
			f2 = Integer.parseInt(in.readLine());
			temp[tempR][1] = f2;
			tempR++;
		}
		
		for (int i = 0; i < tempR - 1; i ++)
		{
			count = 0;
			recursive(history, temp[i][0], temp[i][1], n, h, count);
		}
	}
}