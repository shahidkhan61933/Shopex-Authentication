package com.auth.webservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.auth.webservice.service.impl.JWTUserDetailsService;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter   {
	
	@Bean
	protected BCryptPasswordEncoder  getPasswordEncoder() {
		 return new BCryptPasswordEncoder();
	}
	
    @Bean
    public UserDetailsService userDetailsService() {
        return new JWTUserDetailsService();
    }

    // pre autherization
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/api/product/**").permitAll()
		.antMatchers("/authenticate").permitAll()
		.antMatchers("/api/users/**").permitAll()
		.antMatchers("/api/orders/**").hasAnyAuthority("ADMIN", "VENDOR",  "CREATOR")
		.antMatchers("/api/customers/**").hasAnyAuthority("USER")
		.antMatchers("/api/employees/**").hasAnyAuthority("VENDOR")
		.antMatchers("/api/employee/**").hasAnyAuthority("ADMIN")
		.anyRequest().authenticated()
		.and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		http.csrf().disable();
		http.formLogin();
		http.httpBasic();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticationProvider());
	}

	//authentication builder read user from db.
	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(userDetailsService());
		authProvider.setPasswordEncoder(getPasswordEncoder());
		return authProvider;
	}

}
