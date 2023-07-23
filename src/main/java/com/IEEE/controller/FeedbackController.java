package com.IEEE.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.IEEE.dao.FeedbackRepository;

import com.IEEE.entity.Feedback;


@Controller
public class FeedbackController {
    @Autowired
    private FeedbackRepository feedbackRepository;
	@PostMapping("/help")
	public String feedback( @ModelAttribute("feedback")Feedback feedback) {
	
		feedbackRepository.save(feedback);
		return "index";
	}
}
