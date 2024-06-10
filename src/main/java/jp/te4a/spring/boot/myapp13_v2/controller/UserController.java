package jp.te4a.spring.boot.myapp13_v2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import jp.te4a.spring.boot.myapp13_v2.form.UserForm;
import jp.te4a.spring.boot.myapp13_v2.service.UserService;

@Controller
@RequestMapping("users")
public class UserController {
    @Autowired
    UserService userService;
    @ModelAttribute
    UserForm setUpFrom(){
        return new UserForm();
    }

    @GetMapping
    String list(Model model){
        return "users/add";
    }

    @PostMapping(path="create")
    String create(@Validated UserForm form,BindingResult result, Model model){
        if(result.hasErrors()){
            return list(model);
        }
        userService.create(form);
        return "redirect:/users";
    }


}
