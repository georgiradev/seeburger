package org.example.cli;

import org.example.model.Book;
import org.example.model.Date;
import org.example.model.Magazine;
import org.example.model.Readable;
import org.example.reader.Reader;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

public class LibraryManager {
  private List<Readable> readableList;
  private Reader reader;
  private Scanner scanner;

  public LibraryManager(String fileName) {
    this.reader = new Reader();
    this.readableList = reader.getInfo(fileName);
    this.scanner = new Scanner(System.in);
  }

  public void readInput() {
    while (true) {
      System.out.println("Available items are: \n");
      for (Readable readable : readableList) {
        System.out.println(readable);
      }
      System.out.println("\nType name of the readable: ");
      String name = scanner.nextLine();
      Readable readable = findReadable(name);
      if (readable == null) {
        System.out.println("Readable is not registered!\n");
        continue;
      }
      System.out.println("Select action: ");
      System.out.println("Type 1 for rent or 2 for return");
      String cmd = scanner.nextLine();

      switch (cmd) {
        case "1":
        case "2":
          if (readable instanceof Book) {
            findBook(name, cmd);
          } else if (readable instanceof Magazine) {
            System.out.println("Enter magazine issueDate in format mm/yyyy: ");
            String issueDate = scanner.nextLine();
            if (!isValidIssueDate(issueDate)) {
              System.out.println("Invalid issue date!\n");
            } else {
              findMagazine(name, cmd, issueDate);
            }
          }
          break;
        default:
          System.out.println("Command not recognized!\n");
      }
    }
  }

  public Readable findReadable(String name) {
    for (Readable readable : readableList) {
      if (readable.getName().equals(name)) {
        return readable;
      }
    }

    return null;
  }

  public boolean isValidIssueDate(String issueDate) {
    DateFormat sdf = new SimpleDateFormat("MM/yyyy");
    sdf.setLenient(false);
    try {
      sdf.parse(issueDate);
    } catch (ParseException e) {
      return false;
    }
    return true;
  }

  public void findBook(String name, String command) {
    boolean isFound = false;

    for (Readable readable : readableList) {
      if (readable.getName().equals(name)) {
        isFound = true;
        printMessage(command, readable, "Book");
        break;
      }
    }

    if (!isFound) {
      System.out.println("Book is not registered!\n");
    }
  }

  public void printMessage(String command, Readable readable, String className) {
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
      System.out.println(className + " is not present at the moment\n");
    }
  }

  public void findMagazine(String name, String command, String issueDate) {
    boolean isFound = false;
    boolean dateFound = false;
    String[] dateArr = issueDate.split("/");
    String month = dateArr[0];
    String year = dateArr[1];
    Date date = new Date(month, year);

    for (Readable readable : readableList) {
      if (readable.getName().equals(name)) {
        isFound = true;
        if (readable instanceof Magazine) {
          Magazine magazine = (Magazine) readable;
          if (magazine.getIssueDate().equals(date)) {
            dateFound = true;
            printMessage(command, readable, "Magazine");
            break;
          }
        }
      }
    }

    if (!isFound) {
      System.out.println("Magazine is not registered!\n");
    } else if (!dateFound) {
      System.out.println("There is no " + name + " magazine with this issueDate!\n");
    }
  }
}
