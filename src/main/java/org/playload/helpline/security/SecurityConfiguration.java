package org.playload.helpline.security;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.autoconfigure.security.SecurityProperties;

import org.springframework.context.annotation.Configuration;

import org.springframework.core.annotation.Order;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

import org.springframework.stereotype.Component;


/**
 * DOCUMENT ME!
 *
 * @author   $author$
 * @version  $Revision$, $Date$
 */
@Component @Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  @Autowired private UserDetailsService userDetailsService;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   auth  DOCUMENT ME!
   *
   * @throws  Exception  DOCUMENT ME!
   */
  @Override public void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   http  DOCUMENT ME!
   *
   * @throws  Exception  DOCUMENT ME!
   */
  /**
   * protected void configure(HttpSecurity http) throws Exception { http.authorizeRequests().antMatchers("/index.html",
   * "/home.html", "/login.html", "/", "/public/**").permitAll() .antMatchers("/index.html", "/home.html",
   * "/login.html", "/").permitAll().antMatchers("/js/**", "/modules/**", "/scripts/**",
   * "/css/**").permitAll().antMatchers("/users/**").hasAuthority("ADMIN").anyRequest()
   * .fullyAuthenticated().and().formLogin().loginPage("/login").failureUrl("/login?error").usernameParameter(
   * "email").permitAll().and().logout().logoutUrl("/logout").deleteCookies("remember-me").logoutSuccessUrl("/")
   * .permitAll().and().rememberMe(); }..lo.
   *
   * @param   http  DOCUMENT ME!
   *
   * @throws  Exception  DOCUMENT ME!
   */
  @Override protected void configure(HttpSecurity http) throws Exception {
    http.authorizeRequests().antMatchers("/", "/public/**").permitAll().antMatchers("/users/**").hasAuthority("ADMIN")
      .anyRequest().fullyAuthenticated().and().formLogin().loginPage("/login").failureUrl("/login?error")
      .usernameParameter("email").permitAll().and().logout().logoutUrl("/logout").deleteCookies("remember-me")
      .logoutSuccessUrl("/").permitAll().and().rememberMe();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter#configure(org.springframework.security.config.annotation.web.builders.HttpSecurity)
   */
  protected void configure123(HttpSecurity http) throws Exception {
    http.logout().logoutSuccessUrl("/").and().httpBasic().and().authorizeRequests().antMatchers("/index.html",
      "/home.html", "/login.html", "/").permitAll().antMatchers("/js/**", "/modules/**", "/scripts/**", "/css/**")
      .permitAll().anyRequest().authenticated().and().csrf().csrfTokenRepository(CookieCsrfTokenRepository
      .withHttpOnlyFalse());
  }


} // end class SecurityConfiguration
