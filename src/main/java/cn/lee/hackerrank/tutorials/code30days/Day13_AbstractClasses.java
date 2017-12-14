package cn.lee.hackerrank.tutorials.code30days;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/30-abstract-classes/problem
 * Objective
 * Today, we're taking what we learned yesterday about Inheritance and extending it to Abstract Classes. Because this is a very specific Object-Oriented concept, submissions are limited to the few languages that use this construct. Check out the Tutorial tab for learning materials and an instructional video!
 * <p>
 * Task
 * Given a Book class and a Solution class, write a MyBook class that does the following:
 * <p>
 * Inherits from Book
 * Has a parameterized constructor taking these  parameters:
 * string
 * string
 * int
 * Implements the Book class' abstract display() method so it prints these  lines:
 * , a space, and then the current instance's .
 * , a space, and then the current instance's .
 * , a space, and then the current instance's .
 * Note: Because these classes are being written in the same file, you must not use an access modifier (e.g.: ) when declaring MyBook or your code will not execute.
 * <p>
 * Input Format
 * <p>
 * You are not responsible for reading any input from stdin. The Solution class creates a Book object and calls the MyBook class constructor (passing it the necessary arguments). It then calls the display method on the Book object.
 * <p>
 * Output Format
 * <p>
 * The  method should print and label the respective , , and  of the MyBook object's instance (with each value on its own line) like so:
 * <p>
 * Title: $title
 * Author: $author
 * Price: $price
 * Note: The  is prepended to variable names to indicate they are placeholders for variables.
 * <p>
 * Sample Input
 * <p>
 * The following input from stdin is handled by the locked stub code in your editor:
 * <p>
 * The Alchemist
 * Paulo Coelho
 * 248
 * Sample Output
 * <p>
 * The following output is printed by your display() method:
 * <p>
 * Title: The Alchemist
 * Author: Paulo Coelho
 * Price: 248
 * Created by jason on 17-12-14.
 */
public class Day13_AbstractClasses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String title = scanner.nextLine();
        String author = scanner.nextLine();
        int price = scanner.nextInt();
        scanner.close();

        Book book = new MyBook(title, author, price);
        book.display();
    }
}

abstract class Book {
    String title;
    String author;

    Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    abstract void display();
}

class MyBook extends Book {
    private int price;

    public MyBook(String title, String author, int price) {
        super(title, author);
        this.price = price;
    }

    void display() {
        System.out.println("Title: " +this.title);
        System.out.println("Author: " +this.author);
        System.out.println("Price: " +this.price);
    }
}