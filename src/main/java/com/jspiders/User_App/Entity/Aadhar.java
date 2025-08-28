package com.jspiders.User_App.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
	@OneToMany
	private User user;
}
