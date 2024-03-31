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

public class Bai02_TT_HaiSo {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println ("Nhap So a: ");
        double a = scanner.nextDouble();
        System.out.println("Nhap So b: ");
        double b = scanner.nextDouble();
        
        if (b==0) {
            System.out.println(" So b = 0, khong the thuc hien phep tinh. ");
        } else {
            double result = a / b;
            System.out.println("Ket qua phep chia 2 so la(lam tron den 3 chu so sau dau thap phan :"+ String.format("%.3f", result));
        }
        scanner.close();
    }
}
        
            
