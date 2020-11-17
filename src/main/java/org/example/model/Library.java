package org.example.model;

import org.example.cli.LibraryManager;

public class Library {
  private final LibraryManager libraryManager;

  public Library() {
    this.libraryManager = new LibraryManager("src/main/java/File.txt");
  }

  public void showMenu() {
    this.libraryManager.readInput();
  }
}
