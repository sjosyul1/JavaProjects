package Assignment3;

import java.util.Scanner;

public class boothAlgorith 
{
	
	public static void main(String arg[])
	{
		
		
	  int m1[]= new int[8];
		 int Q[]= new int[8];

	Scanner sc= new Scanner (System.in)	;
	System.out.println("Please give the value of multiplicand");
	for(int i=0;i<=7;i++)
	{
	 m1[i]= sc.nextInt();
	}
	System.out.println("Please give the multiplier");
	for(int j=0;j<=7;j++)
	{
	 Q[j]= sc.nextInt();
	}
	
	System.out.println("check 0");
	int A[]={0,0,0,0,0,0,0,0};

	 int Q1=0;
	 int temp []= new int[8];
	System.out.println("check 1");
	
	
	System.out.println(" ");
	for(int i=0; i<8; i++)
	{
		temp[i]= m1[i];
	}
		 

	int count =0;
	while(count<=7)
	{
		System.out.println("check 2");
		System.out.println(" ");
		if(Q[7]==0 && Q1==1)
		{
			System.out.println("check 3");
			for(int i=0; i<8; i++)
			{
				System.out.print(A[i]);
			}
			System.out.println(" ");
			System.out.println("cheking value of  M before add");
			System.out.println(" ");
			for(int i=0; i<8; i++)
			{
				System.out.print(m1[i]);
			}
			System.out.println(" ");
			A = Add(A,m1);
			for(int i=0; i<8; i++)
			{
				System.out.print(A[i]);
			}
			Q1 = Q[7];
			
			
			rightShift(A,Q);
			
			for(int i=0; i<8; i++)
			{
				System.out.print(Q[i]);
			}
			
			System.out.println("value of A: \t \t ");
			for(int i=0; i<8; i++)
			{
				System.out.print(A[i]);
			}
			System.out.println(" ");
			System.out.println(Q1);
			System.out.println("cheking value of  M ");
			System.out.println(" ");
			for(int i=0; i<8; i++)
			{
				System.out.print(m1[i]);
			}
			System.out.println("check 4");
			
			
			
			
		}
		else if(Q[7]==1 && Q1==0)
		{
			System.out.println("check 5");
			int complem2s [] = new int[8];
			complem2s = complement(m1);
			System.out.println();
			for(int i=0; i<8; i++)
			{
				System.out.print(A[i]);
			}
			System.out.println(" ");
			for(int i=0; i<8; i++)
			{
				System.out.print(m1[i]);
			}
			System.out.println(" ");
			
			System.out.println("cheking value of  COMPLEM2S ");
			System.out.println(" ");
			for(int i=0; i<8; i++)
			{
				System.out.print(complem2s[i]);
			}
			
			A= Add(A,complem2s);
			System.out.println(" ");
			for(int i=0; i<8; i++)
			{
				System.out.print(A[i]);
			}
			System.out.println(" ");
			for(int i=0; i<8; i++)
			{
				System.out.print(Q[i]);
			}
			System.out.println("cheking value of  M ");
			System.out.println(" ");
			for(int i=0; i<8; i++)
			{
				System.out.print(m1[i]);
			}
			Q1 = Q[7];
			rightShift(A,Q);
			
			for(int i=0; i<8; i++)
			{
				System.out.print(Q[i]);
			}
			System.out.println(" ");
			for(int i=0; i<8; i++)
			{
				System.out.print(A[i]);
			}
			System.out.println(" ");
			System.out.println(Q1);
			
			System.out.println("cheking value of  M ");
			System.out.println(" ");
			for(int i=0; i<8; i++)
			{
				System.out.print(m1[i]);
			}
			
			count ++;
			
			
		}
		else if(Q[7]==0 && Q1==0)
		{
			Q1 = Q[7];
			rightShift(A,Q);
			
			
			for(int i=0; i<8; i++)
			{
				System.out.print(Q[i]);
			}
			System.out.println("");
			for(int i=0; i<8; i++)
			{
				System.out.print(A[i]);
			}
			System.out.println(" ");
			System.out.println(Q1);
			
			System.out.println("cheking value of  M ");
			System.out.println(" ");
			for(int i=0; i<8; i++)
			{
				System.out.print(m1[i]);
			}
			
			count ++;
		}
		else if(Q[7]==1 && Q1==1)
		{
			Q1 = Q[7];
			rightShift(A,Q);
			
			for(int i=0; i<8; i++)
			{
				System.out.print(Q[i]);
			}
			System.out.println("");
			for(int i=0; i<8; i++)
			{
				System.out.print(A[i]);
			}
			System.out.println(" ");
			System.out.println(Q1);
			
			System.out.println("cheking value of  M ");
			System.out.println(" ");
			for(int i=0; i<8; i++)
			{
				System.out.print(m1[i]);
			}
			
			count ++;
		}
	}
	System.out.println(" ");
display(A,Q);
}
	public static  void rightShift (int A[], int Q[])
	{
		System.out.println(" ");
		System.out.println("check 7");
		
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
		
		System.out.println("check 8");
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
	public static int[] complement( int x1[])
	{
		System.out.println(" ");
		for(int i=0; i<8; i++)
		{
			System.out.print(x1[i]);
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
		
		
		
		//System.out.println("m2array[]");
		return result;
	}
	public static void display( int A[], int Q[])
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
		}
		for(int i=0; i<=15; i++)
		{
		System.out.print( output[i] );
		}
	}
	
}