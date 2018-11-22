package controller.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.ShopService;

public class DeleteProductConfirmedHandler extends RequestHandler {
	private ShopService shop;
	
	public DeleteProductConfirmedHandler() {}

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		shop = super.getShopService();
		String keuze = request.getParameter("submit");

		if (keuze.equals("ja")) {
			shop.deleteProduct(Integer.parseInt(request.getParameter("id")));
		}

		request.setAttribute("products", shop.getProducts());
		
		return "Controller?action=productOverview";
	}

}
