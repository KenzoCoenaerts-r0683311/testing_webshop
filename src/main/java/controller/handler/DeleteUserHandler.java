package controller.handler;

import domain.ShopService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteUserHandler extends RequestHandler {

	private ShopService shop;

	public DeleteUserHandler(){}
	
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		/*request.setAttribute("id", request.getParameter("id"));
		return "deleteUser.jsp";*/
        shop = super.getShopService();
		String keuze = request.getParameter("id");
		shop.deletePerson(request.getParameter("id"));
		request.setAttribute("users", shop.getPersons());

		return "Controller?action=userOverview";
	}

}
