package org.example.model;

public class Book implements Readable {

  private final String name;
  private final String author;
  private int initialCopies;
  private int numberOfCopies;

  public Book(String name, String author) {
    this.name = name;
    this.author = author;
    this.numberOfCopies = 1;
    this.initialCopies = 1;
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
  public boolean equals(Object obj) {
    if (obj == null) {
      return false;
    }

    if (obj.getClass() != this.getClass()) {
      return false;
    }

    final Book other = (Book) obj;
    if(!this.name.equals(other.name)) {
      return false;
    }
    if(!this.author.equals(other.author)) {
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

  @Override
  public int getInitialCopies() {
    return this.initialCopies;
  }

  @Override
  public void setInitialCopies(int numberOfCopies) {
    this.initialCopies = numberOfCopies;
  }
}
