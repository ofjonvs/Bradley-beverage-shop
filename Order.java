package abc;

import java.util.*;

public class Order implements OrderInterface, Comparable<Order>{
	
	private int orderNumber;
	private int time;
	private DAY day;
	private Customer customer;
	private ArrayList<Beverage> beverageList;
	
	public Order(int t, DAY d, Customer c) {
		orderNumber = randomNumber();
		time = t;
		day = d;
		customer = c;
		beverageList = new ArrayList<>();
	}
	
	public int getOrderNo() {
		return orderNumber;
	}
	
	public void setOrderNo (int n) {
		orderNumber = n;
	}
	
	public int getOrderTime() {
		return time;
	}
	
	public void setOrderTime(int t) {
		time = t;
	}
	
	public DAY getOrderDay() {
		return day;
	}
	
	public void setOrderDay(DAY d) {
		day = d;
	}
	
	public Customer getCustomer() {
		return new Customer(customer);
	}
	
	public void setCustomer(Customer c) {
		customer = c;
	}
	
	public ArrayList <Beverage> getBeverages(){
		return beverageList;
	}
	
	public int randomNumber() {
		
		Random random = new Random();
		int randomNum = 0;
		randomNum = random.nextInt(90000 - 10000);
		return randomNum;
	}

	@Override
	public int compareTo(Order o) {
		if (orderNumber == o.getOrderNo())
			return 0;
		else if (orderNumber < o.getOrderNo())
			return -1;
		else
			return 1;
	}

	@Override
	public boolean isWeekend() {
		
		boolean bool = false;
		if (day == DAY.SATURDAY)
			bool = true;
		if (day == DAY.SUNDAY)
			bool = true;
		
		return bool;
	}

	@Override
	public Beverage getBeverage(int itemNo) {
		return beverageList.get(itemNo);
	}

	@Override
	public void addNewBeverage(String bevName, SIZE size, boolean extraShot, boolean extraSyrup) {
		Coffee cofeeOrder = new Coffee(bevName, size, extraShot, extraSyrup);
		beverageList.add(cofeeOrder);
	}

	@Override
	public void addNewBeverage(String bevName, SIZE size) {
		boolean bool = isWeekend();
		Alcohol alcoholOrder = new Alcohol(bevName, size, bool);
		beverageList.add(alcoholOrder);
	}

	@Override
	public void addNewBeverage(String bevName, SIZE size, int numOfFruits, boolean addPRotien) {
		Smoothie smoothieOrder = new Smoothie(bevName, size, numOfFruits, addPRotien);
		beverageList.add(smoothieOrder);
	}

	@Override
	public double calcOrderTotal() {
		double total = 0;
		for(Beverage beverage : beverageList) {
			total += beverage.calcPrice();
		}
		return total;
	}

	@Override
	public int findNumOfBeveType(TYPE type) {
		int numOfBeve = 0;
		for (Beverage beverage : beverageList) {
			if(beverage.getType() == type)
				numOfBeve++;
		}
		return numOfBeve;
	}
	
	
	public String toString() {
		String str = "Order number: " + orderNumber + ", " + time + " ," +  day + ", " + customer;
		for (Beverage beverage : beverageList)
			str += "\n" + beverage;
		str += ", total: " +calcOrderTotal();
		return str;
	}
	
	public int getTotalItems() {
		return beverageList.size();
	}

}
