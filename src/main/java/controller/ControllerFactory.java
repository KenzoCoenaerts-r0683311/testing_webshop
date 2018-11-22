package controller;

import controller.handler.RequestHandler;
import domain.ShopService;

public class ControllerFactory {
    public RequestHandler getController(String key, ShopService model) {
        return createHandler(key, model);
    }

    private RequestHandler createHandler(String handlerName, ShopService model) {
        RequestHandler handler = null;
        try {
            handlerName = handlerName.substring(0, 1).toUpperCase() + handlerName.substring(1);
            Class<?> handlerClass = Class.forName("controller.handler."+ handlerName + "Handler");
            Object handlerObject = handlerClass.newInstance();
            handler = (RequestHandler) handlerObject;
            handler.setModel(model);
        } catch (Exception e) {
            throw new RuntimeException("Deze pagina bestaat niet!!!!");
        }
        return handler;
    }
}

