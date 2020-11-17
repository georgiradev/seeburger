package org.example.cli;

import org.example.model.Readable;
import org.example.reader.Reader;

import java.util.List;
import java.util.Scanner;

public class Library {
  private List<Readable> readableList;
  private Reader reader;
  private Scanner scanner;

  public Library(String fileName) {
    this.reader = new Reader();
    this.readableList = reader.getInfo(fileName);
    this.scanner = new Scanner(System.in);
  }

  public void getInput() {
    while (true) {
      System.out.println("Available items are: \n");
      for (Readable readable : readableList) {
        System.out.println(readable);
      }
      System.out.println("\nType name of the readable: ");
      String name = scanner.nextLine();
      System.out.println("Select action: ");
      System.out.println("Type 1 for rent or 2 for return");
      String cmd = scanner.nextLine();

      switch (cmd) {
        case "1":
        case "2":
          findItem(name, cmd);
          break;
        default:
          System.out.println("Command not recognized!");
      }
    }
  }

  public void findItem(String name, String command) {
    boolean isFound = false;

    for (Readable readable : readableList) {
      if (readable.getName().equals(name)) {
        isFound = true;
        String className = readable.getClass().getSimpleName();

        if (readable.getNumberOfCopies() > 0 && command.equals("1")) {
          System.out.println(
              className + " with name " + readable.getName() + " was rented to you successfully!");
          readable.setNumberOfCopies(readable.getNumberOfCopies() - 1);
        } else if (command.equals("2")) {
          if (readable.getInitialCopies() == readable.getNumberOfCopies()) {
            System.out.println("All initial copies are present! No action is performed.");
          } else {
            System.out.println(
                className + " with name " + readable.getName() + " was returned successfully!");
            readable.setNumberOfCopies(readable.getNumberOfCopies() + 1);
          }
        } else {
          System.out.println(className + " is not present at the moment");
        }
      }
    }

    if (!isFound) {
      System.out.println("Readable is not registered!");
    }
  }
}
