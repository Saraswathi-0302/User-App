package com.jspiders.User_App.Entity;



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
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
public class User
{
@Id 
@GeneratedValue(strategy = GenerationType.IDENTITY)

private int userId;

//@NotNull(message ="Name can not be null")

//@NotEmpty(message="Name can not be Empty")

@NotBlank(message ="Fields must not contain empty,null")

@Size(min=3,max=5)

@Pattern(regexp="[ A-Za-z]*a4")
private String userName;
 
@Email(regexp="")
private String userEmail;

@Pattern(regexp="")
private String userPassword;

@Pattern(regexp="")
private String userContact;

private String address;

//Either You can use anyone positive/minimum ,maximum
@Positive
@Max(value=100)
@Min(value=1)
private int age;

@OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
private Aadhar aadhar;
}