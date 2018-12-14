package controller.handler;

import domain.Person;
import domain.ShopService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class DeleteProductHandler extends RequestHandler {
    private ShopService shop;

    public DeleteProductHandler(){}

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
	    /*
		request.setAttribute("id", request.getParameter("id"));
		return "deleteProduct.jsp";
		*/
        HttpSession session = request.getSession();
        Person p = (Person) session.getAttribute("user");
        shop = super.getShopService();
        String keuze = request.getParameter("submit");
        shop.deleteProduct(Integer.parseInt(request.getParameter("id")));
        p.emptycart();
        request.setAttribute("products", shop.getProducts());
        return "Controller?action=productOverview";
    }

}
