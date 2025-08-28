package com.jspiders.User_App.Dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import com.jspiders.User_App.Entity.User;
import com.jspiders.User_App.Repository.UserRepository;




@Repository
public class Userdao {

	@Autowired
	private UserRepository userRepository;

	public User registerUser(User user) {
		User user2 = userRepository.save(user);
		return user2;
	}

	public Optional<User> getUserById(int userId) {
		return userRepository.findById(userId);
	}

	public List<User> getAllUser() {
		return userRepository.findAll();
	}

	public User updateUser(User user, int userId) {
		Optional<User> optional = userRepository.findById(userId);
		if (optional.isPresent()) {
			user.setUserId(userId);
			return userRepository.save(user);
		} else {
			throw new IllegalArgumentException("Invalid User Id");
		}

	}

	public String deleteUser(int userId) {
		Optional<User> optional = userRepository.findById(userId);
		if (optional.isPresent()) {
			User user = optional.get();
			userRepository.delete(user);
			// userRepository.deleteById(userId);
			return "user data deleted";
		} else {
			throw new IllegalArgumentException("Invalid User Id");
		}
	}

	public Page<User> getUserByPage(int pageNo) {
		PageRequest pageReqest = PageRequest.of(pageNo, 10);
		Page<User> page = userRepository.findAll(pageReqest);
		return page;
	}

	public Optional<User> login(String email) {
		return userRepository.findByuserEmail(email);
	}
}




/*@Repository
public class Userdao {

	@Autowired
	private UserRepository userRepository;

	public User registerUser(User user) 
	{
		User user2= userRepository.save(user);
		return user2;
	}
	//option1 
	 public Optional<User> getUserById(int userId)
	{
	  Optional<User> optional= userRepository.findById(userId);
	  return optional.get();
	}

	//option2
	public Optional<User> getUserById(int userId)
	{
		return userRepository.findById(userId);

	}

	public List<User> getAllUser() {
		return userRepository.findAll();

	}
	
	//update
	
	public User  updateUser(User user, int userId) 
	{
		Optional<User> optional=userRepository.findById(userId);
		if(optional.isPresent())
		{
			user.setUserId(userId);
		       return userRepository.save(user);
		}
		else
		{
			throw new IllegalArgumentException("Invalid User Id");
		}
	}
		//delete
		
		public String deleteUser(int userId)
		{
			Optional<User> optional=userRepository.findById(userId);
			
			if(optional.isPresent())
				
			{
				User user=optional.get();
				
				userRepository.delete(user);

			     // userRepository.deleteById(userId);
				return "User Data Deleted ";
			}
			else
			{
				throw new IllegalArgumentException("Invalid User Id");
			}
		
	}

		public String deleteAllUser() 
		{
			userRepository.deleteAll();
			return "Delete All User Data's";
		}

		public Page getUserByPage(int pageNo) {
			PageRequest pageRequest = PageRequest.of(pageNo, 10);
			Page page = userRepository.findAll(pageRequest);
			return page;
			
		}

	public Optional<User> login(String email )
	{
		return userRepository.findByuserEmail(email);
	}
	
}
*/
