package controller.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Product;
import domain.ShopService;

public class UpdateProductHandler extends RequestHandler {
	private ShopService shop;

	public UpdateProductHandler(){}

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		shop = super.getShopService();
		String id = request.getParameter("id");
		Product pr = shop.getProduct(Integer.parseInt(id));
		request.setAttribute("id", id);
		request.setAttribute("name", pr.getName());
		request.setAttribute("description", pr.getDescription());
		request.setAttribute("price", pr.getPrice());
		return "updateProduct.jsp";
	}

}
