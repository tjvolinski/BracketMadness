package bracket.madness.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/calculator")
public class CalculatorController {
    
    @RequestMapping("/layout")
    public String getBracketPartialPage() {
        return "calculator/layout";
    }
}
