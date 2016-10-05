package org.playload.helpline.domain;

import java.io.Serializable;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * Created by knandyala on 9/28/2016.
 *
 * @author   $author$
 * @version  $Revision$, $Date$
 */
@Entity
@Table(name = "GrievanceType")
public class GrievanceType extends BaseObject implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 3125364493235318901L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** DOCUMENT ME! */
  @Column(
    name   = "grievanceDescription",
    length = 255
  )
  protected String grievanceDescription;


  /** DOCUMENT ME! */
  @Column(
    name   = "grievanceName",
    length = 96
  )
  protected String grievanceName;

  /** DOCUMENT ME! */
  @Column(
    name     = "grievanceTypeId",
    nullable = false
  )
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long grievanceTypeId;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  org.playload.helpline.domain.BaseObject#equals(java.lang.Object)
   */
  @Override public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if ((o == null) || (getClass() != o.getClass())) {
      return false;
    }

    if (!super.equals(o)) {
      return false;
    }

    GrievanceType that = (GrievanceType) o;

    return Objects.equals(grievanceDescription, that.grievanceDescription)
      && Objects.equals(grievanceName, that.grievanceName)
      && Objects.equals(grievanceTypeId, that.grievanceTypeId);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getGrievanceDescription() {
    return grievanceDescription;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getGrievanceName() {
    return grievanceName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Long getGrievanceTypeId() {
    return grievanceTypeId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  org.playload.helpline.domain.BaseObject#hashCode()
   */
  @Override public int hashCode() {
    return Objects.hash(super.hashCode(), grievanceDescription, grievanceName, grievanceTypeId);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  grievanceDescription  DOCUMENT ME!
   */
  public void setGrievanceDescription(String grievanceDescription) {
    this.grievanceDescription = grievanceDescription;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  grievanceName  DOCUMENT ME!
   */
  public void setGrievanceName(String grievanceName) {
    this.grievanceName = grievanceName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  grievanceTypeId  DOCUMENT ME!
   */
  public void setGrievanceTypeId(Long grievanceTypeId) {
    this.grievanceTypeId = grievanceTypeId;
  }
} // end class GrievanceType
