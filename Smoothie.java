package abc;

public class Smoothie extends Beverage{
	
	private int fruit;
	private final double FRUIT_PRICE = 0.5;
	private boolean protein;
	private final double PROTEIN_PRICE = 1.5;
	
	public Smoothie (String n, SIZE s, int f, boolean p) {
		super(n, TYPE.SMOOTHIE, s);
		fruit = f;
		protein = p;
	}
	
	public int getNumOfFruits() {
		return fruit;
	}
	
	public void setNumOfFruits(int f) {
		fruit = f;
	}
	
	public boolean getAddProtien() {
		return protein;
	}
	
	public void setAddProtein(boolean p) {
		protein = p;
	}
	
	public double getFruitPrice() {
		return FRUIT_PRICE;
	}
	
	public double getProteinPrice() {
		return PROTEIN_PRICE;
	}
	
	public String toString() {
		boolean bool = protein;
		double price = 0.0;
		String str = "" + getBevName() + ", " + getSize() + ", fruits: " + fruit;
		if (bool == true) {
			str += ", protein";
		}
		price = calcPrice();
		str += ", price: $" + price;
		return str;
	}
	
	public boolean equals(Smoothie s) {
		boolean bool = super.equals(s);
		if(bool = true) {
			if (fruit == s.getNumOfFruits() && protein == s.getAddProtien())
				return bool;
		}
			return false;	
	}
	
	public double calcPrice() {
		
		double price = super.getBasePrice();
		//double price = 0.0;
		
		if(super.getSize() == SIZE.MEDIUM)
			price += super.getSizeUp();
		else if (super.getSize() == SIZE.LARGE)
			price += 2 * super.getSizeUp();
		
		double fruitTotal = FRUIT_PRICE * getNumOfFruits();
		price += fruitTotal;
		boolean bool = protein;
		if (bool == true)
			price += PROTEIN_PRICE;
		
		return price;
	}
	
	

}
