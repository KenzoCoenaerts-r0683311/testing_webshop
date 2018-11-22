package controller.handler;

import domain.Person;
import domain.Product;
import domain.ShopService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class DeleteProductFromCartHandler extends RequestHandler {
    private ShopService shop;

    public DeleteProductFromCartHandler(){}

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        shop = super.getShopService();
        HttpSession session = request.getSession();
        Person p = (Person) session.getAttribute("user");
        int productID = Integer.parseInt(request.getParameter("id"));
        Product product = shop.getProduct(productID);;
        p.deleteFromCart(product);

        return "Controller?action=shopingCart";
    }
}
