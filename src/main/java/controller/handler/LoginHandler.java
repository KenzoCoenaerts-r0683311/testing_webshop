package controller.handler;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.Person;
import domain.ShopService;

public class LoginHandler extends RequestHandler {
	private ShopService shop;

	public LoginHandler(){}

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        String destination = "index.jsp";
        shop = super.getShopService();
		HttpSession session = request.getSession();
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		List<Person> persons = shop.getPersons();

		for (Person p : persons) {
			if (p.getEmail().equals(email)) {
				if (p.isCorrectPassword(password)) {
					session.setAttribute("user", p);
				}
			}
		}

		return destination;
	}
}
