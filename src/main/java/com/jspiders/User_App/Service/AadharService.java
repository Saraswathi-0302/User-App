package com.jspiders.User_App.Service;

import java.util.Optional;
import com.jspiders.User_App.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jspiders.User_App.Dao.Aadhardao;
import com.jspiders.User_App.Entity.Aadhar;
import com.jspiders.User_App.Repository.UserRepository;

@Service
public class AadharService
{
  @Autowired
  private Aadhardao aadharDao;
  
  @Autowired 
  private UserRepository userRepository;
  
  public Aadhar registerAadhar(Aadhar aadhar , int userId)
  {
	  Optional<User> optional=userRepository.findById(userId);
	  if(optional.isPresent())
	  {
		  User user = optional.get();
		  
		  //Establish the bidirectional link
		  
          user.setAadhar(aadhar); // Link Aadhar to User
          aadhar.setUser(user);   // Link User to Aadhar
		
		Aadhar aadhar2=aadharDao.registerAadhar(aadhar, userId);
		return aadhar2;
	  }
	  return null;
  }
}
