package front_pattern.mvc;

import front_pattern.mvc.controller.HandlerKey;

import java.util.HashMap;
import java.util.Map;

public class AnnotationHandlerMapping implements HandlerMapping{
    private Map<HandlerKey, AnnotationController> handlers = new HashMap<>();

    @Override
    public Object findHandler(HandlerKey handlerKey) {
        return handlers.get(handlerKey);
    }
}
