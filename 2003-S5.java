import java.io.*;
public class TruckingTroubles
{
	public static void recursive (int [][] p, String d, int pos, int weight, String hist)
	{		
		if (dTemp.length() == 0)
		{
			System.out.println(temp + low);
			return;
		}
		
		String temp = hist;
		
		if (hist.indexOf(pos+"") > -1)
		{
			return;
		}
		
		else
		{
			temp += pos;
		}

		String dTemp = d;
		int index = d.indexOf((pos+"").charAt(0));
		
		if (index > -1)
		{		
			dTemp = d.substring(0, index) + "" + d.substring(index + 1, d.length());
		}

		
		for (int i = 0; i < p.length; i ++)
		{
			if (p[i][1] == pos)
			{
				recursive(p, dTemp, p[i][0], temp);
			}
			
			if (p[i][0] == pos)
			{
				recursive(p, dTemp, p[i][1], temp);
			}

		} 
	}

	public static void main (String args[]) throws IOException
	{
		BufferedReader in = new BufferedReader (new FileReader ("truck.in.txt"));

		int cities = Integer.parseInt(in.readLine());
		int roads = Integer.parseInt(in.readLine());
		int destination = Integer.parseInt(in.readLine());

		int [][] path = new int [roads][3];
		String finalD = "";
		int high = 0;
		
		for (int i = 0 ; i < roads; i ++)
		{
			path[i][0] = Integer.parseInt(in.readLine());
			path[i][1] = Integer.parseInt(in.readLine());
			path[i][2] = Integer.parseInt(in.readLine());
			
		}

		for (int i = 0 ; i < roads; i ++)
		{
			System.out.println(path[i][0] + " " + path[i][1] + " " + path[i][2]);
		}

		for (int i = 0; i < destination; i ++)
		{
			finalD += in.readLine();
		}

		recursive(path, finalD, 1, 0, path[0][2], "");
	}
}