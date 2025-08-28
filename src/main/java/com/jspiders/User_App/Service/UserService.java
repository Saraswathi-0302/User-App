package com.jspiders.User_App.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.jspiders.User_App.Dao.Userdao;
import com.jspiders.User_App.Entity.User;
import com.jspiders.User_App.Exception.EmailNotFound;
import com.jspiders.User_App.Exception.IdNotFoundException;
import com.jspiders.User_App.Response.ResponseStructure;





@Service
public class UserService {

	@Autowired
	private Userdao userDao;

	public ResponseStructure<User> registerUser(User user) {
		User user2 = userDao.registerUser(user);
		ResponseStructure<User> structure = new ResponseStructure<User>();
		structure.setData(user2);
		structure.setTimeStamp(LocalDateTime.now());
		structure.setMessage("User Record created !!");
		structure.setStatusCode(201);
		return structure;
	}

	public ResponseStructure<Optional<User>> getUserById(int userId) {
		Optional<User> optional = userDao.getUserById(userId);
		if (optional.isPresent()) {
			ResponseStructure<Optional<User>> structure = new ResponseStructure<Optional<User>>();
			structure.setData(optional);
			structure.setTimeStamp(LocalDateTime.now());
			structure.setMessage("User Record found !!");
			structure.setStatusCode(302);
			return structure;
		} else {
			throw new IdNotFoundException("Invalid Id");
		}
	}

	public ResponseStructure<List<User>> getAllUser() {
		List<User> allUser = userDao.getAllUser();
		ResponseStructure<List<User>> structure = new ResponseStructure<List<User>>();
		structure.setData(allUser);
		structure.setTimeStamp(LocalDateTime.now());
		structure.setMessage("All User Record found !!");
		structure.setStatusCode(302);
		return structure;
	}

	public ResponseStructure<User> updateUser(User user, int userId) {
		User user2 = userDao.updateUser(user, userId);
		ResponseStructure<User> structure = new ResponseStructure<User>();
		structure.setData(user2);
		structure.setTimeStamp(LocalDateTime.now());
		structure.setMessage("User Record updated !!");
		structure.setStatusCode(200);
		return structure;
	}

	public ResponseStructure<String> deleteUser(int userId) {
		String message = userDao.deleteUser(userId);
		ResponseStructure<String> structure = new ResponseStructure<String>();
		structure.setData(message);
		structure.setTimeStamp(LocalDateTime.now());
		structure.setMessage("User Record deleted !!");
		structure.setStatusCode(200);
		return structure;
	}

	public ResponseStructure<Page<User>> getUserByPage(int pageNo) {
		Page<User> page = userDao.getUserByPage(pageNo);
		ResponseStructure<Page<User>> structure = new ResponseStructure<Page<User>>();
		structure.setData(page);
		structure.setTimeStamp(LocalDateTime.now());
		structure.setMessage("User Record found !!");
		structure.setStatusCode(302);
		return structure;
	}

	public ResponseStructure<Optional<User>> login(String email, String password) {
		Optional<User> optional = userDao.login(email);
		if (optional.isPresent()) {
//			String userEmail = optional.get().getUserEmail();//db email
			String userPassword = optional.get().getUserPassword();// db pass
			if (password.equals(userPassword)) {
				ResponseStructure<Optional<User>> structure = new ResponseStructure<Optional<User>>();
				structure.setData(optional);
				structure.setTimeStamp(LocalDateTime.now());
				structure.setMessage("User login success Welcome !!");
				structure.setStatusCode(200);
				return structure;
			}
		}
		throw new EmailNotFound("Invalid Email try again!!");
	}
}





/*@Service
public class UserService {

	@Autowired
	private Userdao userDao;

	public ResponseStructure<User> registerUser(User user) {
		User user2 = userDao.registerUser(user);
		ResponseStructure<User> structure=new ResponseStructure<User>();
		structure.setData(user2);
		structure.setTimeStamp(LocalDateTime.now());
		structure.setMessage("User Record Created Successfully !!!");
		structure.setStatusCode(201);
		return structure;
	}

	public ResponseStructure<Optional<User>> getUserById(int userId) {
		Optional<User> optional=userDao.getUserById(userId);
		if(optional.isPresent()) {
			ResponseStructure<Optional<User>> structure=new ResponseStructure<Optional<User>>();
			structure.setData(optional);
			structure.setTimeStamp(LocalDateTime.now());
			structure.setMessage("User Record Found Successfully !!!");
			structure.setStatusCode(302);
			return structure;
		}else {
			throw new IllegalArgumentException("Invalid Id");
		}
	}

	public ResponseStructure<List<User>> getAllUser() {
		List<User> allUser = userDao.getAllUser();
		ResponseStructure<List<User>> structure=new ResponseStructure<List<User>>();
		structure.setData(allUser);
		structure.setTimeStamp(LocalDateTime.now());
		structure.setMessage("All User Record Found Successfully !!!");
		structure.setStatusCode(302);
		return structure;
		
	}

	public ResponseStructure<User> updateUser(User user,int userId) {
		User updateUser = userDao.updateUser(user,userId);
		ResponseStructure<User> structure=new ResponseStructure<User>();
		structure.setData(updateUser);
		structure.setTimeStamp(LocalDateTime.now());
		structure.setMessage("User Record Updated Successfully !!!");
		structure.setStatusCode(200);
		return structure;
		
	}

	public ResponseStructure<String> deleteUser(int userId) {
		String message = userDao.deleteUser(userId);
		ResponseStructure<String> structure=new ResponseStructure<String>();
		structure.setData(message);
		structure.setTimeStamp(LocalDateTime.now());
		structure.setMessage("User Record Deleted Successfully !!!");
		structure.setStatusCode(200);
		return structure;
		
	}

	
	public ResponseStructure<String> deleteAllUser() {
	    String message = userDao.deleteAllUser();
	    ResponseStructure<String> structure = new ResponseStructure<>();
	    structure.setData(message);
	    structure.setTimeStamp(LocalDateTime.now());
	    structure.setMessage("All User Records Deleted Successfully !!!");
	    structure.setStatusCode(200);
	    return structure;
	}


	public ResponseStructure<Page<User>> getUserByPage(int pageNo) {
		Page<User> page = userDao.getUserByPage(pageNo);
		ResponseStructure<Page<User>> structure=new ResponseStructure<Page<User>>();
		structure.setData(page);
		structure.setTimeStamp(LocalDateTime.now());
		structure.setMessage("User Record Found Successfully !!!");
		structure.setStatusCode(302);
		return structure;
	}

public ResponseStructure<Optional<User>>login(String email,String password)
{
	Optional<User> optional=userDao.login(email);
	if(optional.isPresent())
	{
		//String userEmail=optional.get().getUserEmail();//db email
		String userPassword=optional.get().getUserPassword();//db pwd
		if(password.equals(userPassword))
		{
			ResponseStructure<Optional<User>> structure=new ResponseStructure<Optional<User>>();
			structure.setData(optional);
			structure.setTimeStamp(LocalDateTime.now());
			structure.setMessage("User Login Success Welcome!!");
			structure.setStatusCode(200);
			return structure;
		}
	}
	
	throw new EmailNotFound("Invalid Email Id, Please Try Again");
}

}*/
