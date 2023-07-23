package com.IEEE.service;


import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import com.IEEE.entity.EmailDetails;

@Service
public class EmailService1 {
	  @Value("${spring.mail.username}")
	    private String sender;
    public boolean sendSimpleMail(String subject,String message,String recipient) {
    	boolean f=false;
    	
    	
    	Properties properties=System.getProperties();
    	
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host","smtp.gmail.com" );
        properties.put("mail.smtp.port", 587);

        Session session = Session.getInstance(properties, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("ieee20024@gmail.com", "ybbioyiiqrkregkp");
            }
        });
        
        MimeMessage m=new MimeMessage(session);
        try {
        	m.setFrom(sender);
        	m.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
        	m.setSubject(subject);
        	m.setText(message);
        	
        	
            MimeBodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setContent(message, "text/html");

            // Create the header image part
            MimeBodyPart imagePart = new MimeBodyPart();
            ClassPathResource imageResource = new ClassPathResource("static/images/Websitelogo.jpg");
            DataSource dataSource = new FileDataSource(imageResource.getFile());
           // Replace with the actual path to the image file
          
            imagePart.setDataHandler(new DataHandler(dataSource));
            imagePart.setFileName(imageResource.getFilename());
            // Create a multipart message and add the parts
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(imagePart);
            multipart.addBodyPart(messageBodyPart);

            // Set the multipart as the content of the email
            m.setContent(multipart);
        	Transport.send(m);
        	f=true;
        }
        catch(Exception e) {
        	e.printStackTrace();
        }
        return f;
    }
}
