package controller.handler;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Person;
import domain.Role;
import domain.ShopService;

public class UserUpdateConfirmedHandler extends RequestHandler {
	private ShopService shop;
	
	public UserUpdateConfirmedHandler(){ }
	
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		shop = super.getShopService();
		ArrayList<String> errors = new ArrayList<>();
		Role role = Role.valueOf(request.getParameter("role"));
		Person p = shop.getPerson(request.getParameter("id"));

		try {
			p.setFirstName(request.getParameter("firstName"));
		} catch (IllegalArgumentException e) {
			errors.add(e.getMessage());
		}
		try {
			p.setLastName(request.getParameter("lastName"));
		} catch (IllegalArgumentException e) {
			errors.add(e.getMessage());
		}
		try {
			p.setEmail(request.getParameter("email"));
		} catch (IllegalArgumentException e) {
			errors.add(e.getMessage());
		}
		
		try {
			p.setRole(role);
		} catch (IllegalArgumentException e) {
			errors.add(e.getMessage());
		}	

		if (errors.isEmpty()) {
			shop.updatePersons(p);
			request.setAttribute("products", shop.getProducts());
			return "Controller?action=userOverview";
		} 
		
		request.setAttribute("errors", errors);
		return "updateUser.jsp";
	}
}
