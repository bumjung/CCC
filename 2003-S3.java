import java.io.*;

public class FloorPlan
{
	
	public static void recursive(int [][] room,int r,int c, int count)
	{
		if(r < 0 || r >= room.length || c < 0 || c >= room[0].length || room[r][c] != 0)
		{
			return;
		}
		
		room[r][c] = count;
		
		recursive(room, r+1, c, count);
		recursive(room, r-1, c, count);
		recursive(room, r, c+1, count);
		recursive(room, r, c-1, count);
		
	}
	
	public static void main(String args[]) throws IOException
	{
		BufferedReader in = new BufferedReader(new FileReader("floor.in.txt"));
		PrintWriter out = new PrintWriter(new FileWriter("floor.out.txt"));
		
		int flooring = Integer.parseInt(in.readLine());
		int r = Integer.parseInt(in.readLine());
		int c = Integer.parseInt(in.readLine());
		
		String [][] temp = new String [r][c];
		int [][] room = new int [r][c];
		
		int count = 1;
		
		for (int i = 0; i < r; i ++)
		{
			for(int j = 0; j < c; j ++)
			{
				temp[i][j] = in.readLine();
				
				if(temp[i][j].charAt(0) == 'I')
				{
					room[i][j] = -1;
				}
				
				else
				{
					room[i][j] = 0;
				}
			}
		}
		
		for (int i = 0; i < r; i ++)
		{
			for(int j = 0; j < c; j ++)
			{
				if(room[i][j] == 0)
				{
					recursive(room, i, j, count);
					count++;
				}
			}
		}
		
		
		int [] size = new int [count-1]; 
		
		for (int i = 0; i < r; i ++)
		{
			for(int j = 0; j < c; j ++)
			{
				if(room[i][j] > -1)
				{
					size[room[i][j]-1] ++;
				}
			}	
		}
		
		/*for (int i = 0; i < size.length; i++)
		{
			System.out.println(size[i]);
		}
			System.out.println("");
		*/
		
		for (int i = 0; i < r; i ++)
		{
			for(int j = 0; j < c; j ++)
			{
				System.out.print(room[i][j]);
			}
			System.out.println("");
		}
		
		int tempHigh=0;
		count = 0;
		
		for(int i = 0; i < size.length; i++)
		{
			tempHigh = size[0];
			int location = 0;
			
			for (int j = 0; j < size.length; j ++)
			{
				if(size[j] > tempHigh)
				{
					tempHigh = size[j];
					location = j;
				}
			}
			
			System.out.println(flooring + "-" + tempHigh + " " + (location+1) + " = " + (flooring-tempHigh));
			flooring-= tempHigh;
			size[location] = 0;
			count++;
		}
		
		System.out.println(count);
		System.out.println(flooring);
			
		in.close();
		out.close();	
	}
}