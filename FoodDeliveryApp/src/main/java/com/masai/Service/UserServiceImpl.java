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
	public User regiserUser(User user) throws UserException {
		if (user == null)
			throw new UserException("Please enter valid user object");
		return userRepo.save(user);

	}

	@Override
	public User viewById(Integer id) throws UserException {
		User user = userRepo.findById(id).orElseThrow(() -> new UserException("Please enter valid user id"));
		return user;
	}

	@Override
	public User updateDetails(User user, Integer id) throws UserException {
		userRepo.findById(id).orElseThrow(() -> new UserException("Please enter valid user id"));
		return userRepo.save(user);
	}

	@Override
	public String deleteUser(Integer id) throws UserException {
		User user = userRepo.findById(id).orElseThrow(() -> new UserException("Please enter valid user id"));
		userRepo.delete(user);

		return "User deleted successfully";
	}

	@Override
	public List<User> viewAllUser() throws UserException {
		List<User> list = userRepo.findAll();

		if (list.isEmpty())
			throw new UserException("No user exist in database");

		return list;

	}

}
