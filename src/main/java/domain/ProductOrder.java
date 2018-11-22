package domain;

public class ProductOrder {
	private Product product;
	private int quantity;

	public ProductOrder(Product product, int quantity) {
		setProduct(product);
		setQuantity(quantity);
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getQuantity() {
		return quantity;
	}

	private Product getProduct() {
		return product;
	}

	private void setProduct(Product product) {
		this.product = product;
	}
	
	public String getProductName(){
		return product.getName();
	}

	public double getTotalPrice() {
		return getProduct().getPrice() * getQuantity();
	}

	public String getProductDescription() {
		return getProduct().getDescription();
	}

	public double getProductPrice() {
		return getProduct().getPrice();
	}

	public int getProductId() {
		return getProduct().getProductId();
	}

	public void setPrice(double newPrice) {
		product.setPrice(newPrice);
	}

}
