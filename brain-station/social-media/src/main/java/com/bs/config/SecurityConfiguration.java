package com.bs.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@Profile("development")
public class SecurityConfiguration
{
	
	@Autowired
	private SocialMediaUserDetailsService socialMediaUserDetailsService;
	
	// Authentication
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception
	{
		auth.userDetailsService(socialMediaUserDetailsService);
	}
	
	// Authorization
	@Configuration   
	@Order(1)
	@Profile("development")
	public static class FormLoginWebSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter 
	{	
		@Override
		public void configure(HttpSecurity http) throws Exception
		{
			http.antMatcher("/**").authorizeRequests().antMatchers("/home.html", "/newUser.html", "/success", "/addUser").permitAll()
						.anyRequest().hasRole("USER")
						
						.and()
						
						.formLogin().loginPage("/website/login.jsp")
									.failureUrl("/website/login.jsp?error=1")
									.loginProcessingUrl("/website/login")
									.defaultSuccessUrl("/home.html", true)
									.permitAll()
									.and()
									.logout()
									.logoutSuccessUrl("/home.html").and()
									.csrf()
									.disable();
		}
	}
}
