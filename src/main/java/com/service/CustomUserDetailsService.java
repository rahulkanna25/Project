package com.service;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.DAO.*;
import com.model.UserEntity;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    
	@Autowired
    private  UserDAO userRepository;

    
    public CustomUserDetailsService()
    {
   System.out.println("user service created");
    }
    
    public Long getCount() 
    {
    	return userRepository.count();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
      List<UserEntity> userlist=userRepository.findAll();
      for(UserEntity e:userlist)
      {
    	  System.out.println(e.getUsername());
      }
    	UserEntity user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
  Hibernate.initialize(user.getRoles());
    	
        List<SimpleGrantedAuthority> authorities = user.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority(role.getRole_name()))
                .collect(Collectors.toList());

        return new User(user.getUsername(), user.getPassword(), authorities);
 
    }
}