package org.example.model;

public class Magazine implements Readable {

  private final String name;
  private final Date issueDate;
  private int initialCopies;
  private int numberOfCopies;

  public Magazine(String name, Date issueDate) {
    this.name = name;
    this.issueDate = issueDate;
    this.numberOfCopies = 1;
    this.initialCopies = 1;
  }

  public Date getIssueDate() {
    return issueDate;
  }

  @Override
  public String toString() {
    return "Magazine{"
        + "name='"
        + name
        + '\''
        + ", issueDate="
        + issueDate
        + ", numberOfCopies="
        + numberOfCopies
        + '}';
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == null) {
      return false;
    }

    if (obj.getClass() != this.getClass()) {
      return false;
    }

    final Magazine other = (Magazine) obj;
    if(!this.name.equals(other.name)) {
      return false;
    }
    if(!this.issueDate.equals(other.issueDate)) {
      return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int hash = 3;
    hash = 53 * hash + (this.name != null ? this.name.hashCode() : 0);
    hash = 53 * hash + this.initialCopies;

    return hash;
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public int getNumberOfCopies() {
    return numberOfCopies;
  }

  @Override
  public void setNumberOfCopies(int numberOfCopies) {
    this.numberOfCopies = numberOfCopies;
  }

  @Override
  public int getInitialCopies() {
    return this.initialCopies;
  }

  @Override
  public void setInitialCopies(int numberOfCopies) {
    this.initialCopies = numberOfCopies;
  }
}
