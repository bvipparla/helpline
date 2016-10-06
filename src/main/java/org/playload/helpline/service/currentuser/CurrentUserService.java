package org.playload.helpline.service.currentuser;


import org.playload.helpline.domain.CurrentUser;


/**
 * DOCUMENT ME!
 *
 * @author   $author$
 * @version  $Revision$, $Date$
 */
public interface CurrentUserService {
  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   currentUser  DOCUMENT ME!
   * @param   userId       DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  boolean canAccessUser(CurrentUser currentUser, Long userId);

}
