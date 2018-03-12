package Assignment3;

import java.util.Scanner;

public class boothsAlgorithmForDivision {

	public static void main(String[] args) 
	{
		/* declaring input arrays */	
		  int dividend[]= new int[8];
			 int divisor[]= new int[8];
			 
			 int num1;
			 int num2;
			 
			 /* Taking input through keyboard */
				Scanner sc= new Scanner (System.in)	;
				System.out.println("Please give the value of dividend");
				/* accepting decimal inputs */
				 num1= sc.nextInt();
				
				System.out.println("Please give the divisor");
				
				 num2= sc.nextInt();
				 
				 dividend= integerToBinary(num1);
				  divisor= integerToBinary(num2);	
				  System.out.println("dividend is:");
				  for(int i=0; i<8; i++)
				  {
				  System.out.print(dividend[i]);
				  }
				  System.out.println("\n \n");
				  System.out.println("divisor is:");
				  for(int i=0; i<8; i++)
				  {
				  System.out.print(divisor[i]);
				  }
				  System.out.println("\n \n");
				  /* Declaring and initializing accumulator and Q registers */
					int A[]={0,0,0,0,0,0,0,0};

					 int Q[]=dividend;
					 
					 int M []= complement(divisor);
					 System.out.println("A is:");
					  for(int i=0; i<8; i++)
					  {
					  System.out.print(A[i]);
					  }
					  System.out.println("\n \n");
					  System.out.println("Q is:");
					  for(int i=0; i<8; i++)
					  {
					  System.out.print(Q[i]);
					  }
					  System.out.println("\n \n");
					  System.out.println("M :");
					  for(int i=0; i<8; i++)
					  {
					  System.out.print(M[i]);
					  }
					  System.out.println("\n \n");
					 
					 /* declaring and initializing counter */
						int count =0;
						/* iterating through loop */
	while(count<=7)
{
LeftShift(A, Q);
A=Add(A, M);
if(A[0]==1)
{
	Q[7]=0;
}
if(A[0]==0) 
{
	Q[7]=1;
}
if(A[0]==1)
{
	A=Add(A, divisor);//restoring
}
count++;

/* printing all registers after each operation (A,Q,) */

System.out.println("\n \n ");		
System.out.println("values of each registers after operation "+ count);
System.out.println("value of A:");
for(int i=0; i<8; i++)
{
System.out.print(A[i]);
}
System.out.println(" ");
System.out.println("value of Q:");
for(int i=0; i<8; i++)
{
System.out.print(Q[i]);
}
System.out.println("  ");
System.out.println("value of M:");
for(int i=0; i<8; i++)
{
System.out.print(M[i]);
}
System.out.println("  ");
		}sc.close();
		/*printing complement values of A and Q registers based on condition*/
		if(count==8)
		{
			if(num1<0 && num2>0 || num1>0 && num2<0 )
			{
				Q= complement(Q);
				
				System.out.println("\n since Quotient is negative it's 2's complement of Q register ");
				for(int i=0; i<8; i++)
				{
				System.out.print(Q[i]);
				}
				
			}
			if(( num1%num2)<0)
			{
				A= complement(A);
				System.out.println("\n since Remainder is negative it's 2's complement of A register is");
				for(int i=0; i<8; i++)
				{
				System.out.print(A[i]);
				}
			}
		}
		System.out.println("\n output in decimal format");
		int x= num1%num2;
		int y= num1/num2;
		
		System.out.println(y+"R"+x + " where "+y+ " is the quotient and " +x+ " is the remainder value");
					 
	}
	/*integer to binary conversion*/
	public static int[] integerToBinary(int num)
	{
		int binaryNumber []= new int[8];
		int finalBinaryNumber []= {0,0,0,0,0,0,0,0};
		int count=7;
		int k= Math.abs(num);
		while(k>0)
		{
			binaryNumber[count]= k%2;
			k=k/2;
			count--;
			
		}
		for(int i=7; i>=0;i--)
		{
			finalBinaryNumber[i]= binaryNumber[i];
		}
		
		return finalBinaryNumber;
		
	}
	/* add operation*/
	public static int[] Add(int A[], int m1temp2[])
	{
		  int count=0;
		  int resultofsum [] = new int[8];
		for(int k=7; k>=0; k--)
		{
			resultofsum[k] = (A[k]+ m1temp2[k] + count)%2;
			
			count= (A[k]+ m1temp2[k] + count)/2;
		}
		return resultofsum;
		
	}
	/*function to get 2's complement */
	public static int[] complement( int p[])
	{
		int[] x1 =new int[8];
		for(int i= 7;i >=0;i--)
		{
			x1[i] = p[i];
		}
		int oc []={0,0,0,0,0,0,0,1};
		for (int i= 7; i>=0; i--)
		{
			if(x1[i]==0)
			{
				x1[i]=1;
			}
			else if (x1[i]==1)
			{
				x1[i]=0;
			}

		}
		
		int result[]= Add(x1,oc);
		
		
		return result;
	}
	/*Left shift operation*/
	 
	  public static void LeftShift(int a[],int q[])
	  { 
		 int b= q[0];
		  for (int i = 0; i < 7; i++)
		  {
			  a[i] = a[i+1];
			  q[i]=q[i+1];
		  }
		  a[7]=b;
}
}
