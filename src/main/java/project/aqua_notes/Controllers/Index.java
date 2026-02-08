package project.aqua_notes.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class Index {
    
    @GetMapping("/")
    public String getMethodName() {
        return "Index";
    }
    
}
