package org.playload.helpline.repo;

import java.util.Optional;

import org.playload.helpline.domain.User;

import org.springframework.data.jpa.repository.JpaRepository;


/**
 * DOCUMENT ME!
 *
 * @author   $author$
 * @version  $Revision$, $Date$
 */
public interface UserRepository extends JpaRepository<User, Long> {
  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   email  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  Optional<User> findOneByEmail(String email);
}
