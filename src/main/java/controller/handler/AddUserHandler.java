package controller.handler;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Person;
import domain.Role;
import domain.ShopService;

public class AddUserHandler extends RequestHandler {
    private ShopService shop;

    public AddUserHandler(){}

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        shop = super.getShopService();
        ArrayList<String> errors = new ArrayList<>();
        Person p = new Person();

        try {
            p.setFirstName(request.getParameter("firstName"));
        } catch (IllegalArgumentException e) {
            errors.add(e.getMessage());
        }
        try {
            p.setLastName(request.getParameter("lastName"));
        } catch (IllegalArgumentException e) {
            errors.add(e.getMessage());
        }
        try {
            p.setEmail(request.getParameter("email"));
        } catch (IllegalArgumentException e) {
            errors.add(e.getMessage());
        }

        try {
            p.setRole(Role.CUSTOMER);
        } catch (IllegalArgumentException e) {
            errors.add(e.getMessage());
        }

        try {
            p.setPasswordHashed(request.getParameter("password"));
        } catch (IllegalArgumentException e) {
            errors.add(e.getMessage());
        }

        if (errors.isEmpty()) {
            shop.addPerson(p);
            request.setAttribute("products", shop.getProducts());
            return "index.jsp";
        }

        request.setAttribute("errors", errors);
        return "Controller?action=signUp";
    }
}
