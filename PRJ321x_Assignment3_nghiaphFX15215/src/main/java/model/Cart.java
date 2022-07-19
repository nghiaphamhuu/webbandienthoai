package model;

public class Cart {
	private int id;
	private int quantity;
	private String price;
	public Cart() {
		
	}
	public Cart(int id, int quantity, String price) {
		super();
		this.id = id;
		this.quantity = quantity;
		this.price = price;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Cart [id=" + id + ", quantity=" + quantity + ", price=" + price + "]";
	}
	
}
