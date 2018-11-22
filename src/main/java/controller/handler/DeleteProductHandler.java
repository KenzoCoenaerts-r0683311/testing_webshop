package controller.handler;

import domain.ShopService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteProductHandler extends RequestHandler {
    private ShopService shop;

    public DeleteProductHandler(){}

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
	    /*
		request.setAttribute("id", request.getParameter("id"));
		return "deleteProduct.jsp";
		*/
        shop = super.getShopService();
        String keuze = request.getParameter("submit");
        shop.deleteProduct(Integer.parseInt(request.getParameter("id")));
        request.setAttribute("products", shop.getProducts());
        return "Controller?action=productOverview";
    }

}
