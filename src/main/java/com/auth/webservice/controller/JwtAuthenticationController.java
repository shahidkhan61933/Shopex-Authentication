package com.auth.webservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.auth.webservice.security.JWTUser;
import com.auth.webservice.security.JWTResponse;
import com.auth.webservice.security.JWTTokenUtil;
import com.auth.webservice.service.impl.JWTUserDetailsService;

@RestController
public class JwtAuthenticationController {
	
	@Autowired
	private JWTUserDetailsService jwtUserSrv;
	
	@Autowired
	private JWTTokenUtil  jwtToken;
	
	@PostMapping("/authenticate")
	public ResponseEntity<?> createAuthToken(@RequestBody JWTUser user) throws Exception{
		String token = null;
		UserDetails userDetails = jwtUserSrv.loadUserByUsername(user.getUsername());
		if(userDetails!=null ) {
			token = jwtToken.generateToken(userDetails);
			return ResponseEntity.ok(new JWTResponse(token));
		}
		throw new UsernameNotFoundException("User not found !");
	}
	

}
