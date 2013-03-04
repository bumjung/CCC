import java.io.*;


public class CrossSpiral
{


    public static void main (String[] args) throws IOException
    {
        DataInputStream in = new DataInputStream (System.in);
        
        int totalC = Integer.parseInt (in.readLine ());
        int totalR = Integer.parseInt (in.readLine ());
        int smallC = Integer.parseInt (in.readLine ());
        int smallR = Integer.parseInt (in.readLine ());
        boolean[] [] room = new boolean [totalR] [totalC];
        int [][] test = new int[totalR][totalC];
        int count = Integer.parseInt (in.readLine ());
        
        for (int i = 0 ; i < totalR ; i++)
        {
            for (int j = 0 ; j < totalC ; j++)
            {
                room [i] [j] = true;
                test[i][j] = 0;
                
            }
        }
        
        for (int i = 0 ; i < smallR ; i++)
        {
            for (int j = 0 ; j < smallC ; j++)
            {
                room [i] [j] = false;
                test[i][j] = 1;
            }
        }
        for (int i = room.length - smallR ; i < room.length ; i++)
        {
            for (int j = 0 ; j < smallC ; j++)
            {
                room [i] [j] = false;
                test[i][j] = 1;
            }
        }
        for (int i = 0 ; i < smallR ; i++)
        {
            for (int j = room [0].length - smallC ; j < room [0].length ; j++)
            {
                room [i] [j] = false;
                test[i][j] = 1;
            }
        }
        for (int i = room.length - smallR ; i < room.length ; i++)
        {
            for (int j = room [0].length - smallC ; j < room [0].length ; j++)
            {
                room [i] [j] = false;
                test[i][j] = 1;
            }
        }
        /*for (int i = 0; i < totalC; i ++)
        {
        for (int j = 0; j < totalR; j ++)
        {
        if(room[i][j] == true)
        {
        System.out.print("T");
        }
        else
        {
        System.out.print("F");
        }
        }
        System.out.println("");
        }*/
        
        char dir = 'e';
        int c = smallC, r = 0, step = 1;
        room [r] [c] = false;
        
        while (count != 0)
        {
        	test[r][c] = step++;
        	
        	if(dir == 'e')
        	{	 		        
		        if(r - 1 > -1 && test[r - 1][c] == 0)
		        {
		        	r--;
		        	dir = 'n';
		        }
		        
        		else if (c + 1 < room[0].length && test[r][c+1] == 0)
		        {
		            c++;
		        }
		        
		        else if (r + 1 < room.length && test[r + 1][c] == 0)
		        {
		            r++;
		            dir = 's';
		        }
		   

        	}
        	
        	else if(dir == 's')
	        {
		        	        		        
        		if (c + 1 < room[0].length && test[r][c + 1] == 0)
		        {
		            c++;
		            dir = 'e';
		        }
		        
		        else if (r + 1 < room.length && test[r + 1][c] == 0)
		        {
		            r++;
		        }
	
		        		        
		        else if ( c - 1 > -1 && test[r][c - 1] == 0)
		        {
		        	c--;
		        	dir = 'w';
		        }
		        

	        }
	        
        	else if (dir == 'w')
	        {	
	        	if (r + 1 < room.length && test[r + 1][c] == 0)
		        {
		            r++;
		            dir = 's';
		        }		       
 		        
 		        else if ( c - 1 > -1 && test[r][c - 1] == 0)
		        {
		        	c--;
		      	}
 		        		       
 		        else if(r - 1 > -1 && test[r - 1][c] == 0)
		        {
		        	r--;
		        	dir = 'n';
		        }


	        }
	        
        	else if (dir == 'n')
	        {			        
	            if ( c - 1 > -1 && test[r][c - 1] == 0)
		        {
		        	c--;
		        	dir = 'w';
		        } 
		               
		        else if(r - 1 > -1 && test[r - 1][c] == 0)
		        {
		        	r--;
		        } 
		         	        
        		else if (c + 1 < room[0].length && test[r][c + 1] == 0)
		        {
		            c++;
		            dir = 'e';
		        }	
		        

		     	

	        }
	        
	        
	        for (int i = 0 ; i < totalR ; i++)
	        {
	            for (int j = 0 ; j < totalC ; j++)
	            {
	                System.out.print(test[i][j] + " ");
	            }
	            System.out.println("");
	        }
	        System.out.println("");
	        
            count--;
        }
        
        System.out.println("(" + (c + 1) + "," + (r + 1) + ")");
    }
}
