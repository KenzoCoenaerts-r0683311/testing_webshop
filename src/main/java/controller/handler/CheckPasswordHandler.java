package controller.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CheckPasswordHandler extends RequestHandler {

	public CheckPasswordHandler() {}
	
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("id", request.getParameter("id"));
		return "checkPassword.jsp";
	}
}
