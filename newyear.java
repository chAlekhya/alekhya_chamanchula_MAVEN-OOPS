package com.epam.gifts;
	import java.util.Arrays;
	import java.util.HashMap;
	import java.util.Scanner;


	public class newyear implements Gift 
	{
		String child_name;
		int tot_sweet,tot_choc; //tot_sweet ,tot_choc indicates the total sweets and chocolates in the gift pack
		static int totalweight; //total weight of all gift packs
		static sweet[] sweets;
		static chocos[] choc;
		static newyear gift[];
		
		static HashMap<String, Integer> a = new HashMap<>();
		static Scanner sc;
		
		newyear(int sw_no, int ch_no ,String name)
		{
			child_name=name;
			sweets = new sweet[sw_no];
			choc = new chocos[ch_no];
		}
		public void no_of_items()
		{
			System.out.println(sweets.length+choc.length+gift.length);
		}
		public static void addcount(String child_name, int quantity)
		{
			if(a.containsKey(child_name)) 
			{
				a.put(child_name,a.get(child_name)+quantity);
			}
			else
			{
				a.put(child_name,quantity);	
			}
			
		}
		
		public static void count_candies(int opt)
		{

			if(opt==1)
			{
				System.out.println("Enter the name of child whose candies you want to count: ");
				String name = sc.next();
				if(a.containsKey(name))
					System.out.println(name+"  has "+a.get(name)+" chocolates ");
				else
					System.out.println("No child by that name");
				
			}
			else if(opt==2)
			{
				System.out.println("Enter the value of n to find the number of gifts with no. of chocolates less than n:");
				int n = sc.nextInt();
				int count=0;
				for(int i=0;i<gift.length;i++)
				{
					if(gift[i].tot_choc<n)
						count++;
				}
				System.out.println(count);
			}
			else if(opt==3)
			{
				System.out.println("Enter the value of n to find the number of gifts with no. of chocolates more than n:");
				int n = sc.nextInt();
				int count=0;
				for(int i=0;i<gift.length;i++)
				{
					if(gift[i].tot_choc>n)
						count++;
				}
				System.out.println(count);
			}
		}
		
		
		public static void main(String args[])
		{
			 sc = new Scanner(System.in);
			 System.out.println("Enter the number of children for whom the new year gift has to be distributed: ");
			 int t = sc.nextInt();
			 gift = new newyear[t];
			 for(int h=0;h<t;h++)
			 {
				System.out.println("Enter the name of the child: ");
				String child_name = sc.next();
				
				System.out.println("Enter the no. of types of sweets and chocolates in the gift: ");
				int no_of_sweets_type = sc.nextInt();
				int no_of_chocolates_type = sc.nextInt();
				gift[h] = new newyear(no_of_sweets_type,no_of_chocolates_type,child_name);
				
				int sweet_weight,sweet_price,choc_weight,choc_price;	
				int sw_count=0;
				int choc_count=0;
				
				System.out.println("Enter the weight of sweets and price and quantity for all the sweets: ");
				for(int i=0;i<no_of_sweets_type;i++)
				{
				    sweet_weight= sc.nextInt();
				    sweet_price= sc.nextInt();
					int quantity =sc.nextInt();
					sw_count+=quantity;
					sweets[i]=new sweet(sweet_weight,sweet_price,quantity);
					gift[h].totalweight+=sweet_weight*quantity;
				}
				
				gift[h].tot_sweet=sw_count;
				
				if(no_of_chocolates_type!=0)
					System.out.println("Enter the weight of chocolates ,price and quantity and flavour for all the chocolates: ");
				else
					addcount(child_name,0);
				
				for(int i=0;i<no_of_chocolates_type;i++)
				{
					choc_weight = sc.nextInt();
				    choc_price = sc.nextInt();
					int quantity =sc.nextInt();
					String flavour=sc.next();
					choc_count+=quantity;
					choc[i]=new chocos(choc_weight,choc_price,quantity,flavour);
					gift[h].totalweight+=choc_weight*quantity;
					addcount(child_name,quantity);
					
				}
		
				gift[h].tot_choc=choc_count;
				
				if(no_of_chocolates_type!=0)
				{
					System.out.println("Select the basis for sorting chocolates\n 1.Price 2.Weight 3.Quantity");
					int op=sc.nextInt();
					Arrays.sort(choc,new sort_chocos(op));
					System.out.println("After sorting chocolates in a gift according to selected option");
					for(int j=0;j<no_of_chocolates_type;j++) 
					{
						System.out.print(choc[j]);
						System.out.println();
					}
				}
					System.out.println();
			 }
			 
			 
			System.out.println("Counting the candies in a gift");
			System.out.println("You have the following options:\n1.Count candies for a particular child.\n"
					+ "2.Count gifts with chocolates less than a value.\n3.Count gifts with chocolates less than a value");
			
			System.out.println("Enter the option: ");
			int opt = sc.nextInt();
			count_candies(opt);
			
			System.out.println("Total Weight of the new year gifts is: "+totalweight);
			sc.close();
			
		}
	}


