package mcgill.ecse321.eventregistration.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Person {
  @Id
  private String name;

  public void setName(String value) {
    this.name = value;
  }

  public String getName() {
    return this.name;
  }
}
