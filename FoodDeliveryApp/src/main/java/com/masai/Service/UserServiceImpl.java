package com.masai.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Exception.UserException;
import com.masai.Model.User;
import com.masai.Repository.RoleRepo;
import com.masai.Repository.UserRepo;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserRepo userRepo;
	
	@Autowired
	RoleRepo roleRepo;
	

	@Override
	public User regiserUser(User user) {
		return userRepo.save(user);
		
	}


	@Override
	public User viewById(Integer id) throws UserException {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public User viewByEmail(String email) throws UserException {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public User updateDetails(User user) throws UserException {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public String deleteUser(Integer id) throws UserException {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<User> viewAllUser(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
	


}
