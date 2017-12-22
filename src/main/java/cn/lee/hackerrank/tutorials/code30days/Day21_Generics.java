package cn.lee.hackerrank.tutorials.code30days;

import java.util.Scanner;

/**
 * \
 * https://www.hackerrank.com/challenges/30-generics/problem
 * <pre>
 *
 *     Objective
 * Today we're discussing Generics; be aware that not all languages support this construct, so fewer languages are enabled for this challenge. Check out the Tutorial tab for learning materials and an instructional video!
 *
 * Task
 * Write a single generic function named printArray; this function must take an array of generic elements as a parameter (the exception to this is C++, which takes a vector). The locked Solution class in your editor tests your function.
 *
 * Note: You must use generics to solve this challenge. Do not write overloaded functions.
 *
 * Input Format
 *
 * The locked Solution class in your editor will pass different types of arrays to your printArray function.
 *
 * Constraints
 *
 * You must have exactly  function named printArray.
 * Output Format
 *
 * Your printArray function should print each element of its generic array parameter on a new line.
 * </pre>
 * Created by jason on 17-12-22.
 */
public class Day21_Generics {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Integer[] intArray = new Integer[n];
        for (int i = 0; i < n; i++) {
            intArray[i] = scanner.nextInt();
        }

        n = scanner.nextInt();
        String[] stringArray = new String[n];
        for (int i = 0; i < n; i++) {
            stringArray[i] = scanner.next();
        }

        Printer<Integer> intPrinter = new Printer<Integer>();
        Printer<String> stringPrinter = new Printer<String>();
        intPrinter.printArray(intArray);
        stringPrinter.printArray(stringArray);
        if (Printer.class.getDeclaredMethods().length > 1) {
            System.out.println("The Printer class should only have 1 method named printArray.");
        }
    }
}

class Printer<T> {

    public void printArray(T[] array) {
        for (T t : array) {
            System.out.println(t);
        }
    }
}