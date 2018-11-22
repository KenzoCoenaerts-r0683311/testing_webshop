package controller.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.ShopService;

public class ProductOverviewHandler extends RequestHandler {
	private ShopService shop;

	public ProductOverviewHandler(){}

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		shop = super.getShopService();
		request.setAttribute("products", shop.getProducts());
		return "productoverview.jsp";
	}

}
