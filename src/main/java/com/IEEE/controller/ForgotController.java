package com.IEEE.controller;

import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.IEEE.dao.UserRepository;
import com.IEEE.entity.User;
import com.IEEE.helper.Message1;
import com.IEEE.service.EmailService1;
import com.IEEE.service.RandomPasswordGeneratorService;
@Controller
public class ForgotController {

	@Autowired
	private EmailService1 emailService;
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RandomPasswordGeneratorService randomPasswordGenerator;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
	
	   @PostMapping("/sendOTP")
	    public String sendOTP(@RequestParam("email") String email,HttpSession session){
		   if(userRepository.countByEmail(email)==1) {
		    Random r = new Random();
		    String otp = String.format("%06d", r.nextInt(999999));
		    String msg="Dear Recipient,<br>"
		    		+ "We have received your request for reset password.<br>"
		    		+ "<br>Your OTP is:"+otp+"</br>";
		    session.setAttribute("otp", otp);
		    boolean flag=emailService.sendSimpleMail("OTP for IEEE",msg,email);
		    session.setAttribute("email",email );
	        return "verifyUser";
		   }
		   else {
			   session.setAttribute("message", new Message1("Email-Id is not found!!\n Enter valid Email-id", "alert-danger"));
			   return "forgotPassword";
		   }
		   
	    }
	   @PostMapping("/verifyOTP")
	   public String verifyOTP(@RequestParam("otp") String otp,HttpSession session) {
		 
		   if(otp.equals(String.valueOf(session.getAttribute("otp"))))
		   {	
			   String email=String.valueOf(session.getAttribute("email"));
			  System.out.println(email);
			
			   String password=randomPasswordGenerator.passwordGenerator();//generating new password
			   
			 userRepository.updatePassword(email,passwordEncoder.encode(password));//updating password
			   String msgBody="Your new password is:<br><b>"+password+"</b>";
			   if(emailService.sendSimpleMail("Updated Password",msgBody,email))
			   {  
				session.setAttribute("message", new Message1("Check mail for new password", "alert-success"));
				 return "login";
			   }
			   else
			   {
				   return "verifyUser";
			   }
		   }
		   else {
			   System.out.println("OTP NOT matched");
		   }
		   return "login";
	   }
}
