package com.IEEE.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.IEEE.dao.UserRepository;
import com.IEEE.entity.User;


import java.security.Principal;

@Controller
@RequestMapping("/user")
public class UserController {

    
    @RequestMapping("/index")
    public String dashboard(Model model, Principal principal)//Object of principal stores the unique identifier of perticular login credentials;
    {

        return "user_dashboard";
    }
}
    