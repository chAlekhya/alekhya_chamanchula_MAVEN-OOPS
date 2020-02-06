package com.epam.gifts;

	import java.util.Comparator;
	public class sort_chocos implements Comparator<chocos>
	{
		int op;
		sort_chocos(int n)
		{
			this.op=n;
		}
		public int compare(chocos a,chocos b)
		{
			switch(op) 
			{
				case 1:return a.price-b.price;
				case 2:return a.weight-b.weight;
				case 3:return a.no-b.no;
			}
			return 0;
		}
	}


