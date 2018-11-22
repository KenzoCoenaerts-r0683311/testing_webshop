package controller.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.ShopService;

public class DeleteUserConfirmedHandler extends RequestHandler {
	private ShopService shop;

	public DeleteUserConfirmedHandler(){}

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		shop = super.getShopService();
		String keuze = request.getParameter("submit");

		if (keuze.equals("ja")) {
			shop.deletePerson(request.getParameter("id"));
		}

		request.setAttribute("users", shop.getPersons());
		
		return "Controller?action=userOverview";
	}

}
