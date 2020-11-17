package org.example.model;

public class Book implements Readable {

  private final String name;
  private final String author;
  private int numberOfCopies;

  public Book(String name, String author) {
    this.name = name;
    this.author = author;
    this.numberOfCopies = 1;
  }

  @Override
  public String toString() {
    return "Book{"
        + "name='"
        + name
        + '\''
        + ", author='"
        + author
        + '\''
        + ", numberOfCopies="
        + numberOfCopies
        + '}';
  }

  @Override
  public String getName() {
    return name;
  }

  public String getAuthor() {
    return author;
  }

  @Override
  public int getNumberOfCopies() {
    return numberOfCopies;
  }

  @Override
  public void setNumberOfCopies(int numberOfCopies) {
    this.numberOfCopies = numberOfCopies;
  }
}
