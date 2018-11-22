package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Properties;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.NotAuthorizedException;

import controller.handler.RequestHandler;
import domain.*;

/**
 * Servlet implementation class UserController
 */

@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ShopService shopService;
	private ControllerFactory controllerFactory = new ControllerFactory();

	public Controller() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
	}

    @Override
    public void init() throws ServletException {
        super.init();
        ServletContext context = getServletContext();

        Properties properties = new Properties();
        Enumeration<String> paramNames = context.getInitParameterNames();
        while (paramNames.hasMoreElements()) {
            String propertyName = paramNames.nextElement();
            properties.setProperty(propertyName, context.getInitParameter(propertyName));
        }

        shopService = new ShopService(properties);
    }

	protected void  processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		String destination = "index.jsp";
		RequestHandler handler = null;
		if (action != null) {
			try {
				handler = controllerFactory.getController(action, shopService);
				destination = handler.handleRequest(request, response);
			} catch (NotAuthorizedException exc) {
				List<String> errors = new ArrayList<String>();
				errors.add(exc.getMessage());
				request.setAttribute("errors", errors);
				destination = "index.jsp";
			}

		}


        RequestDispatcher view = request.getRequestDispatcher(destination);
        view.forward(request, response);

	}

}