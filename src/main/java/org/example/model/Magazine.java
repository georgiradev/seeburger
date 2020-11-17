package org.example.model;

public class Magazine implements Readable {

  private final String name;
  private final Date issueDate;
  private final int initialCopies;
  private int numberOfCopies;

  public Magazine(String name, Date issueDate) {
    this.name = name;
    this.issueDate = issueDate;
    this.numberOfCopies = 1;
    this.initialCopies = 1;
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
}
