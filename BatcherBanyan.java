package Assignment3;
import java.util.Arrays;
import java.util.Random;
public class BatcherBanyan 
{
	public static void main(String[] args)
	{
		int binary []= new int[3];// this array holds the binary number of inputs 
		int path;// this variable is used to print the path
		Random random= new Random();// creating random object
		int randomNum []= new int[8];
		boolean flag= false;
		// generating random numbers for the inputs
		for(int i=0; i<randomNum.length; i++)
		{
			randomNum[i]= Math.abs(random.nextInt()%8);
			for(int j=0; j<=(i-1); j++)
			{
				if(randomNum[i]== randomNum[j])
				{
					flag=true;
					i--;
				}
			}
		}
		// printing random numbers
		System.out.println("random number are");
		for(int i=0; i<randomNum.length; i++)
		{
			System.out.print(randomNum[i]+" ");
		}
		// arranging in ascending order
		Arrays.sort(randomNum);
		System.out.println("\n sorted array of random numbers");
		for(int i=0; i<randomNum.length; i++)
		{
			System.out.print(randomNum[i]+" ");
		}
		System.out.println("\n");
		/*creating two dimensional array and hardcoding some values
		 this values can be used by path variable to print the path 
		 whenever input path touches this point, its values is taken in to 
		path variable */
		int a1[][]= {{1,9},{2,10}}, a2[][]= {{3,11},{4,12}}, a3[][]= {{5,13},{6,14}},a4[][]= {{7,15},{8,16}};
		int b1[][]= {{17,25},{18,26}};
		int b2[][]= {{19,27},{20,28}};
		int b3[][]= {{21,29},{22,30}};
		int b4[][]= {{23,31},{24,32}};
		int c1[][]= {{33,41},{34,42}};
		int c2[][]= {{35,43},{36,44}};
		int c3[][]= {{37,45},{38,46}};
		int c4[][]= {{39,47},{40,48}};
		// iterating the loop and printing the paths 
		for(int i=0; i<randomNum.length;i++)
		{
			if(randomNum[i]==0)
			{
				// calling integer to binary function and storing that in binary array
				binary=integerToBinary(randomNum[i]);
				System.out.println("\n binary value of "+randomNum[i] +" is:");
				for(int j=0;j<binary.length;j++)
				{
					System.out.print(binary[i]);
				}
				System.out.println("\n");
				path=a1[0][0];
				System.out.print("\n path of 0 is \n"+path+" -->>");
				if(binary[0]==0)
				{
					path=a1[0][1];
					System.out.print(path+" -->>");
				}
				if(binary[0]==1)
				{
					path=a1[1][1];
					System.out.print(path+" -->>");
				}
				//checking for 0 or 1 and assigning path in b1
				path=b1[0][0];
				System.out.print(path+" -->>");
				if(binary[1]==0)
				{
					path=b1[0][1];
					System.out.print(path+" -->>");
				}
				if(binary[1]==1)
				{
					path=b1[1][1];
					System.out.print(path+" -->>");
				}
				path=c1[0][0];
				System.out.print(path+" -->>");
				if(binary[2]==0)
				{
					path=c1[0][1];
					System.out.print(path+" -->>");
				}
				if(binary[1]==1)
				{
					path=c1[1][1];
					System.out.print(path+" -->>");
				}
				System.out.print("value at port 41 is 0 ");	
			}
			if(randomNum[i]==1)
			{
				binary=integerToBinary(randomNum[i]);
				System.out.println("\n\n binary value of "+randomNum[i] +" is:");
				for(int j=0;j<binary.length;j++)
				{
					System.out.print(binary[j]);
				}
				System.out.println("\n");
				path=a2[0][0];
				System.out.print("\n path of 1 is \n"+path+" -->>");
				if(binary[0]==0)
				{
					path=a2[0][1];
					System.out.print(path+" -->>");
				}
				if(binary[0]==1)
				{
					path=a2[1][1];
					System.out.print(path+" -->>");
				}
				//checking for 0 or 1 and assigning path in b1
				path=b3[0][0];
				System.out.print(path+" -->>");
				if(binary[1]==0)
				{
					path=b3[0][1];
					System.out.print(path+" -->>");
				}
				if(binary[1]==1)
				{
					path=b3[1][1];
					System.out.print(path+" -->>");
				}
				path=c1[1][0];
				System.out.print(path+" -->>");
				if(binary[2]==0)
				{
					path=c1[0][1];
					System.out.print(path+" -->>");
				}
				if(binary[2]==1)
				{
					path=c1[1][1];
					System.out.print(path+" -->>");
				}
				System.out.print("value at port 42 is 1");
		}
			if(randomNum[i]==2)
			{
				binary=integerToBinary(randomNum[i]);
				System.out.println("\n binary value of "+randomNum[i] +" is:");
				for(int j=0;j<binary.length;j++)
				{
					System.out.print(binary[j]);
				}
				System.out.println("\n");
				path=a3[0][0];
				System.out.print("\n path of 2 is \n"+path+" -->>");
				if(binary[0]==0)
				{
					path=a3[0][1];
					System.out.print(path+" -->>");
				}
				if(binary[0]==1)
				{
					path=a3[1][1];
					System.out.print(path+" -->>");
				}
				//checking for 0 or 1 and assigning path in b1
				path=b1[1][0];
				System.out.print(path+" -->>");
				if(binary[1]==0)
				{
					path=b1[0][1];
					System.out.print(path+" -->>");
				}
				if(binary[1]==1)
				{
					path=b1[1][1];
					System.out.print(path+" -->>");
				}
				path=c2[0][0];
				System.out.print(path+" -->>");
				if(binary[2]==0)
				{
					path=c2[0][1];
					System.out.print(path+" -->>");
				}
				if(binary[2]==1)
				{
					path=c2[1][1];
					System.out.print(path+" -->>");
				}
				System.out.print("value at port 43 is 2");
		}
			if(randomNum[i]==3)
			{
				binary=integerToBinary(randomNum[i]);
				System.out.println("\n binary value of "+randomNum[i] +" is:");
				for(int j=0;j<binary.length;j++)
				{
					System.out.print(binary[j]);
				}
				System.out.println("\n");
				path=a4[0][0];
				System.out.print("\n path of 3 is \n"+path+" -->>");
				if(binary[0]==0)
				{
					path=a4[0][1];
					System.out.print(path+" -->>");
				}
				if(binary[0]==1)
				{
					path=a4[1][1];
					System.out.print(path+" -->>");
				}
				//checking for 0 or 1 and assigning path in b1
				path=b2[1][0];
				System.out.print(path+" -->>");
				if(binary[1]==0)
				{
					path=b2[0][1];
					System.out.print(path+" -->>");
				}
				if(binary[1]==1)
				{
					path=b2[1][1];
					System.out.print(path+" -->>");
				}
				path=c2[1][0];
				System.out.print(path+" -->>");
				if(binary[2]==0)
				{
					path=c2[0][1];
					System.out.print(path+" -->>");
				}
				if(binary[2]==1)
				{
					path=c2[1][1];
					System.out.print(path+" -->>");
				}
				System.out.print("value at port 44 is 3");
		}
			if(randomNum[i]==4)
			{
				binary=integerToBinary(randomNum[i]);
				System.out.println("\n binary value of "+randomNum[i] +" is:");
				for(int j=0;j<binary.length;j++)
				{
					System.out.print(binary[j]);
				}
				System.out.println("\n");
				path=a1[1][0];
				System.out.print("\n path of 4 is \n"+path+" -->>");
				if(binary[0]==0)
				{
					path=a1[0][1];
					System.out.print(path+" -->>");
				}
				if(binary[0]==1)
				{
					path=a1[1][1];
					System.out.print(path+" -->>");
				}
				//checking for 0 or 1 and assigning path in b1
				path=b3[0][0];
				System.out.print(path+" -->>");
				if(binary[1]==0)
				{
					path=b3[0][1];
					System.out.print(path+" -->>");
				}
				if(binary[1]==1)
				{
					path=b3[1][1];
					System.out.print(path+" -->>");
				}
				path=c3[0][0];
				System.out.print(path+" -->>");
				if(binary[2]==0)
				{
					path=c3[0][1];
					System.out.print(path+" -->>");
				}
				if(binary[2]==1)
				{
					path=c3[1][1];
					System.out.print(path+" -->>");
				}
				System.out.print("value at port 45 is 4");
		}
			if(randomNum[i]==5)
			{
				binary=integerToBinary(randomNum[i]);
				System.out.println("\n binary value of "+randomNum[i] +" is:");
				for(int j=0;j<binary.length;j++)
				{
					System.out.print(binary[j]);
				}
				System.out.println("\n");
				path=a2[1][0];
				System.out.print("\n path of 5 is \n"+path+" -->>");
				if(binary[0]==0)
				{
					path=a2[0][1];
					System.out.print(path+" -->>");
				}
				if(binary[0]==1)
				{
					path=a2[1][1];
					System.out.print(path+" -->>");
				}
				//checking for 0 or 1 and assigning path in b1
				path=b4[0][0];
				System.out.print(path+" -->>");
				if(binary[1]==0)
				{
					path=b4[0][1];
					System.out.print(path+" -->>");
				}
				if(binary[1]==1)
				{
					path=b4[1][1];
					System.out.print(path+" -->>");
				}
				path=c3[1][0];
				System.out.print(path+" -->>");
				if(binary[2]==0)
				{
					path=c3[0][1];
					System.out.print(path+" -->>");
				}
				if(binary[2]==1)
				{
					path=c3[1][1];
					System.out.print(path+" -->>");
				}
				System.out.print("value at port 46 is 5");
		}
			if(randomNum[i]==6)
			{
				binary=integerToBinary(randomNum[i]);
				System.out.println("\n binary value of "+randomNum[i] +" is:");
				for(int j=0;j<binary.length;j++)
				{
					System.out.print(binary[j]);
				}
				System.out.println("\n");
				path=a3[1][0];
				System.out.print("\n path of 6 is \n"+path+" -->>");
				if(binary[0]==0)
				{
					path=a3[0][1];
					System.out.print(path+" -->>");
				}
				if(binary[0]==1)
				{
					path=a3[1][1];
					System.out.print(path+" -->>");
				}
				//checking for 0 or 1 and assigning path in b1
				path=b3[1][0];
				System.out.print(path+" -->>");
				if(binary[1]==0)
				{
					path=b3[0][1];
					System.out.print(path+" -->>");
				}
				if(binary[1]==1)
				{
					path=b3[1][1];
					System.out.print(path+" -->>");
				}
				path=c4[0][0];
				System.out.print(path+" -->>");
				if(binary[2]==0)
				{
					path=c4[0][1];
					System.out.print(path+" -->>");
				}
				if(binary[2]==1)
				{
					path=c4[1][1];
					System.out.print(path+" -->>");
				}
				System.out.print("value at port 47 is 6");
		}
			if(randomNum[i]==7)
			{
				binary=integerToBinary(randomNum[i]);
				System.out.println("\n binary value of "+randomNum[i] +" is:");
				for(int j=0;j<binary.length;j++)
				{
					System.out.print(binary[j]);
				}
				System.out.println("\n");
				path=a4[1][0];
				System.out.print("\n path of 7 is \n"+path+" -->>");
				if(binary[0]==0)
				{
					path=a4[0][1];
					System.out.print(path+" -->>");
				}
				if(binary[0]==1)
				{
					path=a4[1][1];
					System.out.print(path+" -->>");
				}
				//checking for 0 or 1 and assigning path in b1
				path=b4[1][0];
				System.out.print(path+" -->>");
				if(binary[1]==0)
				{
					path=b4[0][1];
					System.out.print(path+" -->>");
				}
				if(binary[1]==1)
				{
					path=b4[1][1];
					System.out.print(path+" -->>");
				}
				path=c4[1][0];
				System.out.print(path+" -->>");
				if(binary[2]==0)
				{
					path=c4[0][1];
					System.out.print(path+" -->>");
				}
				if(binary[2]==1)
				{
					path=c4[1][1];
					System.out.print(path+" -->>");
				}
				System.out.print("value at port 48 is 7");
		}}}
	// function to convert integer to binary numbers
	public static int[] integerToBinary(int num)
	{
		int binaryNumber []= new int[3];
		int finalBinaryNumber []= {0,0,0};
		int count=2;
		int k= Math.abs(num);
		while(k>0)
		{
			binaryNumber[count]= k%2;
			k=k/2;
			count--;
			
		}
		for(int i=2; i>=0;i--)
		{
			finalBinaryNumber[i]= binaryNumber[i];
		}
		return finalBinaryNumber;
	}}