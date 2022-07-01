package abc;

public class Customer {
	
	private String name;
	private int age;
	
	public Customer(String n, int a) {
		name = n;
		age = a;
	}
	
	public Customer(Customer c) {
		name = c.getName();
		age = c.getAge();
	}
	
	public Customer() {}
	
	public String getName(){
		return name;
	}
	
	public void setName(String n) {
		name = n;
	}
	
	public int getAge() {
		return age;
	}

	public void setAge(int a) {
		age = a;
	}
	
	public String toString() {
		String str = "Name: " + name + ", Age: " + age;
		return str;
	}
}

