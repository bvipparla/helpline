package org.playload.helpline.domain;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;


/**
 * DOCUMENT ME!
 *
 * @author   $author$
 * @version  $Revision$, $Date$
 */
public class UserCreateForm {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  @NotEmpty private String email = "";

  @NotEmpty private String password = "";

  @NotEmpty private String passwordRepeated = "";

  @NotNull private Role role = Role.USER;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getEmail() {
    return email;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getPassword() {
    return password;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getPasswordRepeated() {
    return passwordRepeated;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Role getRole() {
    return role;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  email  DOCUMENT ME!
   */
  public void setEmail(String email) {
    this.email = email;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  password  DOCUMENT ME!
   */
  public void setPassword(String password) {
    this.password = password;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  passwordRepeated  DOCUMENT ME!
   */
  public void setPasswordRepeated(String passwordRepeated) {
    this.passwordRepeated = passwordRepeated;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  role  DOCUMENT ME!
   */
  public void setRole(Role role) {
    this.role = role;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  java.lang.Object#toString()
   */
  @Override public String toString() {
    return "UserCreateForm{"
      + "email='" + email.replaceFirst("@.+", "@***") + '\''
      + ", password=***" + '\''
      + ", passwordRepeated=***" + '\''
      + ", role=" + role
      + '}';
  }

} // end class UserCreateForm
