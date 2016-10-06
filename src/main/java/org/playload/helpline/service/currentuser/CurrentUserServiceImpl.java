package org.playload.helpline.service.currentuser;

import org.playload.helpline.domain.CurrentUser;
import org.playload.helpline.domain.Role;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;


/**
 * DOCUMENT ME!
 *
 * @author   $author$
 * @version  $Revision$, $Date$
 */
@Service public class CurrentUserServiceImpl implements CurrentUserService {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final Logger LOGGER = LoggerFactory.getLogger(CurrentUserDetailsService.class);

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   currentUser  DOCUMENT ME!
   * @param   userId       DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  @Override public boolean canAccessUser(CurrentUser currentUser, Long userId) {
    if (LOGGER.isDebugEnabled()) {
      LOGGER.debug("Checking if user={} has access to user={}", currentUser, userId);
    }

    return (currentUser != null)
      && ((currentUser.getRole() == Role.ADMIN) || currentUser.getId().equals(userId));
  }

} // end class CurrentUserServiceImpl
