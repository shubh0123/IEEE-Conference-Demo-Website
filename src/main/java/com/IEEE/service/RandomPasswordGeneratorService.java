package com.IEEE.service;

import java.util.Random;

import org.springframework.stereotype.Service;
@Service
public class RandomPasswordGeneratorService {
	public String passwordGenerator() {
		
StringBuilder randomString = new StringBuilder();
        
    new Random().ints(64, 122)
                    .filter(i->!(i>90&&i<97))
                    .boxed()
                    .limit(4)
                    .map(c->Character.toChars(c))
                    .forEach(c->randomString.append(c));
    Random r = new Random();
    String randomNumber = String.format("%03d", r.nextInt(999));
  
           String password=randomString+"@"+randomNumber;
        System.out.println("Password Generated Successfully");
        return password;
	}

}
