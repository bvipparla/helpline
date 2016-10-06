package org.playload.helpline.controllers;

import java.util.NoSuchElementException;

import javax.validation.Valid;

import org.playload.helpline.domain.UserCreateForm;
import org.playload.helpline.domain.validator.UserCreateFormValidator;
import org.playload.helpline.service.user.UserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.dao.DataIntegrityViolationException;

import org.springframework.security.access.prepost.PreAuthorize;

import org.springframework.stereotype.Controller;

import org.springframework.validation.BindingResult;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


/**
 * DOCUMENT ME!
 *
 * @author   $author$
 * @version  $Revision$, $Date$
 */
@Controller public class UserController {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

  //~ Instance fields --------------------------------------------------------------------------------------------------

  private final UserCreateFormValidator userCreateFormValidator;
  private final UserService             userService;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Creates a new UserController object.
   *
   * @param  userService              DOCUMENT ME!
   * @param  userCreateFormValidator  DOCUMENT ME!
   */
  @Autowired public UserController(UserService userService, UserCreateFormValidator userCreateFormValidator) {
    this.userService             = userService;
    this.userCreateFormValidator = userCreateFormValidator;
  }

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  @PreAuthorize("hasAuthority('ADMIN')")
  @RequestMapping(
    value  = "/user/create",
    method = RequestMethod.GET
  )
  public ModelAndView getUserCreatePage() {
    if (LOGGER.isDebugEnabled()) {
      LOGGER.debug("Getting user create form");
    }

    return new ModelAndView("user_create", "form", new UserCreateForm());
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   id  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  @PreAuthorize("@currentUserServiceImpl.canAccessUser(principal, #id)")
  @RequestMapping("/user/{id}")
  public ModelAndView getUserPage(@PathVariable Long id) {
    if (LOGGER.isDebugEnabled()) {
      LOGGER.debug("Getting user page for user={}", id);
    }

    return new ModelAndView("user", "user", userService.getUserById(id).orElseThrow(() ->
            new NoSuchElementException(String.format("User=%s not found", id))));
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   form           DOCUMENT ME!
   * @param   bindingResult  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  @PreAuthorize("hasAuthority('ADMIN')")
  @RequestMapping(
    value  = "/user/create",
    method = RequestMethod.POST
  )
  public String handleUserCreateForm(@ModelAttribute("form")
    @Valid UserCreateForm form, BindingResult bindingResult) {
    if (LOGGER.isDebugEnabled()) {
      LOGGER.debug("Processing user create form={}, bindingResult={}", form, bindingResult);
    }

    if (bindingResult.hasErrors()) {
      // failed validation
      return "user_create";
    }

    try {
      userService.create(form);
    } catch (DataIntegrityViolationException e) {
      // probably email already exists - very rare case when multiple admins are adding same user
      // at the same time and form validation has passed for more than one of them.
      LOGGER.warn("Exception occurred when trying to save the user, assuming duplicate email", e);
      bindingResult.reject("email.exists", "Email already exists");

      return "user_create";
    }

    // ok, redirect
    return "redirect:/users";
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  binder  DOCUMENT ME!
   */
  @InitBinder("form")
  public void initBinder(WebDataBinder binder) {
    binder.addValidators(userCreateFormValidator);
  }

} // end class UserController
