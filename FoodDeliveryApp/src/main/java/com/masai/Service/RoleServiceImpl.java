package com.masai.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Exception.RoleException;
import com.masai.Model.Role;
import com.masai.Repository.RoleRepo;

@Service
public class RoleServiceImpl implements RoleService{

	@Autowired
	RoleRepo rolerepo;
	
	
	@Override
	public Role addRole(Role role) throws RoleException {
		
		if(role==null) throw new RoleException("Please enter valid details");
		
		return rolerepo.save(role);
	}

	@Override
	public Role updateRole(Role role) throws RoleException {
		
		rolerepo.findById(role.getId()).orElseThrow(() -> new RoleException(" Role is not updated"));
		
		return rolerepo.save(role);
	}

	@Override
	public String removeRole(Integer roleId) throws RoleException {
	
		Role role = rolerepo.findById(roleId).orElseThrow(() -> new RoleException(" Role is not removed"));
		
		rolerepo.delete(role);
		
		return "Role with description "+role.getRoleName()+ " is deleted successfully";
	}

	@Override
	public Role viewRole(Integer id) throws RoleException {
		
		
		return rolerepo.findById(id).orElseThrow(() ->new RoleException("This role with id "+id+" does not exist"));
	}

	@Override
	public List<Role> viewALLRole() throws RoleException {
		
List<Role> list = rolerepo.findAll();
		

		if (list.isEmpty())
			throw new RoleException("No user exist in database");

		return list;
	}

}
