package net.guides.springboot.todomanagement.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name="todos")
public class Todo {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  private String username;

  @Size(min=10, message="Add at least 10 characters")
  private String description;

  private Date targetDate;

  public Todo() {
    super();
  }

  public Todo(String user, String desc, Date targetDate, boolean idDone) {
    super();
    this.username = user;
    this.description = desc;
    this.targetDate = targetDate;
  }

  // Getter for username
  public String getUsername() {
    return this.username;
  }

  /* Getters and setters for "id" */

  public long getId() {
    return id;
  }
  public void setId(long id) {
    this.id = id;
  }

  /* Getters and setters for "description" */

  public String getDescription() {
    return this.description;
  }

  public void setDescription(String desc) {
    this.description = desc;
  }

  /* Getters and setters for "targetDate" */

  public Date getTargetDate() {
    return targetDate;
  }

  public void setTargetDate(Date targetDate) {
    this.targetDate = targetDate;
  }


}
