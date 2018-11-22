package controller.handler;

import javax.servlet.http.HttpServletRequest; 
import javax.servlet.http.HttpServletResponse;

import domain.Person;
import domain.ShopService;

public class UserUpdateHandler extends RequestHandler {
	private ShopService shop;

	public UserUpdateHandler(){}
	
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		shop = super.getShopService();
		String id = request.getParameter("id");
		Person p = shop.getPerson(id);
		request.setAttribute("id", id);
		request.setAttribute("firstName", p.getFirstName());
		request.setAttribute("lastName", p.getLastName());
		request.setAttribute("email", p.getEmail());
		request.setAttribute("role", p.getRole());
		return "updateUser.jsp";
	}
}
