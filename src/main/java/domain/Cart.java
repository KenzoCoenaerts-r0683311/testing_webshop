package domain;

import java.util.*;

public class Cart {
	private Map<Product, Integer> productsInCart;

	public Cart(){
        productsInCart = new HashMap<Product, Integer>();
    }

	public void addProduct(Product product){
	    if(!productsInCart.containsKey(product)){
	        productsInCart.put(product, 1);
	        product.setQuantity(product.getQuantity()-1);
        } else {
	       int i = productsInCart.get(product);
	       productsInCart.put(product, ++i);
        }
    }

    public void deleteProduct(Product product){
	    product.setQuantity(product.getQuantity()+1);
	    if(productsInCart.get(product) == 0){
            productsInCart.remove(product);
        } else {
	        int i = productsInCart.get(product);
	        productsInCart.put(product, --i);

            if(productsInCart.get(product) == 0)
                productsInCart.remove(product);
        }
    }

    public Map<Product, Integer> getCart(){
        System.out.print("what ?");
	    return productsInCart;
    }

    public double totalPrice(){
	    double totalPrice = 0;

	    for(Product product : productsInCart.keySet()){
	        totalPrice += product.getPrice() * productsInCart.get(product);
        }

	    return totalPrice;
    }

    public void emptycart() {
	    productsInCart = new HashMap<>();
    }
}
