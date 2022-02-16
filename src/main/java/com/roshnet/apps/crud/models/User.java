package com.roshnet.apps.crud.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User {

  @Id
  @GeneratedValue
  private long id;

  private String name;

  private String role;

  protected User() {}

  public User(String name, String role) {
    super();
    this.name = name;
    this.role = role;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getRole() {
    return role;
  }

  public void setRole(String role) {
    this.role = role;
  }

  public long getId() {
    return id;
  }

}
