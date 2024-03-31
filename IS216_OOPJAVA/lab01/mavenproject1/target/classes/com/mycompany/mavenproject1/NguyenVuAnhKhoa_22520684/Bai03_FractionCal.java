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

public class Bai03_Fraction {
    public class Fraction {
        int tu;
        int mau;

        Fraction(int tu, int mau) {
            this.tu = tu;
            this.mau = mau;
        }

        Fraction cong(Fraction f) {
            int tu_n = this.tu * f.mau + f.tu * this.mau;
            int mau_n = this.mau * f.mau;
            return new Fraction(tu_n, mau_n);
        }

        Fraction tru(Fraction f) {
            int tu_n = this.tu * f.mau - f.tu * this.mau;
            int mau_n = this.mau * f.mau;
            return new Fraction(tu_n, mau_n);
        }

        Fraction nhan(Fraction f) {
            int tu_n = this.tu * f.tu;
            int mau_n = this.mau * f.mau;
            return new Fraction(tu_n, mau_n);
        }

        Fraction chia(Fraction f) {
            if (f.tu == 0) {
                throw new IllegalArgumentException("Cannot divide by zero.");
            }
            int tu_n = this.tu * f.mau;
            int mau_n = this.mau * f.tu;
            return new Fraction(tu_n, mau_n);
        }

        private int findGCD(int a, int b) {
            while (b != 0) {
                int temp = b;
                b = a % b;
                a = temp;
            }
            return a;
        }

        private void simplify() {
            int gcd = findGCD(this.tu, this.mau);
            this.tu /= gcd;
            this.mau /= gcd;
        }

        public String toString() {
            return this.tu + "/" + this.mau;
        }
    }

    public static void main(String[] args) {
        Bai03_Fraction calculator = new Bai03_Fraction();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Nhap phan so thu nhat: ");
        System.out.println("Tu so: ");
        int tu1 = scanner.nextInt();
        System.out.println("Mau so: ");
        int mau1 = scanner.nextInt();

        System.out.println("Nhap phan so thu hai: ");
        System.out.println("Tu so: ");
        int tu2 = scanner.nextInt();
        System.out.println("Mau so: ");
        int mau2 = scanner.nextInt();

        Fraction f1 = calculator.new Fraction(tu1, mau1);
        Fraction f2 = calculator.new Fraction(tu2, mau2);

        Fraction tong = f1.cong(f2);
        Fraction hieu = f1.tru(f2);
        Fraction tich = f1.nhan(f2);
        Fraction thuong = null;
        try {
            thuong = f1.chia(f2);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("Tong: " + tong);
        System.out.println("Hieu: " + hieu);
        System.out.println("Tich: " + tich);
        if (thuong != null) {
            System.out.println("Thuong: " + thuong);
        }

        scanner.close();
    }
}



        