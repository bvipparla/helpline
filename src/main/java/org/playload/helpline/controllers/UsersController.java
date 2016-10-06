package org.playload.helpline.controllers;

import org.playload.helpline.service.user.UserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


/**
 * DOCUMENT ME!
 *
 * @author   $author$
 * @version  $Revision$, $Date$
 */
@Controller public class UsersController {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final Logger LOGGER = LoggerFactory.getLogger(UsersController.class);

  //~ Instance fields --------------------------------------------------------------------------------------------------

  private final UserService userService;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Creates a new UsersController object.
   *
   * @param  userService  DOCUMENT ME!
   */
  @Autowired public UsersController(UserService userService) {
    this.userService = userService;
  }

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  @RequestMapping("/users")
  public ModelAndView getUsersPage() {
    if (LOGGER.isDebugEnabled()) {
      LOGGER.debug("Getting users page");
    }

    return new ModelAndView("users", "users", userService.getAllUsers());
  }


} // end class UsersController
