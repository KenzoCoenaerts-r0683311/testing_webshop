package controller.handler;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.DomainException;
import domain.Product;
import domain.ShopService;

public class AddProductHandler extends RequestHandler {
	private ShopService shop;
	
	public AddProductHandler(){}

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		shop = super.getShopService();
		String destination = "productForm.jsp";
		ArrayList<String> errors = new ArrayList<>();
		Product p = new Product();

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
			p.setPrice(request.getParameter("price"));
		} catch (DomainException e) {
			errors.add(e.getMessage());
		}

		if (errors.isEmpty()) {
			shop.addProduct(p);
			destination= "Controller?action=productOverview";
		} else {
			request.setAttribute("errors", errors);
		}
		
		return destination;
	}
}
