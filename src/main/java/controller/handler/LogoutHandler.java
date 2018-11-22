package controller.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutHandler extends RequestHandler {

	public LogoutHandler() {}

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		if(session != null){
			session.invalidate();
		}	
		return "index.jsp";
	}


}
