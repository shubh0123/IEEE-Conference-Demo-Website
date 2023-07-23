package com.IEEE.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@Entity
@Table(name="FEEDBACK")
public class Feedback {

	    @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private int feedbackId;

	    @Email(regexp="^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$",message = "Invalid email")
	    private String email;
	    
	    private String content;
	    


		public int getFeedbackId() {
			return feedbackId;
		}

		public void setFeedbackId(int feedbackId) {
			this.feedbackId = feedbackId;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getContent() {
			return content;
		}

		public void setContent(String content) {
			this.content = content;
		}




	    
	    

}
