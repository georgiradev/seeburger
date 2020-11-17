package org.example.reader;

import org.example.model.Book;
import org.example.model.Date;
import org.example.model.Magazine;
import org.example.model.Readable;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Reader {

  private List<Readable> readables = new ArrayList<>();

  public List<Readable> getInfo(String name) {
    try {
      // the file to be opened for reading
      FileInputStream fis = new FileInputStream(name);
      Scanner sc = new Scanner(fis); // file to be scanned
      // returns true if there is another line to read
      while (sc.hasNextLine()) {
        String[] lineItems = sc.nextLine().split(";");

        String item = lineItems[0];
        String itemName = lineItems[1];
        Readable readable;
        if (item.equals("B")) {
          String author = lineItems[2];
          readable = new Book(itemName, author);
        } else {
          String[] dateArr = lineItems[2].split("/");
          Date date = new Date(dateArr[0], dateArr[1]);
          readable = new Magazine(itemName, date);
        }
        if (!isPresent(readable)) {
          readables.add(readable);
        }
      }
      sc.close(); // closes the scanner
    } catch (IOException e) {
      e.printStackTrace();
    }

    return readables;
  }

  private boolean isPresent(Readable readable) {
    for (Readable r : readables) {
      if (r.getName().equals(readable.getName())) {
        if (readable instanceof Book) {
          Book book = (Book) r;
          if (book.getAuthor().equals(((Book) readable).getAuthor())) {
            book.setNumberOfCopies(book.getNumberOfCopies() + 1);
          }
        } else if (readable instanceof Magazine) {
          Magazine magazine = (Magazine) r;
          magazine.setNumberOfCopies(magazine.getNumberOfCopies() + 1);
        }

        return true;
      }
    }

    return false;
  }
}
