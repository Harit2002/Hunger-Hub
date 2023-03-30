package com.masai.Security;

import java.io.IOException;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.crypto.SecretKey;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class JwtTokenGenratorFilter extends OncePerRequestFilter {

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		
		if(authentication != null) {
			SecretKey key = Keys.hmacShaKeyFor(Decoders.BASE64.decode(SecurityConstant.JWT_KEY));
			
			String jwt = Jwts.builder()
					.setIssuer("Harit")
					.setSubject("JWT Token")
					.claim("username", authentication.getName())
					.claim("authorities", getAuthorities(authentication.getAuthorities()))
					.setIssuedAt(new Date())
					.setExpiration(new Date(new Date().getTime()+30000000))
					.signWith(key, SignatureAlgorithm.HS256).compact();
			
			response.setHeader(SecurityConstant.JWT_HEADER, jwt);
			
			System.out.print(jwt);
		}
		
		filterChain.doFilter(request, response);
	}
	
	
	

    private String getAuthorities(Collection<? extends GrantedAuthority> collection) {
        
    	Set<String> authoritiesSet = new HashSet<>();
        
        for (GrantedAuthority authority : collection) {
            authoritiesSet.add(authority.getAuthority());
        }
        return String.join(",", authoritiesSet);
   
    
    }
	

	@Override
	protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException{
		return !request.getServletPath().equals("/users/login" );
	}
	

}


