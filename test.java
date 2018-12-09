package package1;
import java.util.*;

//implementation for inbuilt java.util.comparator interface for sorting objects
class SortByName implements Comparator<StockHolding>{									//Sort by name in ascending Order

	public int compare(StockHolding a, StockHolding b) {
		return a.companyName.compareTo(b.companyName);
	}
}

class SortByValue implements Comparator<StockHolding> {									//Sort by Value in Ascending Order
	
	public int compare(StockHolding a, StockHolding b){
		return (int)(a.valueInDollars() - b.valueInDollars());
	}
}

class SortByProfit implements Comparator<StockHolding> {								//Sort by Profit in ascending Order 
	
	public int compare(StockHolding a, StockHolding b){
		return (int)((a.currentSharePrice - a.purchaseSharePrice) - (b.currentSharePrice - b.purchaseSharePrice));
	}
}

public class test {

	//method to display Stocks
	static void displayBySort(ArrayList<StockHolding> stocks, int size){
		
		if( size != stocks.size() )											//display a particular Stock
		{
			System.out.println(stocks.get(size).companyName);
			System.out.println(stocks.get(size).purchaseSharePrice);
			System.out.println(stocks.get(size).currentSharePrice);
			System.out.println(stocks.get(size).numberOfShares);
			System.out.println("Cost In Dollars : "+ stocks.get(size).costInDollars());
			System.out.println("Value In Dollars : "+ stocks.get(size).valueInDollars());
			System.out.println();
		}
		else															   //display all Stocks
		{
			for( int i = 0; i < stocks.size(); i++)
			{
				System.out.print((i+1) + " Stock: ");
				System.out.println(stocks.get(i).companyName);
				System.out.println(stocks.get(i).purchaseSharePrice);
				System.out.println(stocks.get(i).currentSharePrice);
				System.out.println(stocks.get(i).numberOfShares);
				System.out.println("Cost In Dollars : "+ stocks.get(i).costInDollars());
				System.out.println("Value In Dollars : "+ stocks.get(i).valueInDollars());
				System.out.println();
			}
		}
	}

	public static void main(String[] args) {
		
		//declaring instances of StockHolding Objects as Dynamic Array
		ArrayList<StockHolding> stocks = new ArrayList<StockHolding>();
		
		Scanner input = new Scanner(System.in);
		System.out.print("Enter Number of Stocks(maximum 8) : ");
		int num = input.nextInt();
		
		//User input of Stocks
		for( int i = 0; i < num; i++)
		{
			System.out.println("1. StockHolding\n2. ForeignStockHolding");
			int choice = input.nextInt();
			input.nextLine();
			if(choice > 2 || choice < 1){
				System.out.println("Invalid Choice !");
				i--;
				continue;
			}
			System.out.print("Enter companyName : ");
			String cmpy = input.nextLine();
			System.out.print("Enter purchaseSharePrice : ");
			float psp = input.nextFloat();
			System.out.print("Enter currentSharePrice  : ");
			float csp = input.nextFloat();
			System.out.print("Enter numberOfShares : ");
			int nos =input.nextInt();
			if(choice == 1)															//StockHolding Type object to be Stored in Array
				stocks.add(new StockHolding( cmpy, psp, csp, nos));
			else{
				System.out.print("Enter conversionRate : ");
				float cr = input.nextFloat();
				stocks.add(new ForeignStockHolding( cmpy, psp, csp, nos, cr));		//ForeignStockHolding Type object to be Stored in Array
			}
		}
		
		//Menu Creation
		boolean flag = true;
		while(flag)
		{
			System.out.println("1) Display stock information with the lowest value");
			System.out.println("2) Display stock with the highest value");
			System.out.println("3) Display the most profitable stock");
			System.out.println("4) Display the least profitable stock");
			System.out.println("5) List all stocks sorted by company name (A-Z)");
			System.out.println("6) List all stocks sorted from the lowest value to the highest value");
			System.out.println("7) Exit");
			
			int choice = input.nextInt();
			//switch for Particular Case 1 - 7
			switch(choice)
			{
				case 1:
					System.out.println("Displaying stock information with the lowest value");
					Collections.sort(stocks, new SortByValue());				
					displayBySort(stocks, 0);
					break;
				case 2:
					System.out.println("Displaying stock with the highest value");
					Collections.sort(stocks, new SortByValue());
					displayBySort(stocks, stocks.size()-1);
					break;
				case 3:
					System.out.println("Displaying the most profitable stock");
					Collections.sort(stocks, new SortByProfit());
					displayBySort(stocks, stocks.size()-1);
					break;
				case 4:
					System.out.println("Displaying the least profitable stock");
					Collections.sort(stocks, new SortByProfit());
					displayBySort(stocks, 0);
					break;
				case 5:
					System.out.println("\nListing all stocks sorted by company name (A-Z)");
					Collections.sort(stocks,new SortByName());
					displayBySort(stocks,stocks.size());
					break;
				case 6:
					System.out.println("\nListing all stocks sorted from the lowest value to the highest value");
					Collections.sort(stocks,new SortByValue());
					displayBySort(stocks,stocks.size());
					break;
				case 7: 
					System.exit(0);											//Termination of Program		
				default:
					System.out.println("Invalid Choice !");
			}
		}
		
		input.close();
	}


}
