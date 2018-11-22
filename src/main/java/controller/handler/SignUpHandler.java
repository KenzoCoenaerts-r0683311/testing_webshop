package controller.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SignUpHandler extends RequestHandler {
	public SignUpHandler() {}

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		return "signUp.jsp";
	}
}
