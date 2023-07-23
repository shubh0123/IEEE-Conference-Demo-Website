package com.IEEE.entity;


import javax.persistence.*;
import javax.validation.constraints.*;



import java.sql.Blob;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="USER")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @NotBlank(message = "Username can not be black")
    @Size(min = 4,max=30,message = "User name name must be between 4-12 characters")
    private String Author1_Name;
    @Email(regexp="^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$",message = "Invalid email")
    @Column(unique = true)
    private String email;
    //    @Pattern(regexp = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})",
//            message = "Enter valid password \n At least one digit ,one lowercase letter ,one uppercase letter,one special character from the set of @#$% ,and length of the password must be between 6 and 20 characters")
   
    private String password ;
    
    private String country_code;
    
    private long contactNo;

    private long whatsappNo;
    private String Author2_Name;
    private String Author3_Name;
    private String Author4_Name;

    private String CorrespondingAuthorName;

    private String CorrespondingAuthorEmail;

    private long CorrespondingAuthorPhone;

    private String country;

  

    private String paper_title;

    private String University;

    private String participant_category;
    private String participant_membership;

    private String Department;

    private String presentation_type;

    private String Source;
    private String role;


//Fields for uploading file
//    private String imgName;
//    private String type;
//    private String imagePath;




    private boolean enabled;


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getAuthor1_Name() {
		return Author1_Name;
	}


	public void setAuthor1_Name(String author1_Name) {
		Author1_Name = author1_Name;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getCountry_code() {
		return country_code;
	}


	public void setCountry_code(String country_code) {
		this.country_code = country_code;
	}


	public long getContactNo() {
		return contactNo;
	}


	public void setContactNo(long contactNo) {
		this.contactNo = contactNo;
	}


	public long getWhatsappNo() {
		return whatsappNo;
	}


	public void setWhatsappNo(long whatsappNo) {
		this.whatsappNo = whatsappNo;
	}


	public String getAuthor2_Name() {
		return Author2_Name;
	}


	public void setAuthor2_Name(String author2_Name) {
		Author2_Name = author2_Name;
	}


	public String getAuthor3_Name() {
		return Author3_Name;
	}


	public void setAuthor3_Name(String author3_Name) {
		Author3_Name = author3_Name;
	}


	public String getAuthor4_Name() {
		return Author4_Name;
	}


	public void setAuthor4_Name(String author4_Name) {
		Author4_Name = author4_Name;
	}


	public String getCorrespondingAuthorName() {
		return CorrespondingAuthorName;
	}


	public void setCorrespondingAuthorName(String correspondingAuthorName) {
		CorrespondingAuthorName = correspondingAuthorName;
	}


	public String getCorrespondingAuthorEmail() {
		return CorrespondingAuthorEmail;
	}


	public void setCorrespondingAuthorEmail(String correspondingAuthorEmail) {
		CorrespondingAuthorEmail = correspondingAuthorEmail;
	}


	public long getCorrespondingAuthorPhone() {
		return CorrespondingAuthorPhone;
	}


	public void setCorrespondingAuthorPhone(long correspondingAuthorPhone) {
		CorrespondingAuthorPhone = correspondingAuthorPhone;
	}


	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}


	public String getPaper_title() {
		return paper_title;
	}


	public void setPaper_title(String paper_title) {
		this.paper_title = paper_title;
	}


	public String getUniversity() {
		return University;
	}


	public void setUniversity(String university) {
		University = university;
	}


	public String getParticipant_category() {
		return participant_category;
	}


	public void setParticipant_category(String participant_category) {
		this.participant_category = participant_category;
	}


	public String getParticipant_membership() {
		return participant_membership;
	}


	public void setParticipant_membership(String participant_membership) {
		this.participant_membership = participant_membership;
	}


	public String getDepartment() {
		return Department;
	}


	public void setDepartment(String department) {
		Department = department;
	}


	public String getPresentation_type() {
		return presentation_type;
	}


	public void setPresentation_type(String presentation_type) {
		this.presentation_type = presentation_type;
	}


	public String getSource() {
		return Source;
	}


	public void setSource(String source) {
		Source = source;
	}


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}


	public boolean isEnabled() {
		return enabled;
	}


	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}






}

