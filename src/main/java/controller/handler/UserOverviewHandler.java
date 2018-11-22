package controller.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.ShopService;

public class UserOverviewHandler extends RequestHandler {
	private ShopService shop;

	public UserOverviewHandler(){}

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		shop = super.getShopService();
		request.setAttribute("users", shop.getPersons());
		return "personoverview.jsp";
	}

}
