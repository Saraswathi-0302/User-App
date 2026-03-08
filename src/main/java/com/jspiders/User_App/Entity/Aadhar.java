package com.jspiders.User_App.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;


@Entity(name="aadhar")
@Data
public class Aadhar
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)	
	private int aadharId;
	
	@Column(unique = true, nullable = false)
	
	@NotNull(message = "Aadhar number cannot be null")
	@Digits(integer = 12, fraction = 0, message = "Aadhar number must be a 12-digit number")
	private Long aadharNumber;
	
	@NotBlank(message = "Name cannot be blank")
	private String name;
	
	@NotBlank(message = "Address cannot be blank")
	private String address;
    
	@OneToOne
	@JoinColumn(name = "user_id",unique=true)
	private User user;
}
