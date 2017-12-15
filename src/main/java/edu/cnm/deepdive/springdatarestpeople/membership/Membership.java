package edu.cnm.deepdive.springdatarestpeople.membership;

import edu.cnm.deepdive.springdatarestpeople.group.Group;
import edu.cnm.deepdive.springdatarestpeople.person.Person;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class Membership {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id")
  private long id;

  /**
   * Generate timestamp to be used with id to reference records in the entity.
   */
  @Column(nullable = false, insertable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
  @Temporal(TemporalType.TIMESTAMP)
  private Date created;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "person_id")
  private Person person;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "group_id")
  private Group group;

  public Long getId() {
    return id;
  }

  public Membership() {
  }

  public Date getCreated() {
    return created;
  }

  public Person getPerson() {
    return person;
  }

  public void setPerson(Person person) {
    this.person = person;
  }

  public Group getGroup() {
    return group;
  }

  public void setGroup(Group group) {
    this.group = group;
  }

}
