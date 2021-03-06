package controller.handler;

import domain.Person;
import domain.ShopService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ShopingCartHandler extends RequestHandler {
    ShopService shop;

    public ShopingCartHandler(){}

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();

        if(session.getAttribute("user") == null){
            return "index.jsp";
        }

        Person p = (Person) session.getAttribute("user");
        shop = super.getShopService();
        request.setAttribute("cartInfo", p.getCartInfo());
        request.setAttribute("totalPrice", p.totalPrice());
        return "shopingCart.jsp";
    }
}
