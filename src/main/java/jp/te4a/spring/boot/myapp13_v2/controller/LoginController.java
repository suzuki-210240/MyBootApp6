package jp.te4a.spring.boot.myapp13_v2.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class LoginController {
    
    @GetMapping(path = "loginForm")
    String loginForm() {
        return "loginForm";
    }
    
}
