package com.jspiders.User_App.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;


@Entity(name="aadhar")
@Data
public class Aadhar
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)	
	private int adharid;
	private long adharnumber;
	private String name;
	private String address;
    
	@OneToOne
	@JoinColumn(name = "user_id")
	private User user;
}
