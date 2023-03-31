package com.masai.Service;

import java.util.List;

import com.masai.Exception.RoleException;
import com.masai.Model.Role;

public interface RoleService {
	
	public Role addRole(Role role)throws  RoleException;
	public Role updateRole(Role role) throws RoleException;
	public String removeRole(Integer roleId) throws RoleException;
	public Role viewRole(Integer id) throws RoleException;
	public List<Role> viewALLRole() throws RoleException;
	
}
