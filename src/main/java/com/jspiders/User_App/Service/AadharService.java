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
		//Check aadhar number uniqueness

		if(aadharDao.existsByAadharNumber(aadhar.getAadharNumber())){
			throw new IllegalArgumentException("Aadhar number already exists");
		}

		//Check User exists
		Optional<User> optional=userRepository.findById(userId);

		if(optional.isEmpty())
		{
			throw new IllegalArgumentException("User not found with id: "+ userId);
		}
		User user = optional.get();

        //Establish bidirectional relationship
		user.setAadhar(aadhar); 
		aadhar.setUser(user);   

		Aadhar savedAadhar=aadharDao.registerAadhar(aadhar);
		return savedAadhar;
	}


}
