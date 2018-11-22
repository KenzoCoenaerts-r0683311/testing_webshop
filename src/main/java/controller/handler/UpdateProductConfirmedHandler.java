package controller.handler;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.DomainException;
import domain.Product;
import domain.ShopService;

public class UpdateProductConfirmedHandler extends RequestHandler {
	private ShopService shop; 
	
	public UpdateProductConfirmedHandler(ShopService shop) {
		this.shop = shop;	
	}

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		ArrayList<String> errors = new ArrayList<>();
		Product p = shop.getProduct(Integer.parseInt(request.getParameter("id")));

		try {
			p.setName(request.getParameter("name"));
		} catch (DomainException e) {
			errors.add(e.getMessage());
		}
		try {
			p.setDescription(request.getParameter("description"));
		} catch (DomainException e) {
			errors.add(e.getMessage());
		}
		try {
			p.setPrice(Double.parseDouble(request.getParameter("price")));
		} catch (DomainException e) {
			errors.add(e.getMessage());
		}

		if(errors.isEmpty()) {
			shop.updateProduct(p);
			request.setAttribute("products", shop.getProducts());
			return "Controller?action=productOverview";
		} 
		
		request.setAttribute("errors", errors);
		return "updateProduct.jsp";
	}
}
