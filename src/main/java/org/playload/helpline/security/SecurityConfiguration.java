package org.playload.helpline.security;

import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.stereotype.Component;

@Component
public class SecurityConfiguration {

	@Configuration
	@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
	@EnableWebSecurity
	protected static class SecurityConfigurations extends WebSecurityConfigurerAdapter {
		@Override
		protected void configure(HttpSecurity http) throws Exception {
			http
			.logout().logoutSuccessUrl("/")
			.and().httpBasic()
			.and().authorizeRequests()
			.antMatchers("/index.html", "/home.html", "/login.html", "/").permitAll()
			.antMatchers("/js/**", "/modules/**", "/scripts/**", "/css/**").permitAll()
			.anyRequest().authenticated()
			.and().csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());
		}
	}
}
