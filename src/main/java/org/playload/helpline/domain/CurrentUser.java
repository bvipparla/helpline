package org.playload.helpline.domain;

import org.springframework.security.core.authority.AuthorityUtils;


/**
 * DOCUMENT ME!
 *
 * @author   $author$
 * @version  $Revision$, $Date$
 */
public class CurrentUser extends org.springframework.security.core.userdetails.User {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  private User user;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Creates a new CurrentUser object.
   *
   * @param  user  DOCUMENT ME!
   */
  public CurrentUser(User user) {
    super(user.getEmail(), user.getPasswordHash(), AuthorityUtils.createAuthorityList(user.getRole().toString()));
    this.user = user;
  }

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Long getId() {
    return user.getId();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Role getRole() {
    return user.getRole();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public User getUser() {
    return user;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  org.springframework.security.core.userdetails.User#toString()
   */
  @Override public String toString() {
    return "CurrentUser{"
      + "user=" + user
      + "} " + super.toString();
  }
} // end class CurrentUser
