package com.jspiders.User_App.Entity;

import org.springframework.data.annotation.Id;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity

public class User
{
@Id 
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int userId;
private String userName;
private String userEmail;
private String userPassword;
private String userContact;
private String address;
}