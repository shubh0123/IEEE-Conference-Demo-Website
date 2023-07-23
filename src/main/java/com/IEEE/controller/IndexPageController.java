package com.IEEE.controller;

import com.IEEE.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class IndexPageController {


    @RequestMapping("/")
    public String home(Model model){
        model.addAttribute("title","Home -IEEE");
        return "index";
    }
    @RequestMapping("/theme")
    public String theme(Model model){
        model.addAttribute("title","Theme -IEEE");
        return "theme";
    }
    @RequestMapping("/committee")
    public String committee(Model model){
        model.addAttribute("title","Theme -IEEE");
        return "committee";
    }
    @RequestMapping("/paperPolicy")
    public String paperPolicy(Model model){
        model.addAttribute("title","Paper Policy -IEEE");
        return "paperPolicy";
    }
    @RequestMapping("/keynoteSpeaker")
    public String keynoteSpeaker(Model model){
        model.addAttribute("title","keynote Speaker -IEEE");
        return "keynoteSpeaker";
    }
    @GetMapping("/index")
    public String index() {
        return "index";
    }

    @GetMapping("/index#about")
    public String about() {
        return "index";
    }
    @GetMapping("/index#event")
    public String event() {
        return "index";
    }
    @GetMapping("/index#contact")
    public String contact() {
        return "index";
    }
  /* @GetMapping("/forgotPassword")
    public String forgotPassword(Model model) {
    	model.addAttribute("title","ForgotPassword -IEEE");
        return "forgotPassword";
    }*/
    @RequestMapping("/signup")
    public String signup(Model model){
        model.addAttribute("title","SignUp -IEEE");
        model.addAttribute("user",new User());
        return "signup";
    }
    //handler for custom login
 /*   @GetMapping("/login")
    public String CustomLogin(Model model){
      model.addAttribute("title","LogIn -smartContact Manager");
 
          return "login";
    }*/

    
 
}
