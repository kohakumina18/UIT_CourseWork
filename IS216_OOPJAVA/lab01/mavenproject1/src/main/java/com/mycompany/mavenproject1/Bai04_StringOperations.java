/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1;

/**
 *
 * @author nvakt
 */
import java.util.Scanner;

public class Bai04_StringOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input strings x and y
        System.out.println("Nhap chuoi x:");
        String x = scanner.nextLine();
        System.out.println("Nhap chuoi y:");
        String y = scanner.nextLine();

        // Calculate the length of string x
        int lengthX = x.length();
        System.out.println("Tong chieu dai cua chuoi x: " + lengthX);

        // Display the first three characters of string x
        String firstThreeX = x.substring(0, Math.min(x.length(), 3));
        System.out.println("Ba ki tu dau tien cua chuoi x: " + firstThreeX);

        // Display the last three characters of string x
        String lastThreeX = x.substring(Math.max(0, x.length() - 3));
        System.out.println("Ba ki tu cuoi cua chuoi x: " + lastThreeX);

        // Display the 6th character of string x
        if (x.length() >= 6) {
            char charAtIndex6 = x.charAt(5);
            System.out.println("Ki tu thu 6 cua chuoi x: " + charAtIndex6);
        } else {
            System.out.println("Chuoi x khong du 6 ki tu.");
        }

        // Create a new string with the first three characters of x and the last three characters of y
        String newString = firstThreeX + y.substring(Math.max(0, y.length() - 3));
        System.out.println("Chuoi moi: " + newString);

        // Check if strings x and y are equal (case-sensitive)
        boolean isEqualCaseSensitive = x.equals(y);
        System.out.println("Chuoi x bang chuoi y (phan biet chu hoa, thuong)? " + isEqualCaseSensitive);

        // Check if strings x and y are equal (case-insensitive)
        boolean isEqualIgnoreCase = x.equalsIgnoreCase(y);
        System.out.println("Chuoi x bang chuoi y (khong phan biet chu hoa, thuong)? " + isEqualIgnoreCase);

        // Check if string y appears in string x and its position
        int positionOfY = x.indexOf(y);
        if (positionOfY != -1) {
            System.out.println("Chuoi y xuat hien trong chuoi x tai vi tri: " + positionOfY);
        } else {
            System.out.println("Chuoi y khong xuat hien trong chuoi x.");
        }

        // Find all positions of string y in string x
        int index = 0;
        while ((index = x.indexOf(y, index)) != -1) {
            System.out.println("Chuoi y xuat hien trong chuoi x tai vi tri: " + index);
            index += y.length();
        }

        scanner.close();
    }
}
