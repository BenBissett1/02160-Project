package main;

public class Client2 {
	public static String name;
	public static String password;
	public static String address;
	public static String email;
	public static String phone;

	public static void setName(String n) {
		name= n;
	}
	public static void setPassword(String n) {
		password = n;
	}
	public static void setEmail(String n) {
		email = n;
	}
	public static void setAddress(String n) {
		address = n;
	}
	public static void setPhone(String n) {
		phone = n;
	}
	public static String getName() {
		return name;
	}
	public void register( ) {
		dataStructure.regNewClient(name, password, address, email, phone);
	}
	public void display() {
		System.out.println(dataStructure.searchC(name, 0));
	}
}
