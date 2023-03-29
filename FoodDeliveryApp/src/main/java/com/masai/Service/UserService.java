package com.masai.Service;

import java.util.List;

import com.masai.Exception.UserException;
import com.masai.Model.User;

public interface UserService {
	public User regiserUser(User user) throws UserException;
	public User viewById(Integer id) throws UserException;
	public User viewByEmail(String email) throws UserException;
	public User updateDetails(User user, Integer id) throws UserException;;
	public String deleteUser(Integer id) throws UserException;
	public List<User> viewAllUser() throws UserException;	
}
