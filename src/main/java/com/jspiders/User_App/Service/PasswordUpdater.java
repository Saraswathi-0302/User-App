package com.jspiders.User_App.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.jspiders.User_App.Dao.Userdao;
import com.jspiders.User_App.Entity.User;

@Component
public class PasswordUpdater implements CommandLineRunner
{
	 @Autowired
	    private Userdao userDao;

	    @Autowired
	    private PasswordEncoder passwordEncoder;

	    @Override
	    public void run(String... args) throws Exception {
	        // Fetch all users
	        List<User> allUsers = userDao.getAllUser();

	        for (User user : allUsers) {
	            String plainPassword = user.getUserPassword();

	            // Skip already hashed passwords
	            if (plainPassword != null && !plainPassword.startsWith("$2")) {
	                String hashed = passwordEncoder.encode(plainPassword);
	                user.setUserPassword(hashed);
	                userDao.updateUser(user, user.getUserId());
	            }
	        }

	        System.out.println("All plaintext passwords have been hashed!");
	    }
	}

