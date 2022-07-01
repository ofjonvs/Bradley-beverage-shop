package abc;

public class Coffee extends Beverage{

	private boolean extraShot;
	private final double SHOT_PRICE = 0.5;
	private boolean extraSyrup;
	private final double SYRUP_PRICE = 0.5;
	
	public Coffee(String n, SIZE s, boolean sh, boolean sy) {
		super(n, TYPE.COFFEE , s);
		extraShot = sh;
		extraSyrup = sy;
	}
	
	
	public boolean getExtraShot() {
		return extraShot;
	}
	
	public void setExtraShot(boolean s) {
		extraShot = s;
	}
	
	public boolean getExtraSyrup() {
		return extraSyrup;
	}
	
	public void setExtraSyrup(boolean s) {
		extraSyrup = s;
	}
	
	public double getShotPrice() {
		return SHOT_PRICE;
	}
	
	public double getSyrupPrice() {
		return SYRUP_PRICE;
	}
	
	public String toString() {
		
		boolean bool = extraShot;
		double price = 0.0;
		String str = "" + getBevName() + ", " + getSize();
		if (bool == true) {
			str += ", " + "extra shot" ;
			bool = extraSyrup;
			if (bool == true) {
				str += ", " + "extra syrup";
				price = calcPrice();
				str += ", price: $" + price;
				return str;
			}
		}		
		bool = extraSyrup;
		if(bool == true) {
			str += ", " + "extra shot" ;
		}
		price = calcPrice();
		str += ", price: $" + price;
		return str;
	}
	
	public double calcPrice() {
		
		double price = super.getBasePrice();
		boolean boolShot = extraShot;
		boolean boolSyrup = extraSyrup;
		
		if(super.getSize() == SIZE.MEDIUM)
			price += super.getSizeUp();
		else if (super.getSize() == SIZE.LARGE)
			price += 2* super.getSizeUp();
		
		if (boolShot == true)
			price += SHOT_PRICE;
		if (boolSyrup == true)
			price += SYRUP_PRICE;
		
		return price;
	}
	
	public boolean equals(Coffee c) {
		boolean bool = super.equals(c);
		if(bool = true) {
			if (extraShot == c.getExtraShot() && extraSyrup == c.getExtraSyrup())
				return bool;
		}
			return false;	
	}
	
	

}
