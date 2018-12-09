package package1;
import java.io.*;

public class StockHolding {
	float purchaseSharePrice;
	float currentSharePrice;
	int numberOfShares;
	String companyName;
	StockHolding(int a,float b,float c,String d)
	{
		numberOfShares=a;
		purchaseSharePrice=b;
		currentSharePrice=c;
		companyName=d;
		
	}
	float costInDollars()
	{
		return (purchaseSharePrice*numberOfShares);
	}
	float valueInDollars()
	{
		return currentSharePrice*numberOfShares;
	}
	
}
