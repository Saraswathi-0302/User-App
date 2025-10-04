package com.jspiders.User_App.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jspiders.User_App.Entity.Aadhar;
import com.jspiders.User_App.Service.AadharService;



@RestController
@RequestMapping("/aadhar")
public class AadharController 
{
@Autowired
private AadharService aadharservice;

@PostMapping("/register")
public ResponseEntity<?> registeraadhar(@RequestBody Aadhar aadhar, @RequestParam int userId)
{
	return  new ResponseEntity<Aadhar>(aadharservice.registerAadhar(aadhar, userId),HttpStatus.CREATED);
}
}
