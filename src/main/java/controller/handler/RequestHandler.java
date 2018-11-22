package controller.handler;

import domain.ShopService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class RequestHandler {
    private ShopService shopService;

    public abstract String handleRequest(HttpServletRequest request, HttpServletResponse response);

    public void setModel(ShopService personService) {
        this.shopService = personService;
    }

    public ShopService getShopService() {
        return shopService;
    }
}
