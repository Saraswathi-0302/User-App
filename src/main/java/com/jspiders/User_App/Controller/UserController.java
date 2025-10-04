package com.jspiders.User_App.Controller;


import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jspiders.User_App.Entity.User;
import com.jspiders.User_App.Response.ResponseStructure;
import com.jspiders.User_App.Service.UserService;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/register")
	public ResponseEntity<?> registerUser(@Valid @RequestBody User user) {
		ResponseStructure<User> structure = userService.registerUser(user);
		return new ResponseEntity<>(structure, HttpStatus.CREATED);
	}

	@GetMapping("/getUser")
	public ResponseEntity<?> getUserById(@RequestParam int userId) {
		ResponseStructure<Optional<User>> structure = userService.getUserById(userId);
		return new ResponseEntity<>(structure, HttpStatus.FOUND);
	}

	@GetMapping("/getAllUser")
	public ResponseEntity<?> getAllUser() {
		ResponseStructure<List<User>> structure = userService.getAllUser();
		return new ResponseEntity<>(structure, HttpStatus.FOUND);
	}

	@PutMapping("/update") // localhost:8080/user/update?userId=id
	public ResponseEntity<?> updateUser(@RequestBody User user, @RequestParam int userId) {
		ResponseStructure<User> structure = userService.updateUser(user, userId);
		return new ResponseEntity<>(structure, HttpStatus.OK);
	}

	@DeleteMapping("/delete") // localhost:8080/user/delete?userId=id
	public ResponseEntity<?> deleteUser(@RequestParam int userId) {
		ResponseStructure<String> structure = userService.deleteUser(userId);
		return new ResponseEntity<>(structure, HttpStatus.OK);
	}

	@GetMapping("/getUserPage") // localhost:8080/user/getUserPage?pageNo=2
	public ResponseEntity<?> getUserByPage(@RequestParam int pageNo) {
		ResponseStructure<Page<User>> structure = userService.getUserByPage(pageNo);
		return new ResponseEntity<>(structure, HttpStatus.FOUND);
	}

	@PostMapping("/login") // localhost:8080/user/login
	public ResponseEntity<?> login(@RequestBody User user) {
		ResponseStructure<Optional<User>> structure = userService.login(user.getUserEmail(), user.getUserPassword());
		return new ResponseEntity<>(structure, HttpStatus.OK);
	}

}




/*@RestController
@RequestMapping("/user")
public class UserController
{
	@Autowired
	private UserService userservice;


	 // Register User
	@PostMapping("/register")

	public ResponseEntity<?> registerUser(@RequestBody User user)
	{

		ResponseStructure<User> structure=userservice.registerUser(user);
		return new ResponseEntity<> (structure,HttpStatus.CREATED);
	}

	//FindById(Optional will return)

	@GetMapping("/getUser")

	public ResponseEntity<?> getUserById(@RequestParam int userId)
	{
		ResponseStructure <Optional<User>> structure=userservice.getUserById(userId);
		return new ResponseEntity<>(structure,HttpStatus.FOUND);
	}

	//find all(list of object will return)

	@GetMapping("/getAllUser")

	public ResponseEntity<?> getAllUser()
	{
		ResponseStructure <List<User>> structure=userservice.getAllUser();
		return new ResponseEntity<>(structure,HttpStatus.FOUND);

	}
	
	 // Update User
	
	@PutMapping("/update")//localhost:8080/user/update?userId=id

	public ResponseEntity<?> updateUser(@RequestBody User user,@RequestParam int userId)
	{
		ResponseStructure<User> structure=userservice.updateUser(user,userId);
		return new ResponseEntity<>(structure,HttpStatus.OK);
	}

	//Delete User
	@DeleteMapping("/delete")//localhost:8080/user/delete?userId=2

	public ResponseEntity<?> deleteUser(@RequestParam int userId)
	{
		ResponseStructure<String> structure=userservice.deleteUser(userId);
		return new ResponseEntity<>(structure,HttpStatus.OK);
	}

	//delete All User

	@DeleteMapping("/delete")//localhost:8080/user/delete?userId=2

	public ResponseEntity<?> deleteAllUser()
	{
		ResponseStructure<String> structure=userservice.deleteAllUser();
		return new ResponseEntity<>(structure,HttpStatus.OK);
	}
	
	// Pagination

	@GetMapping("/getUserPage")//localhost:8080/user/getUserPage?pageNo=2

	public ResponseEntity<?> getUserByPage(@RequestParam int pageNo)
	{
		ResponseStructure<Page<User>> structure=userservice.getUserByPage(pageNo);
		return  new ResponseEntity<>(structure, HttpStatus.FOUND);

	}
	
	// Login using query params

	@GetMapping("/login")//localhost:8080/user/login?email=""&password=""
	public ResponseEntity<?> login(@RequestParam String email, String password)
	{
		ResponseStructure<Optional<User>> structure =userservice.login(email,password);
		return new ResponseEntity<>(structure,HttpStatus.FOUND);
	}
	
	 // Login using request body

	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody User u)
	{
		ResponseStructure<Optional<User>> structure=userservice.login(u.getUserEmail(),u.getUserPassword());
		return new ResponseEntity<>(structure,HttpStatus.OK);
	}
	
	//Validation 
}*/


