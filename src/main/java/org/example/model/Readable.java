package org.example.model;

public interface Readable {
  String getName();

  int getNumberOfCopies();

  void setNumberOfCopies(int numberOfCopies);

  int getInitialCopies();

  void setInitialCopies(int numberOfCopies);
}
