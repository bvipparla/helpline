package org.playload.helpline.service.user;

import java.util.Collection;
import java.util.Optional;

import org.playload.helpline.domain.User;
import org.playload.helpline.domain.UserCreateForm;
import org.playload.helpline.repo.UserRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Sort;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.springframework.stereotype.Service;


/**
 * DOCUMENT ME!
 *
 * @author   $author$
 * @version  $Revision$, $Date$
 */
@Service public class UserServiceImpl implements UserService {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

  //~ Instance fields --------------------------------------------------------------------------------------------------

  private final UserRepository userRepository;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Creates a new UserServiceImpl object.
   *
   * @param  userRepository  DOCUMENT ME!
   */
  @Autowired public UserServiceImpl(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  org.playload.helpline.service.user.UserService#create(org.playload.helpline.domain.UserCreateForm)
   */
  @Override public User create(UserCreateForm form) {
    User user = new User();
    user.setEmail(form.getEmail());
    user.setPasswordHash(new BCryptPasswordEncoder().encode(form.getPassword()));
    user.setRole(form.getRole());

    return userRepository.save(user);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  org.playload.helpline.service.user.UserService#getAllUsers()
   */
  @Override public Collection<User> getAllUsers() {
    if (LOGGER.isDebugEnabled()) {
      LOGGER.debug("Getting all users");
    }

    return userRepository.findAll(new Sort("email"));
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  org.playload.helpline.service.user.UserService#getUserByEmail(java.lang.String)
   */
  @Override public Optional<User> getUserByEmail(String email) {
    if (LOGGER.isDebugEnabled()) {
      LOGGER.debug("Getting user by email={}", email.replaceFirst("@.*", "@***"));
    }

    return userRepository.findOneByEmail(email);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  org.playload.helpline.service.user.UserService#getUserById(long)
   */
  @Override public Optional<User> getUserById(long id) {
    if (LOGGER.isDebugEnabled()) {
      LOGGER.debug("Getting user={}", id);
    }

    return Optional.ofNullable(userRepository.findOne(id));
  }

} // end class UserServiceImpl
