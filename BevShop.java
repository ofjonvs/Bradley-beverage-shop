package abc;
import java.util.*;

public class BevShop implements BevShopInterfce{
	
	private int alcOrder;
	private int MIN_AGE_FOR_ALCOHOL = 21;  
	private int MAX_ORDER_FOR_ALCOHOL= 3;   
	private int MIN_TIME= 8;				
	private int MAX_TIME= 23;				
	private int MAX_FRUIT = 5;	
	private int index;
	private ArrayList<Order> orderList;
	
	public BevShop() {
		orderList = new ArrayList<>();
	}
	
	public int getNumOfAlcoholDrink() {
		return alcOrder;
	}
	
	public int getMaxOrderForAlcohol() {
		return MAX_ORDER_FOR_ALCOHOL;
	}
	
	public int getMaxFruits() {
		return MAX_FRUIT;
	}
	
	public int getMinAgeForAlcohol() {
		return MIN_AGE_FOR_ALCOHOL;
	}
	
	public Order getCurrentOrder() {
		return orderList.get(index);
	}
	
	public void setNumOfAlcoholDrink(int a) {
		alcOrder = a;
	}
	
	
	@Override
	public boolean validTime(int time) {
		if(time > MAX_TIME || time < MIN_TIME)
			return false;
		else
			return true;			
	}
	
	@Override
	public boolean eligibleForMore() {
		if (alcOrder < MAX_ORDER_FOR_ALCOHOL)
			return true;
		else
			return false;
	}
	@Override
	public boolean validAge(int age) {
		if(age < MIN_AGE_FOR_ALCOHOL)
			return false;
		else
			return true;
	}

	@Override
	public void startNewOrder(int time, DAY day, String customerName, int customerAge) {		
		Customer customer = new Customer(customerName, customerAge);
		Order order = new Order(time, day, customer);
		orderList.add(order);
		alcOrder = 0;
		index = orderList.indexOf(order);
	}

	@Override
	public void processCoffeeOrder(String bevName, SIZE size, boolean extraShot, boolean extraSyrup) {
		orderList.get(index).addNewBeverage(bevName, size, extraShot, extraSyrup);
	}

	@Override
	public void processAlcoholOrder(String bevName, SIZE size) {
		orderList.get(index).addNewBeverage(bevName, size);
		alcOrder++;
	}

	@Override
	public void processSmoothieOrder(String bevName, SIZE size, int numOfFruits, boolean addProtien) {
		orderList.get(index).addNewBeverage(bevName, size, numOfFruits, addProtien);
	}

	@Override
	public int findOrder(int orderNo) {
		int ind = 0;
		while (ind < orderList.size()) {
			if (orderList.get(ind).getOrderNo() == orderNo)
				return ind;
            ind++;
		}
		return -1;
	}

	@Override
	public double totalOrderPrice(int orderNo) {
		double total = 0.0;
		for (Order order : orderList) {
			if (order.getOrderNo() == orderNo) {
				for(Beverage beverage : order.getBeverages()) {
					total += beverage.calcPrice();
				}
			}
		}
		return total;
	}

	@Override
	public double totalMonthlySale() {
		double total = 0;
		for (Order order : orderList) {
			for (Beverage beverage : order.getBeverages()) {
				total += beverage.calcPrice();
			}
	}
		return total;
	}

	@Override
	public void sortOrders() {
	
		for (int i = 0; i < orderList.size() - 1; i++) {
			int idx = i;
			int x = i+1;
			while(x < orderList.size()) {
				if( orderList.get(idx).getOrderNo() > orderList.get(x).getOrderNo()) {
				idx = x;
				x++;		
			}
			}
			Order order = orderList.get(idx);
			orderList.set(idx, orderList.get(i));
			orderList.set(i, order);
		}
		
	}

	@Override
	public Order getOrderAtIndex(int index) {
		return orderList.get(index);
	}
	
	public boolean isMaxFruit(int fruit) {
		if (fruit > MAX_FRUIT) {
            return true;
    }
		else
			return false;
}
	
	public int totalNumOfMonthlyOrders() {
		return orderList.size();
	}


}
	
	
	
	
	
	

