package com.IEEE.controller;


import com.IEEE.dao.UserRepository;
import com.IEEE.entity.EmailDetails;
import com.IEEE.entity.User;
import com.IEEE.helper.Message1;
import com.IEEE.service.EmailService1;
import com.IEEE.service.EmailServiceImpl;
//import com.IEEE.service.FileUploadService;
import com.IEEE.service.RandomPasswordGeneratorService;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.mail.Message;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.security.Principal;
import java.util.Random;

@Controller
public class RegistrationController {


    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @Autowired
    private EmailService1 emailService;
  //  @Autowired
   // private FileUploadService fileUploadService;
    @Autowired
    private RandomPasswordGeneratorService randomPasswordGenerator;
    
//    handler for registering user
  @PostMapping("/register")
    public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result1, Model model, HttpSession session, Principal principal){
    try{

        System.out.println("ERROR "+ result1.toString());
        //validation
        if(result1.hasErrors()){
            System.out.println("ERROR "+ result1.toString());
            model.addAttribute("user",user);
            return "signup";
        }
        long checkEmail=userRepository.countByEmail(user.getEmail());
        System.out.println(checkEmail);
        if(checkEmail==1){
            session.setAttribute("message", new Message1("Email-Id is already registered !!", "alert-danger"));
            throw new Exception("Email-Id is already registered !!");

        }

        user.setRole("ROLE_USER");
        user.setEnabled(true);
        
 
        //System.out.println(fileUploadService.fileUpload(file,user));       //File upload

        String password=randomPasswordGenerator.passwordGenerator();//Generating Random Password for user
         user.setPassword(passwordEncoder.encode(password));        //encoding password
         userRepository.save(user);//saving details of user in database
        //preparing email message
        String msg="<div style='border-style:solid;padding:5px;'> <img src='images/Websitelogo.jpg'  width='70px' height='70px'><br><b>Dear "+user.getAuthor1_Name()+",</b><br>Thank you for registering for IEEE Conference 2024<br>Your payment has been registered successfully</div>";
        
        boolean flag=emailService.sendSimpleMail("Registration for IEEE conference", msg,user.getEmail());//sending mail
     if(flag)
     { System.out.println("Mail Sent successfully");
     

        model.addAttribute("user", new User());
        session.setAttribute("message", new Message1("Successfully Submitted and Your payment has been received successfully!!!", "alert-success"));
     }
        System.out.println(user);
    }
    catch(Exception e){
        e.printStackTrace();
        model.addAttribute("user",user);
        session.setAttribute("message", new Message1("Something went wrong !!!"+e.getMessage(),"alert-danger"));
        return "signup";
    }
        return "signup";
    }
}
