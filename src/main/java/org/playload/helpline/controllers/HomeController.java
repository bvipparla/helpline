package org.playload.helpline.controllers;

import java.util.Optional;

import org.playload.helpline.service.user.UserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


/**
 * DOCUMENT ME!
 *
 * @author   $author$
 * @version  $Revision$, $Date$
 */
@Controller public class HomeController {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final Logger LOGGER = LoggerFactory.getLogger(HomeController.class);

  //~ Instance fields --------------------------------------------------------------------------------------------------

  private final UserService userService;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Creates a new HomeController object.
   *
   * @param  userService  DOCUMENT ME!
   */
  @Autowired public HomeController(UserService userService) {
    this.userService = userService;
  }

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   error  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
/*
  @RequestMapping("/")
  public String getHomePage() {
    if (LOGGER.isDebugEnabled()) {
      LOGGER.debug("Getting home page");
    }

    return "home";
  }

 */


  /**
   * DOCUMENT ME!
   *
   * @param   error  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  @RequestMapping(
    value  = "/",
    method = RequestMethod.GET
  )
  public ModelAndView getLoginPage(@RequestParam Optional<String> error) {
    if (LOGGER.isDebugEnabled()) {
      LOGGER.debug("Getting login page, error={}", error);
    }
// return new ModelAndView("users", "users", userService.getAllUsers());

    return new ModelAndView("home", "users", userService.getAllUsers());
  }


} // end class HomeController
