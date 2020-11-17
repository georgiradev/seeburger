package org.example;

import org.example.cli.Library;
import org.example.model.Book;
import org.example.model.Date;
import org.example.model.Magazine;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class AppTest {

  private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
  private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
  private final PrintStream originalOut = System.out;
  private final PrintStream originalErr = System.err;
  private Library library;

  @Before
  public void setUpStreams() {
    System.setOut(new PrintStream(outContent));
    System.setErr(new PrintStream(errContent));
  }

  @After
  public void restoreStreams() {
    System.setOut(originalOut);
    System.setErr(originalErr);
  }

  @Before
  public void initialize() {
    library = new Library("src/main/java/File.txt");
  }

  @Test
  public void rentBook() {
    Book book = new Book("The Firm", "John Grisham");
    library.findItem(book.getName(), "1");

    assertEquals(
        "Book with name The Firm was rented to you successfully!\r\n", outContent.toString());
  }

  @Test
  public void rentMagazine() {
    Magazine magazine = new Magazine("PC Today", new Date("07", "2017"));
    library.findItem(magazine.getName(), "1");

    assertEquals(
        "Magazine with name PC Today was rented to you successfully!\r\n", outContent.toString());
  }

  @Test
  public void returnBook() {
    Book book = new Book("The Firm", "John Grisham");
    library.findItem(book.getName(), "1");
    library.findItem(book.getName(), "2");

    assertEquals(
        "Book with name The Firm was rented to you successfully!\r\n"
            + "Book with name The Firm was returned successfully!\r\n",
        outContent.toString());
  }

  @Test
  public void rentBookThatNotExist() {
    Book book = new Book("Lord of the Rings", "J. R. R. Tolkien");
    library.findItem(book.getName(), "1");

    assertEquals("Readable is not registered!\r\n", outContent.toString());
  }

  @Test
  public void returnBookThatNotExist() {
    Book book = new Book("Lord of the Rings", "J. R. R. Tolkien");
    library.findItem(book.getName(), "2");

    assertEquals("Readable is not registered!\r\n", outContent.toString());
  }

  @Test
  public void returnBookMoreTimesThanInitialCount() {
    Book book = new Book("The Firm", "John Grisham");
    library.findItem(book.getName(), "2");

    assertEquals(
        "All initial copies are present! No action is performed.\r\n", outContent.toString());
  }

  @Test
  public void tryRentBookThatIsRegisteredButNotAvailable() {
    Book book = new Book("The Firm", "John Grisham");
    library.findItem(book.getName(), "1");
    library.findItem(book.getName(), "1");

    assertEquals(
        "Book with name The Firm was rented to you successfully!\r\n"
            + "Book is not present at the moment\r\n",
        outContent.toString());
  }
}
