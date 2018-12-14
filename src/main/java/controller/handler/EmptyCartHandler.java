package controller.handler;

import domain.Person;
import domain.Product;
import domain.ShopService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;

public class EmptyCartHandler extends RequestHandler {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        ShopService service = super.getShopService();
        HttpSession session = request.getSession();
        Person person = (Person) session.getAttribute("user");


        for( Map.Entry<Product, Integer> m : person.getCartInfo().entrySet()) {
           Product p = m.getKey();

           Product pr =  service.getProduct(p.getProductId());
           pr.setQuantity(pr.getQuantity() + m.getValue());
           service.updateProduct(pr);
        }

        person.emptycart();
        request.setAttribute("cartInfo", person.getCartInfo());

        return "shopingCart.jsp";
    }
}
