package com.jspiders.User_App.Dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jspiders.User_App.Entity.Aadhar;
//import com.jspiders.User_App.Entity.Aadhar;
import com.jspiders.User_App.Repository.AadharRepository;

@Repository
public class Aadhardao 
{
	@Autowired
	private AadharRepository aadharRepository;

  public Aadhar registerAadhar(Aadhar aadhar, int userId)
	{
		Aadhar save=aadharRepository.save(aadhar);
		return save;
	}

}
