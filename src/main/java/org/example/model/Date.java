package org.example.model;

public class Date {

  private final String month;
  private final String year;

  public Date(String date, String year) {
    this.month = date;
    this.year = year;
  }

  public String getMonth() {
    return month;
  }

  public String getYear() {
    return year;
  }

  @Override
  public String toString() {
    return "Date{" + "month='" + month + '\'' + ", year='" + year + '\'' + '}';
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == null) {
      return false;
    }

    if (obj.getClass() != this.getClass()) {
      return false;
    }

    final Date other = (Date) obj;
    if (!this.month.equals(other.month)) {
      return false;
    }
    if (!this.year.equals(other.year)) {
      return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int hash = 3;
    hash = 53 * hash + (this.month != null ? this.month.hashCode() : 0);
    hash = 53 * hash + 5;

    return hash;
  }
}
