package domain;

public class Product {
	private int productId;
	private String name;
	private String description;
	private double price;
	private int quantity;

	public Product() {}

	public Product(int productId, String name, String description, double d, int quantity ) {
	    this(name, description, d, quantity);
		setProductId(productId);
		//setName(name);
		//setDescription(description);
		//setPrice(d);
	}

	public Product(String name, String description, double d, int quantity) {
		setName(name);
		setDescription(description);
		setPrice(d);
		setQuantity(quantity);
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getQuantity(){
		return this.quantity;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if (name.isEmpty()) {
			throw new DomainException("No name given");
		}
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		if (description.isEmpty()) {
			throw new DomainException("No description given");
		}

		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		if (price < 0) {
			throw new DomainException("Give a valid price");
		}
		this.price = price;
	}

	public void setPrice(String price) {
		if (price.isEmpty()) {
			throw new DomainException("No price given");
		}
		setPrice(Double.valueOf(price));
	}

	@Override
	public String toString() {
		return getName() + ": " + getDescription() + " - " + getPrice();
	}

    @Override
    public int hashCode()
    {
        return productId + name.hashCode() + description.hashCode();
    }

    @Override
    public boolean equals(Object o)
    {
        Product p = (Product) o;
        return this.name.equals(p.getName());
    }
}
