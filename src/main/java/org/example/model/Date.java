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
}
