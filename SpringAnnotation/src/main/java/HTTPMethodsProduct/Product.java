package HTTPMethodsProduct;

public class Product {
	private int id;
	private String name;
	private double price;
	private int quantity;
	private String Category;
	public Product(int id, String name, double price, int quantity, String category) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.Category = category;
	}
	
	public String getCategory() {
		return Category;
	}

	public void setCategory(String category) {
		Category = category;
	}

	public Product() {
		super();
		// TODO Auto-generated constructor stub
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
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
