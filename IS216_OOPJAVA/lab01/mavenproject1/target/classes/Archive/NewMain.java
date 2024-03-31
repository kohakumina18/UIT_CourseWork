/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.first_project;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Admins
 */
public class NewMain 
{

    /**
     * @param args the command line arguments
     */
    public static void cau1(Scanner sc)
    {
        Boolean ok = true;
        int n = sc.nextInt();
        if(n==1)
        {
            System.out.println("1 la so nguyen to");
            return;
        }
        if(n == 0)
        {
            System.out.println("0 khong la so nguyen to");
            return;
        }
        for (int i = 2; i <= Math.sqrt(n); i++)
        { 
            if (n % i == 0)
            {
                ok = false;
                break;
            }
        }
        if(ok)
            System.out.println(n+" la so nguyen to");
        else
            System.out.println(n+" khong la so nguyen to");
    }
    public static void cau2()
    {
        System.out.println("x  1  2  3  4  5  6  7  8  9  10");
        for(int i=1;i<11;i++)
        {
            System.out.print(i);
            for(int j = 1; j<11;j++)
            {
                System.out.print("  "+i*j);
            }
            System.out.println("");
        }
    }
    public static void cau3(Scanner sc)
    {
        int n, max = 0, min = 1000000;
        System.out.print("nhap n: ");
        n = sc.nextInt();
        int list[] = new int[n];
        for (int i = 0; i < n; i++)
        {
            list[i] = sc.nextInt();
        }
        for(int i = 0; i < n; i++)
        {
            max = Math.max(list[i], max);
            min = Math.min(list[i], min);
        }
        System.out.println("max: " + max +"\nmin: "+min);
        Arrays.sort(list);
        System.out.println(Arrays.toString(list));
        int x = sc.nextInt();
        int solan = 0;
        int result =Arrays.binarySearch(list, x);
        if(result < 0)
        {
            System.out.println("khong tim thay");
        }
        else 
            System.out.println("tim thay "+ x +" o vi tri "+(result+1));
        result = 0;
        while(result != -1)
        {
            result = Arrays.binarySearch(list, result+1, n, x);
            if(result != -1)
                solan = solan +1;
            if(result == n-1)
                break;
            System.out.println(result);
        }
        System.out.println("so lan "+ x +" xuat hien trong mang la "+ solan);
    }
    public static void swap(int i,int A[][])
    {
        int temp = A[i][i];
        A[i][i] = A[i+1][i+1];
        A[i+1][i+1] = temp;
    }
    public static void cau4(Scanner sc)
    {
        int min = Integer.MAX_VALUE;
        int n = sc.nextInt();
        int list[][] = new int [n][n];
        for (int i = 0; i < n; i++) 
        {
            for (int j = 0; j < n; j++) 
            {
                list[i][j] = sc.nextInt();
            }
        }
        for(int i = 0;i<n;i++)
        {
            Arrays.sort(list[i]);
        }
        for(int i = 0; i < n-1; i++)
        {
            for(int j = i+1; j< n;j++)
            {
                if(i < n-1 && list[i][i] > list[i+1][i+1])
                {
                    swap(i, list);
                }
            } 
        }
        for (int i = 0; i < n; i++) 
        {
            for (int j = 0; j < n; j++) 
            {
                min = Math.min(list[i][j], min);
                System.out.print(list[i][j] + " ");
            }
            System.out.println("\n");   
        }
        System.out.println("so nho nhat la: "+min);
        
    }
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        cau4(sc);
    }
    
}
