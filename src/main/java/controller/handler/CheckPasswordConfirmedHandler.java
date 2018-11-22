package controller.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Person;
import domain.ShopService;

public class CheckPasswordConfirmedHandler extends RequestHandler {
	private ShopService shop;
	
	public CheckPasswordConfirmedHandler(){}

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		shop = super.getShopService();
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		Person p = shop.getPerson(id);

		if (p.isCorrectPassword(password)) {
			request.setAttribute("check", "juist");
		} else {
			request.setAttribute("check", "fout");
		}
		
		return "checkPassword.jsp";
	}
}
