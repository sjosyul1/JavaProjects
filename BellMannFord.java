package Assignment3;

import java.util.*;
import java.util.Scanner;

public class BellMannFord
{
	// Declaring variables for tables 
	  static HashMap<String, Double> distancetable = new HashMap<>();
	 static HashMap<String, Integer> EdgeandWeight = new HashMap<>();
	// static HashMap<String, Double> predecessorTable = new HashMap<>();
	 static HashMap<String, String> predecessorTable1 = new HashMap<>();
	 static HashMap<String, Integer> HopCountTable = new HashMap<>();
  //declaring variable to print infinity
   static double infinite = Double.POSITIVE_INFINITY;
	public static void main(String[] args)
	{
		int NoOFVertices;
		int noOfEdges;
		// taking input number of vertices from user 
		Scanner sc= new Scanner (System.in)	;
		System.out.println("Please give the number of vertices:");
		NoOFVertices= sc.nextInt();
		System.out.println("Please give the number of Edges considering by-directions also");
		noOfEdges=sc.nextInt();
		//declaring vertices name and taking input from user with starting vertex as source node
		String nameOFVertices []=new String[NoOFVertices];
		System.out.println("Please give the name of vertices beginning with source vertex");
		for(int i=0;i<nameOFVertices.length;i++)
		{
			nameOFVertices[i]=sc.next();
		}
		// taking input from user in a--b format so that it is readable and easily understandable and also considering by-directions
		System.out.println("Please give the name of edge(use a--b format) and their respective weight considering the by-directions(ex: u--v and v--u)");
		  
		 for(int i=0;i<noOfEdges;i++){

	           String edge=sc.next();
		      int weight=sc.nextInt();
	           EdgeandWeight.put(edge, weight);
		 }
	           // printing the values of edge weight considering the bi-directions 
	           Set<String> set= EdgeandWeight.keySet();
	           System.out.println("----------------");
	           System.out.println("Edge"+ "  |  "+ "Weights");
	           System.out.println("----------------");
	           for(String key: set)
	           {
	        	   Integer value= EdgeandWeight.get(key);
	        	   System.out.println(key +"  |  "+ value);
	           }    
		// initial table of vertices and respective distance from the source(taking infinity for all other vertices except source
	           distancetable.put(nameOFVertices[0], 0.0);
	           for(int i=1; i<nameOFVertices.length;i++)
	           {
	        	   distancetable.put(nameOFVertices[i],infinite);  
	           }
	           
	        // printing the values 
		         
	           Set<String> set1= distancetable.keySet();
	           System.out.println("-------------------------------------");
	           System.out.println("vertex"+ "|"+ "distance from source");
	           System.out.println("-------------------------------------");
	           for(String key: set1)
	           {
	        	   Double value= distancetable.get(key);
	        	   System.out.println(key +"  |  "+ value);
	           }
	           
	           // checking predecessor table
	           Set<String> set3= distancetable.keySet();
	           for (String st : set3) {
	        	   predecessorTable1.put(st, " ");
			}
	           // iterating through loops for n-1 time where n is no of vertices
	           Set<String> set2= EdgeandWeight.keySet();
	           //int weight []= new int[EdgeandWeight.size()];
	           for(int i=0; i<distancetable.size()-1;i++)
	           {
	        	   for(String key1: set2)
		           {
		        	   Integer Weight=EdgeandWeight.get(key1);
		        	 char ext1= key1.charAt(0);
		        	 char ext2= key1.charAt(3);
		        	 String extract1=Character.toString(ext1);
		        	 String extract2=Character.toString(ext2);
		        	//System.out.println(ext1 + " and "+ext2);
		        	 Double startpoint= distancetable.get(extract1);
		        	   Double endpoint= distancetable.get(extract2);
		        	 //  System.out.println("start point is : "+ startpoint+" end point is :"+ endpoint+" weight is: "+Weight);;
		        	   relaxEdge(startpoint,endpoint,Weight,extract1, extract2);
		        	  
			           }
	        	   System.out.println("*********************************");
	        	   // Printing routing table after each iteration
	        	   System.out.println("after iteration :" +i );
	        	 System.out.println("routing table for each node :");
	        	   System.out.println("------------------------------------------");
		           System.out.println("vertex"+ "|"+ "distance from source");
		           System.out.println("------------------------------------------");
		           for(String key: set1)
		           {
		        	   Double value= distancetable.get(key);
		        	   System.out.println(key +"    |    "+ value);
			           
		           }
		           //printing predecessor table after each iteration
		         System.out.println("predecessor table after iteration:" +i);
	        	   System.out.println("-------------------------------------------");
		           System.out.println("vertex"+ "|"+ "predecessor");
		           System.out.println("-------------------------------------------");
		           for(String key: set1)
		           {
		        	  String value= predecessorTable1.get(key);
		        	   System.out.println(key +"  |  "+ value);
			           
		           }
	           }
	           // calculating the hop count and printing it 
	           // hop counts 
	           //Integer hopcount=-1;
	           Set<String> set4= predecessorTable1.keySet();
	           for(String key: set4)
	           {
	        	   //System.out.println("Key : " + key);
		if (predecessorTable1.get(key)== " ")
	           {
	        	   HopCountTable.put(key, 0);
	           }
	           
		else 
		{
			String t = key;
			Integer hopcount=-1;
	        	   while(predecessorTable1.get(t)!=" ")
	        	   {
	        		   t= predecessorTable1.get(t);
	        		   hopcount++;
	        	   }  
	        		   HopCountTable.put(key, hopcount);
		}
	           }
	           //printing hop count for each node
	           Set<String> set5= HopCountTable.keySet();
	           System.out.println("HopCount table table is :" );
        	   System.out.println("---------------------------");
	           System.out.println("vertex"+ "|"+ "HopCount");
	           System.out.println("---------------------------");
	           for(String key: set5)
	           {
	        	  Integer value= HopCountTable.get(key);
	        	   System.out.println(key +"     |     "+ value);  
	           }
	           }
	// method to implement relax operation
	public static void relaxEdge(Double st, Double en, int wt,String key1, String key2)
	{
		if(en> (st+wt))
		{
			en= st+wt;
			distancetable.put(key2, en);
		//predecessorTable.put(key2, st);
		predecessorTable1.put(key2, key1);
		}	
	}
	}
		 



