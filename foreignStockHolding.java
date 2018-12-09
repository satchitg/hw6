package package1;

public class foreignStockHolding extends StockHolding {
	float conversionRate;
	float purchaseSharePrice;
	float currentSharePrice;
	int numberOfShares;
	String companyName;
	foreignStockHolding(int a,float b,float c,String d,float e)
	{
		super(a,b,c,d);
		conversionRate=e;
		
	}
	float costInDollars()
	{
		return (purchaseSharePrice*numberOfShares*conversionRate);
	}
	float valueInDollars()
	{
		return currentSharePrice*numberOfShares*conversionRate;
	}

}
