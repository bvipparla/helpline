package org.playload.helpline.domain;

import javax.persistence.*;


/**
 * DOCUMENT ME!
 *
 * @author   $author$
 * @version  $Revision$, $Date$
 */
@Entity
@Table(name = "user")
public class User {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  @Column(
    name     = "email",
    nullable = false,
    unique   = true
  )
  private String email;

  @Column(
    name      = "id",
    nullable  = false,
    updatable = false
  )
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id private Long id;

  @Column(
    name     = "password_hash",
    nullable = false
  )
  private String passwordHash;

  @Column(
    name     = "role",
    nullable = false
  )
  @Enumerated(EnumType.STRING)
  private Role role;

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
  public Long getId() {
    return id;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getPasswordHash() {
    return passwordHash;
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
   * @param  passwordHash  DOCUMENT ME!
   */
  public void setPasswordHash(String passwordHash) {
    this.passwordHash = passwordHash;
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
    return "User{"
      + "id=" + id
      + ", email='" + email.replaceFirst("@.*", "@***")
      + ", passwordHash='" + passwordHash.substring(0, 10)
      + ", role=" + role
      + '}';
  }
} // end class User
