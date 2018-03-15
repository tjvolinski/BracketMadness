package bracket.madness.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/results")
public class ResultController {
    
    @RequestMapping("/layout")
    public String getBracketPartialPage() {
        return "results/layout";
    }
}
