	import java.io.*;
	
	public class BridgeCrossing
	{
		public static int fastTime;
		public static String order = "";
		public static void recursive(String [] names, int [] time, int size, int pos, int sum, String hist)
		{
			
			if (pos == names.length)
			{
				if (sum < fastTime)
				{
					fastTime = sum;
					order = hist;
				}		
				//System.out.println(" " + hist + sum);
				return;
			}
			
			String st = "";
			int temp = 0;
			for(int i = pos; i < names.length && i < pos + size; i ++)
			{
				st +=names[i];
				
				if (time[i] > temp)
				{
					temp = time[i];
				}
				
				recursive(names, time, size, i+1, sum+temp, hist+st+"\n");
			}
		}
		
		public static void main(String args[]) throws IOException
		{
			BufferedReader in = new BufferedReader(new FileReader("bridge.in.txt"));
			PrintWriter out = new PrintWriter(new FileWriter("bridge.out.txt"));
			
			//DataInputStream in = new DataInputStream(System.in);
			
			int size = Integer.parseInt(in.readLine());
			int n = Integer.parseInt(in.readLine());
			
			String [] names = new String [n];
			//String [] names = {"a","b","c","d","e"};
			
			int [] time = new int [n];
			//int [] time = {1,5,5,3,3};
			
			for (int i = 0; i < n; i ++)
			{
				names[i] = in.readLine();
				time[i] = Integer.parseInt(in.readLine());
				fastTime += time[i];
			}
			
			
			recursive(names, time, size, 0, 0, "");
			out.println(fastTime);
			out.println(order);
			in.close();
			out.close();
		}
	}