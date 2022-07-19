package model;

public class Product {
	private int id;
	private String name;
	private String des;
	private String price;
	private String img;
	private String type;
	private String brand;
	public Product() {
		
	}
	
	public Product(int id, String name, String des, String price, String img, String type, String brand) {
		super();
		this.id = id;
		this.name = name;
		this.des = des;
		this.price = price;
		this.img = img;
		this.type = type;
		this.brand = brand;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDes() {
		return des;
	}
	public void setDes(String des) {
		this.des = des;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", des=" + des + ", price=" + price + ", img=" + img + ", type="
				+ type + ", brand=" + brand + "]";
	} 
	
}
