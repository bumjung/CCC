import java.io.*;

public class SuperPlumber
{
	 
	 public static int high = 0, count = 0;
	 public static String [][] aHigh;
	 
	 public static void recursive (int [][] g, int r, int c, int sum, int tempCount)
	 {
	  	
		if (r == g.length-1 && c == g[0].length)
		{
				
			if(sum > high && tempCount > count)
			{
							
				for (int i = 0; i < g.length; i ++)
				{
					
					for (int j = 0; j < g[0].length; j ++)
					{
						if(g[i][j] == -2)
						{
							aHigh[i][j] = ">";
						}
						
						else if (g[i][j] == -1)
						{
							aHigh[i][j] ="*";
						}
						
						else
						{
							aHigh[i][j] = g[i][j] + "";
						}
					}
				
				}
				
			 	high = sum;
			}
			return;
		}
		
		if (r < 0 || r >= g.length ||  c < 0 || c >= g[0].length || g[r][c] < 0)
		{
			return;
		}
		//System.out.println(r + " " + c);
			
		
		sum+= g[r][c];
		
		int temp = g[r][c];
		
		g[r][c] = -2;

		
		//System.out.println("(" + r + ", " + c + ")");
		
		recursive(g, r+1, c, sum, tempCount+1);
		recursive(g, r, c+1, sum, tempCount+1);
		recursive(g, r-1, c, sum, tempCount+1);
		
		g[r][c] = temp;
		
	 }
	 
	 public static void main(String args[]) throws IOException
	 {
	 		
		  BufferedReader in = new BufferedReader(new FileReader("SuperPlumber.in.txt"));
		  
		  int r = Integer.parseInt(in.readLine());
		  int c = Integer.parseInt(in.readLine());
		  
		  String temp [][] = new String [r][c];
		  int grid [][] = new int [r][c];
		  aHigh = new String [r][c];
		  
		  for (int i = 0; i < r; i ++)
		  {
		  	
			   for (int j = 0; j < c; j ++)
			   {
			   	
			    	temp[i][j] = in.readLine();
			   
			   }
		  }
		  
		  for (int i = 0; i < r; i ++)
		  {
		  	
			   for (int j = 0; j < c; j ++)
			   {
			   	
				    if (temp[i][j].charAt(0) == '*')
				    {
				    	
				     	grid[i][j] = -1;
				     
				    }
				    
				    else if (temp[i][j].charAt(0) >= '1' && temp[i][j].charAt(0) <= '9')
				    {
				    	
				     	grid[i][j] = Integer.parseInt(temp[i][j] + "");
				     
				    }
				    
				    else
				    {
				     	grid[i][j] = 0;
				    }
			    
			   }
		   
		  }
		  
		for (int i = 0; i < grid.length; i ++)
		{
				
			for (int j = 0; j < grid[0].length; j ++)
			{
				if (grid[i][j] == -1)
				{
					System.out.print("*");
				}
				else
				{
				System.out.print(grid[i][j]);
				}
			}
			System.out.println();
				
		}
		
		System.out.println();
			
		  recursive(grid, r-1, 0, 0, 0);
		  
		for (int i = 0; i < grid.length; i ++)
		{
					
				for (int j = 0; j < grid[0].length; j ++)
				{
					System.out.print(aHigh[i][j]);
				}
				System.out.println();
				
		}
		
		System.out.println(high);
		  
	}
}
