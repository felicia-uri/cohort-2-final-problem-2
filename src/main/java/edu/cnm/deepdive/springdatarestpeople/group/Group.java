package edu.cnm.deepdive.springdatarestpeople.group;

import edu.cnm.deepdive.springdatarestpeople.membership.Membership;
import edu.cnm.deepdive.springdatarestpeople.person.Person;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class Group {

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


  /**
   * Map one group to many memberships.
   */
  @OneToMany(fetch = FetchType.EAGER, mappedBy = "group", cascade = CascadeType.ALL)
  private List<Membership> memberships = new LinkedList<>();

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "person_id")
  private Person person;

  private String name;

  public Long getId() {
    return id;
  }

  public Group() {
  }

  public Group(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public Date getCreated() {
    return created;
  }

  public List<Membership> getMemberships() {
    return memberships;
  }

  public void setMemberships(List<Membership> memberships) {
    this.memberships = memberships;
  }

  public Person getPerson() {
    return person;
  }

  public void setPerson(Person person) {
    this.person = person;
  }

}
