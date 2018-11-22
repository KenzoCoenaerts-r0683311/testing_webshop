package controller.handler;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ChangeColorHandler extends RequestHandler {
    private Cookie cookie = new Cookie("color", "yellow");

    public ChangeColorHandler(){ }

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        response.addCookie(cookie);
        Cookie[] cookies = request.getCookies();

        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getValue().equals(("yellow"))) {
                    cookie.setValue("red");
                    response.addCookie(cookie);
                } else if (cookie.getValue().equals(("red"))) {
                    cookie.setValue("yellow");
                    response.addCookie(cookie);
                }
            }
        }


        request.setAttribute("color", cookie.getValue());
        return "Controller?action=" + request.getParameter("page");
    }
}
