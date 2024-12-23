package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.core.Authentication;

import com.DAO.UserDAO;
import com.filter.JwtResponse;
import com.filter.JwtToken;
import com.model.AuthenticateUser;
import com.model.Role;

@RestController
@CrossOrigin("*")
public class AuthController {
	
	
	@Autowired
	DaoAuthenticationProvider provider;
	
	@Autowired
	UserDAO userRepository;
	
	public AuthController()
	{
		System.out.println("controller invoked");
	}
  
	
	@PostMapping("/api/auth")
	public ResponseEntity<?> authenticate(@RequestBody AuthenticateUser user)
	{
		JwtToken jwtToken=new JwtToken();
		AuthenticationManager manager=new ProviderManager(provider);
		
		Authentication authentication=manager.authenticate(new UsernamePasswordAuthenticationToken(user.getUserName(),user.getPassword()));
		
		 if(authentication.isAuthenticated())
		{
			 String username=user.getUserName();
			 String password=user.getPassword();
			 List<Role> roleList=userRepository.findByUsername(username).get().getRoles();
    		 System.out.println(user.getRole());
             ResponseEntity<?> res=new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			 for(Role r:roleList)
		     {
		    	 if(user.getRole().equals(r.getRole_name()))
		    	 {
		    		 System.out.println("Hello");
		    		 jwtToken.generateToken(username, password,user.getRole());
					  res= new ResponseEntity<JwtResponse>(new JwtResponse(jwtToken.getToken()),HttpStatus.ACCEPTED);
		    	 }
		    
		    	 return res;
		    	 
		     }
			 return res;
			 
		}
		else
		{
			return new ResponseEntity<String>(HttpStatus.FORBIDDEN);
		}
	}	
	
}