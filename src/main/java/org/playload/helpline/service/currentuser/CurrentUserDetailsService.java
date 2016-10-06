package org.playload.helpline.service.currentuser;

import org.playload.helpline.domain.CurrentUser;
import org.playload.helpline.domain.User;
import org.playload.helpline.service.user.UserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import org.springframework.stereotype.Service;


/**
 * DOCUMENT ME!
 *
 * @author   $author$
 * @version  $Revision$, $Date$
 */
@Service public class CurrentUserDetailsService implements UserDetailsService {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final Logger LOGGER = LoggerFactory.getLogger(CurrentUserDetailsService.class);

  //~ Instance fields --------------------------------------------------------------------------------------------------

  private final UserService userService;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Creates a new CurrentUserDetailsService object.
   *
   * @param  userService  DOCUMENT ME!
   */
  @Autowired public CurrentUserDetailsService(UserService userService) {
    this.userService = userService;
  }

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  org.springframework.security.core.userdetails.UserDetailsService#loadUserByUsername(java.lang.String)
   */
  @Override public CurrentUser loadUserByUsername(String email) throws UsernameNotFoundException {
    if (LOGGER.isDebugEnabled()) {
      LOGGER.debug("Authenticating user with email={}", email.replaceFirst("@.*", "@***"));
    }

    User user = userService.getUserByEmail(email).orElseThrow(() ->
          new UsernameNotFoundException(String.format("User with email=%s was not found", email)));

    return new CurrentUser(user);
  }

} // end class CurrentUserDetailsService
