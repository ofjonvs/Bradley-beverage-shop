package abc;

public class Alcohol extends Beverage{
	
	private boolean weekend;
	private final double WEEKEND_PRICE = 0.6;
	
	public Alcohol(String n, SIZE s, boolean w) {
		super(n, TYPE.ALCOHOL, s);
		weekend = w;
	}
	
	public boolean getWeekend() {
		return weekend;
	}
	
	public void setWeekend(boolean w) {
		weekend = w;
	}
	
	public double getWeekendPrice() {
		return WEEKEND_PRICE;
	}

	public String toString() {
		
		String str = "" + getBevName() + ", " + getSize();
		double price = 0.0;
		boolean bool = weekend;
		if(bool == true)
			str += ", weekend fee";
		price = calcPrice();
		str += ", price: $" + price;
		return str;
	}
	
	public boolean equals (Alcohol a) {
		
		boolean bool = super.equals(a);
		if(bool == true) {
			if(weekend == a.getWeekend())
				return bool;
		}
		return false;	
	}
	
	public double calcPrice() {
		double price = super.getBasePrice();
		boolean bool = weekend;
		
		if(super.getSize() == SIZE.MEDIUM)
			price += super.getSizeUp();
		else if (super.getSize() == SIZE.LARGE)
			price += 2 * super.getSizeUp();
		
		if (bool == true)
			price += WEEKEND_PRICE;
		
		return price;
	}
	
}
