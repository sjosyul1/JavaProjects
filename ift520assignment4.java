package Assignment3;

import java.util.Scanner;

public class ift520assignment4 {

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
		for(int i =0 ; i<inputArr.length; i++)
		{
			System.out.print(inputArr[i]);
		}
		System.out.println();
		//applying the logic 
	  for(int i=0; i<n; i++)//iterating through loop
		{
			if(inputArr[i]==1 && inputArr[i+1]==1 && inputArr[i+2]==1 && inputArr[i+3]==1  &&inputArr[i+4]==1)
			{
				for(int j=n-1; j>i+5;j--)
				{
					//right shifting if sequence of 5 continuos elements are 1
					inputArr[j+1]=inputArr[j];
				}
				inputArr[i+5]=0;
				n=n+1;
			}
		}
		//printing the output
      System.out.println("Result:");
      for(int i =0 ; i<inputArr.length; i++)
		{
			System.out.print(inputArr[i]);
		}
	}

}
