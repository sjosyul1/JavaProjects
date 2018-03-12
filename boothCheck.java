package Assignment3;

import java.util.Scanner;

public class boothCheck 
{
	public static void main(String arg[])
	{
		
	/* declaring input arrays */	
	  int m1[]= new int[8];
		 int Q[]= new int[8];
		 
		 int num1;
		 int num2;
		 
		 /* Taking input through keyboard */
	Scanner sc= new Scanner (System.in)	;
	System.out.println("Please give the value of multiplicand");
	/* accepting decimal inputs */
	 num1= sc.nextInt();
	
	System.out.println("Please give the multiplier");
	
	 num2= sc.nextInt();
	 
	 /* converting decimal to binary */
	  m1= integerToBinary(num1);
	  Q= integerToBinary(num2);
	  
	  /* if given number is negative the finding the 2's complement*/
	  if(num1<0)
	  {
		  m1= complement(m1);
	  }
	  if(num2<0)
	  {
		  Q= complement(Q);
	  }
	
	/* Declaring and initializing accumulator and Q registers */
	int A[]={0,0,0,0,0,0,0,0};

	 int Q1=0;
 
	 /* declaring and initializing counter */
	int count =0;
	while(count<=7)
	{
		/* operation for 0,1 cycle*/	
		if(Q[7]==0 && Q1==1)
		{
			
			A = Add(A,m1);
			Q1 = Q[7];
			rightShift(A,Q);
			
			/* printing all four register after operation 0,1 (A,Q,Q1,M) */
			
			System.out.println("\n \n ");		
System.out.println("values of each registers after 0,1 operation");
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
System.out.println("value of Q1:");

	System.out.print(Q1);

System.out.println(" ");
System.out.println("value of m1:");
for(int i=0; i<8; i++)
{
	System.out.print(m1[i]);
}
			
		}
		/* operation for cycle 1,0 */
		
else if(Q[7]==1 && Q1==0)
		{
			
			int complem2s [] = new int[8];
			complem2s = complement(m1);
			
			
			A= Add(A,complem2s);
			
			Q1 = Q[7];
			rightShift(A,Q);
			
			/* printing all four register after operation 1,0 (A,Q,Q1,M) */	
			
System.out.println(" \n \n");	
System.out.println("values of each registers after 1,0 operation");
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
System.out.println(" ");
System.out.println("value of Q1:");

	System.out.print(Q1);

System.out.println(" ");
System.out.println("value of m1:");
for(int i=0; i<8; i++)
{
	System.out.print(m1[i]);
}
		
			
		}
		/* operation for cycle 0,0 */
else if(Q[7]==0 && Q1==0)
		{
			Q1 = Q[7];
			rightShift(A,Q);
			
			/* printing all four register after operation 0,0 (A,Q,Q1,M) */
			
			System.out.println("\n \n ");			
System.out.println("values of each registers after 0,0 operation");
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
System.out.println(" ");
System.out.println("value of Q1:");


	System.out.print(Q1);

System.out.println(" ");
System.out.println("value of m1:");
for(int i=0; i<8; i++)
{
	System.out.print(m1[i]);
}
				
		}
		/* operation for cycle 1,1 */
else if(Q[7]==1 && Q1==1)
		{
			Q1 = Q[7];
			rightShift(A,Q);
			
			/* printing all four register after operation 1,1 (A,Q,Q1,M) */
			
			System.out.println(" \n \n ");		
System.out.println("values of each registers after 1,1 operation");
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
System.out.println(" ");
System.out.println("value of Q1:");


	System.out.print(Q1);

System.out.println(" ");
System.out.println("value of m1:");
for(int i=0; i<8; i++)
{
	System.out.print(m1[i]);
}
	
		}
		
		count++;
	}
	System.out.println("\n \n ");
	
	/* printing the final output */
	System.out.println("The binary product value is :");
int binaryoutput []= new int[16];
binaryoutput = display(A,Q);
String fa = "";
for(int i=0; i<16; i++)
{
	fa += binaryoutput[i];
}


System.out.println("\n");
System.out.println("decimal value of product is:");
System.out.println((short)Integer.parseInt(fa,2));




sc.close();
}
	
	/* function to right shift */
	public static  void rightShift (int A[], int Q[])
	{
		
		 for(int i=7; i>=1; i--)
		 {
			 Q[i]= Q[i-1];
			 
		 }
		 Q[0]= A[7];
		 if(A[0]==0)
			{
			A[0]=0;
			}
			else if (A[0]==1)
				A[0]=1;
		 for(int j=7; j>=1; j--)
		 {
			 A[j]= A[j-1];
		 }
		
	}
	/* function to Add */
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
	/* function to display final output */
	public static int[] display( int A[], int Q[])
	{
		int output[]= new int[16];
		int count=0;
		for (int z=0; z<=7 ; z++)
		{
			output[count]= A[z];
			count++;
		}
		for (int z=0; z<=7 ; z++)
		{
			output[count]= Q[z];
			count++;
		}
		for(int i=0; i<=15; i++)
		{
		System.out.print( output[i] );
		}
		return output;
		
	}
	
	/* function to convert integer to binary */
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
	


}
