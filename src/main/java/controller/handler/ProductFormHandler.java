package controller.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ProductFormHandler extends RequestHandler {

	public ProductFormHandler() {}
	
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();

		if(session.getAttribute("user") == null){
			return "index.jsp";
		}

		return "productForm.jsp";
	}	
}
