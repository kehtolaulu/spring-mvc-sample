package app.controllers;

import app.services.Calculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(path = {"/calculator"})
public class CalculatorController {
    private final Calculator calculator;

    @Autowired
    public CalculatorController(@Qualifier("calculator") Calculator calculator) {
        this.calculator = calculator;
    }

    @RequestMapping(method = RequestMethod.GET, params = {"operation", "arg1", "arg2"})
    public String calculate(ModelMap modelMap,
                            @RequestParam("operation") String operation,
                            @RequestParam("arg1") Double arg1,
                            @RequestParam("arg2") Double arg2) {
        modelMap.put("isPresent", true);
        try {
            modelMap.put("value", calculator.calculate(operation, arg1, arg2));
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
            modelMap.put("message", e.getMessage());
        }
        return "calculator";
    }

    @RequestMapping(method = RequestMethod.GET)
    public String displayPage(ModelMap modelMap) {
        modelMap.put("isPresent", false);
        return "calculator";
    }
}
