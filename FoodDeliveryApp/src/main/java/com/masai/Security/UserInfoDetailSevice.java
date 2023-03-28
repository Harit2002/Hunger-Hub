package com.masai.Security;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.masai.Repository.UserRepo;


@Service
public class UserInfoDetailSevice  implements UserDetailsService {
	
	@Autowired
	private UserRepo userRepo;

	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Optional<com.masai.Model.User> opt = userRepo.findByEmail(username);
		
 		
		if(opt.isPresent()) {
			com.masai.Model.User user = opt.get();
			
			List<GrantedAuthority> authorities = new ArrayList<>();
			
			authorities.add(new SimpleGrantedAuthority(user.getRole().getRoleName() )) ;
		
			
			return new User(user.getEmail(),user.getPassword(), authorities);
			
		}
		throw new UsernameNotFoundException("User with user name "+ username + " does not exist.");

	}

}
