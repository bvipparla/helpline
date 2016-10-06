package org.playload.helpline.controllers;

import java.security.Principal;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * DOCUMENT ME!
 *
 * @author   $author$
 * @version  $Revision$, $Date$
 */
@RestController public class UserLoginController {
  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   user  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  @RequestMapping("/user")
  public Principal user(Principal user) {
    return user;
  }
}
