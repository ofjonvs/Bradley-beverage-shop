package abc;

public abstract class Beverage {
	
	private String name;
	private TYPE type;
	private SIZE size;
	private final double PRICE = 2.0;
	private final double SIZE_UP = 1.0;
	
	public Beverage(String n, TYPE coffee, SIZE s) {
		name = n;
		type = coffee;
		size = s;
	}
	
	public abstract double calcPrice();
	
	public String getBevName() {
		return name;
	}
	
	public void setName(String n) {
		name = n;
	}
	
	public TYPE getType() {
		return type;
	}
	
	public void setType(TYPE t) {
		type = t;
	}
	
	public SIZE getSize() {
		return size;
	}
	
	public void setSize(SIZE s) {
		size = s;
	}
	
	public double getBasePrice() {
		return PRICE;
	}
	
	public double getSizeUp() {
		return SIZE_UP;
	}
	
	public String toString() {
		return name + ", " + size;
	}
	
	public boolean equals(Beverage beverage) {
		if(name.equals(beverage.getBevName())) {
			if (size == beverage.getSize() && type == beverage.getType()) 
					return true;
		}
		return false;	
	}
	
	

}
