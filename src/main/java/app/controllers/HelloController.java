package app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(path = {"/hello"})
public class HelloController {
    @RequestMapping(method = RequestMethod.GET)
    public String sayHello(@RequestParam(required = false) String name, ModelMap modelMap) {
        String message = name == null ? "say your name" : "Hello, " + name;
        modelMap.put("message", message);
        return "hello";
    }
}
