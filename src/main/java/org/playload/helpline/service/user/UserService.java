package org.playload.helpline.service.user;

import java.util.Collection;
import java.util.Optional;

import org.playload.helpline.domain.User;
import org.playload.helpline.domain.UserCreateForm;


/**
 * DOCUMENT ME!
 *
 * @author   $author$
 * @version  $Revision$, $Date$
 */
public interface UserService {
  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   form  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  User create(UserCreateForm form);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  Collection<User> getAllUsers();

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   email  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  Optional<User> getUserByEmail(String email);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   id  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  Optional<User> getUserById(long id);

} // end interface UserService
