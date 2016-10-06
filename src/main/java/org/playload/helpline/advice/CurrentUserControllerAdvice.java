package org.playload.helpline.advice;

import org.playload.helpline.domain.CurrentUser;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.security.core.Authentication;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;


/**
 * DOCUMENT ME!
 *
 * @author   $author$
 * @version  $Revision$, $Date$
 */
@ControllerAdvice public class CurrentUserControllerAdvice {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final Logger LOGGER = LoggerFactory.getLogger(CurrentUserControllerAdvice.class);

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   authentication  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  @ModelAttribute("currentUser")
  public CurrentUser getCurrentUser(Authentication authentication) {
    return (authentication == null) ? null : (CurrentUser) authentication.getPrincipal();
  }


}
