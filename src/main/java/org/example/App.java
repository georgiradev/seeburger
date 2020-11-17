package org.example;

import org.example.cli.Library;

public class App {
  public static void main(String[] args) {
    Library library = new Library("src/main/java/File.txt");
    library.getInput();
  }
}
