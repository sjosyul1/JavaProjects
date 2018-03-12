package Assignment3;

import java.util.Scanner;

public class array 
{
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
						  System.out.println("Q is:");
						  for(int i=0; i<8; i++)
						  {
						  System.out.print(Q[i]);
						  }
						  System.out.println("\n \n");
						  System.out.println("Q's 2 complement is:");
						  for(int i=0; i<8; i++)
						  {
						  System.out.print(M[i]);
						  }
						  System.out.println("\n \n");
						 
						 /* declaring and initializing counter */
							int count =0;
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
	

	/* printing all four register after each operation (A,Q,) */

	System.out.println("\n \n ");		
	System.out.println("values of each registers after operation"+ count);
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
			
			System.out.println("\n output in decimal format");
			int x= num1%num2;
			int y= num1/num2;
			System.out.println(x+"R"+y + " where "+x+ " is the remainder and " +y+ " is the integer value");
						 
		}
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
		 /* public static int BinaryToDecimalConversion(int binaryNumber)
		  {
			  
			    int decimal = 0;
			    int c= 0;
			    while(true){
			      if(binaryNumber == 0){
			        break;
			      } else {
			          int temp = binaryNumber%10;
			          decimal += temp*Math.pow(2, c);
			          binaryNumber = binaryNumber/10;
			          c++;
			       }
			    }
			    return decimal;
			  }*/
	}


