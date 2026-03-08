package com.jspiders.User_App.Entity;



import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
public class User
{
@Id 
@GeneratedValue(strategy = GenerationType.IDENTITY)

private int userId;

@NotBlank(message = "Name cannot be empty")
@Size(min = 3, max = 50)
@Pattern(regexp = "^[A-Za-z ]+$", message = "Only letters allowed")
private String userName;
 

@NotBlank(message = "Email cannot be empty")
@Email(message = "Enter a valid email address")
private String userEmail;

@NotBlank(message = "Password cannot be empty")
@Size(min = 8, message = "Password must be at least 8 characters")
@JsonProperty(access=JsonProperty.Access.WRITE_ONLY)
private String userPassword;

@Pattern(regexp = "^[6-9][0-9]{9}$", message = "Enter valid 10-digit mobile number")
private String userContact;

private String address;

@Min(value = 1, message = "Age must be at least 1")
@Max(value = 100, message = "Age must not exceed 100")
private int age;

@OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
private Aadhar aadhar;
}