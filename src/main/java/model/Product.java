package model;

public class Product {
	private int id;
	private String name;
	private String description;
	private int price;
	private String imagePath;
	private int stock;
	private int genreId;
	
	public Product(int id, String name, String description, int price, String imagePath) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.imagePath = imagePath;
	}
	
	public Product(int id, String name, int price,int stock,int genreId  ) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.stock = stock;
		this.genreId = genreId;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public int getPrice() {
		return price;
	}

	public String getImagePath() {
		return imagePath;
	}

	public int getStock() {
		return stock;
	}

	public int genreId() {
		return genreId;
	}
	

}
