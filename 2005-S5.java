import java.io.*;
public class PrimeNumber 
{

	public static void main(String[] args) throws IOException
	{
		DataInputStream in = new DataInputStream(System.in);
		int input;
		int check;
		int counter = 0;
		System.out.print("Enter a number: ");
		input = Integer.parseInt(in.readLine());
		
		for (int i = 2; i < input; i++)
		{
			check = input % i;
		
			if (check == 0)
			{
				counter += 1;
			}
		}
		
		if (counter == 0)
		{
			System.out.println("Prime number");
		}
		else
		{
			System.out.println("Not a prime number");
		}
	
	}

}
