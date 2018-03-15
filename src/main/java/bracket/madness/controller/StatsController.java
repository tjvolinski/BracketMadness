package bracket.madness.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/stats")
public class StatsController {
    
    @RequestMapping("/layout")
    public String getBracketPartialPage() {
        return "stats/layout";
    }
}
