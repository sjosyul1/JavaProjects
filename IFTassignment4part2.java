package Assignment3;

import java.util.Scanner;

public class IFTassignment4part2 
{

	public static void main(String[] args)
	{

		Scanner sc= new Scanner(System.in);
		System.out.println("enter the no of digits you want to enter");
		int n = sc.nextInt();//taking count of input bits
		int inputArr[]= new int[2*n];
		//int OutArr[]= new int [1000];
		System.out.println("Enter the binary digits in sequence");// taking the input from user
		for(int i =0 ; i<n; i++)
		{
			inputArr[i]= sc.nextInt();
		}
		//checking the input by printing
		for(int i =0 ; i<n; i++)
		{
			System.out.print(inputArr[i]);
		}
		System.out.println();
		//applying the logic 
	  for(int i=0; i<n; i++)//iterating through loop
		{
			if(inputArr[i]==1 && inputArr[i+1]==1 && inputArr[i+2]==1 && inputArr[i+3]==1  &&inputArr[i+4]==1&& inputArr[i+5]==0)
			{
				if(inputArr[i-1]==0)//flags check
				{
					for(int j=i+5; j<n-1;j++)
						{
					//left shifting if sequence of 5 continuos elements are 1
						inputArr[j]	=inputArr[j+1];
						}
				}
				n=n-1;
				i=i+5;
				
			}
		}
		//printing the output
      System.out.println("Result:");
      for(int i =0 ; i<n; i++)
		{
			System.out.print(inputArr[i]);
		}
	}
		

}

