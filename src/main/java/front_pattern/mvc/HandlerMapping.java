package front_pattern.mvc;

import front_pattern.mvc.controller.Controller;
import front_pattern.mvc.controller.HandlerKey;

public interface HandlerMapping {
    Object findHandler(HandlerKey handlerKey);
}
