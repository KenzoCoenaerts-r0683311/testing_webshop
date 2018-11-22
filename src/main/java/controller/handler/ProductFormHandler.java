package controller.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProductFormHandler extends RequestHandler {


	public ProductFormHandler() {}
	
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		return "productForm.jsp";
	}	
}
