package com.company.oziva.customer.service;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.company.oziva.customer.entity.CustomUserDetails;
import com.company.oziva.customer.entity.UsernameAndPassword;
import com.company.oziva.customer.exception.UserNotFoundException;
import com.company.oziva.customer.repo.UsernameAndPasswordRepo;

@Service
public class CustomeUserDetailService implements UserDetailsService{
	
	private PasswordEncoder passwordEncoder;
	
	public CustomeUserDetailService(PasswordEncoder passwordEncoder) {
		this.passwordEncoder = passwordEncoder;
	}

	private static final Logger log = LoggerFactory.getLogger(CustomeUserDetailService.class);
	
	@Autowired
	private UsernameAndPasswordRepo usernameAndPasswordRepo;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		log.info("loadByUSername method start");
		
		
		UsernameAndPassword user = usernameAndPasswordRepo.findByUserName(username);
		
		
		if(user == null) {
			
			throw new UserNotFoundException("User not found in database");
			
		}
		
		log.info("Username: "+user.getUserName()+" and database password: "+user.getPassword());
		
		log.info("loadByUSername method end");
		
//		return CustomUserDetails
//                .builder()
//                .username(user.getUserName())
//                .password(user.getPassword())
//                .build();
		User user1 = new User(
                user.getUserName(),
                user.getPassword(),
                new ArrayList<>()
        );
		
		log.info("Username in UserDetails: "+user1.getUsername()+" and database password: "+user1.getPassword());
		
		return user1;
       
		
		 
	}

}
