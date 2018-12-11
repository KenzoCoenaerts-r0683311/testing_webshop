package controller.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.ShopService;

public class ProductOverviewHandler extends RequestHandler {
	private ShopService shop;

	public ProductOverviewHandler(){}

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();

        if(session.getAttribute("user") == null){
            return "index.jsp";
        }

		shop = super.getShopService();
		request.setAttribute("products", shop.getProducts());
		return "productoverview.jsp";
	}
}
