package org.playload.helpline.domain.validator;

import org.playload.helpline.domain.UserCreateForm;
import org.playload.helpline.service.user.UserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;


/**
 * DOCUMENT ME!
 *
 * @author   $author$
 * @version  $Revision$, $Date$
 */
@Component public class UserCreateFormValidator implements Validator {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final Logger LOGGER = LoggerFactory.getLogger(UserCreateFormValidator.class);

  //~ Instance fields --------------------------------------------------------------------------------------------------

  private final UserService userService;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Creates a new UserCreateFormValidator object.
   *
   * @param  userService  DOCUMENT ME!
   */
  @Autowired public UserCreateFormValidator(UserService userService) {
    this.userService = userService;
  }

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  org.springframework.validation.Validator#supports(java.lang.Class)
   */
  @Override public boolean supports(Class<?> clazz) {
    return clazz.equals(UserCreateForm.class);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  org.springframework.validation.Validator#validate(java.lang.Object, org.springframework.validation.Errors)
   */
  @Override public void validate(Object target, Errors errors) {
    if (LOGGER.isDebugEnabled()) {
      LOGGER.debug("Validating {}", target);
    }

    UserCreateForm form = (UserCreateForm) target;
    validatePasswords(errors, form);
    validateEmail(errors, form);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  private void validateEmail(Errors errors, UserCreateForm form) {
    if (userService.getUserByEmail(form.getEmail()).isPresent()) {
      errors.reject("email.exists", "User with this email already exists");
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  private void validatePasswords(Errors errors, UserCreateForm form) {
    if (!form.getPassword().equals(form.getPasswordRepeated())) {
      errors.reject("password.no_match", "Passwords do not match");
    }
  }
} // end class UserCreateFormValidator
