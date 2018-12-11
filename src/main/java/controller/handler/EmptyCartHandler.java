package controller.handler;

import domain.Person;
import domain.ShopService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class EmptyCartHandler extends RequestHandler {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        Person person = (Person) session.getAttribute("user");
        person.emptycart();
        request.setAttribute("cartInfo", person.getCartInfo());
        System.out.println("hierbenik");

        return "shopingCart.jsp";
    }
}
