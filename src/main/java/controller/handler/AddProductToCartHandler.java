package controller.handler;

import domain.Person;
import domain.Product;
import domain.ShopService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AddProductToCartHandler extends RequestHandler {
    private ShopService shop;

    public AddProductToCartHandler(){}

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        shop = super.getShopService();
        HttpSession session = request.getSession();
        Person p = (Person) session.getAttribute("user");
        int productID = Integer.parseInt(request.getParameter("id"));
        Product product = shop.getProduct(productID);;
        p.addToCart(product);

        return "Controller?action=productOverview";
    }
}
