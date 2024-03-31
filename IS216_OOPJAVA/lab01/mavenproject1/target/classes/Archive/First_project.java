/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.mavenproject1;

import java.util.Scanner;


/**
 *
 * @author Admins
 */
public class Lab01 {
    public static void Bai1(Scanner sc)
    {
        float S = 0;
        int r = sc.nextInt();
        S = (float)Math.PI*r*r;
        System.out.println(Dien_Tich);
    }
    public static void Bai2(Scanner sc)
    {
        int a = sc.nextInt();
        int b = sc.nextInt();
        double c = (double)a/b;
        System.out.printf("%.3f\n",Chu_Vi);
    }
    public static void Bai3(Scanner sc)
    {
        int tu1,tu2,mau1,mau2;
        System.out.println("Nhap phan so 1:");
        tuso1 = sc.nextInt();
        mau1 = sc.nextInt();
        System.out.println("Nhap phan so 2:");
        tuso2 = sc.nextInt();
        mau2 = sc.nextInt();
        System.out.println("tong: "+(tuso1*mau2+tuso2*mau1)+"/"+(mau1*mau2));
        System.out.println("hieu: "+(tuso1*mau2-tuso2*mau1)+"/"+(mau1*mau2));
        System.out.println("tich: "+(tuso1*tuso2)+"/"+(mau1*mau2));
        System.out.println("thuong: "+(tuso1*mau2)+"/"+(tuso2*mau1));
    }
    public static void Bai4(Scanner sc)
    {
        sc.nextLine();
        String a = sc.nextLine();
        String b = sc.nextLine();
        System.out.println(a.length());
        System.out.println(b.substring(0, 3));
        System.out.println(b.substring(b.length()-3));
        System.out.println(a.charAt(5));
        System.out.println(a.substring(0, 3)+
                b.substring(b.length()-3));
        if(a.equals(b))
            System.out.println("Hai chuoi bang nhau (phan biet hoa thuong).");
        else
            System.out.println("Hai chuoi khong bang nhau (phan biet hoa thuong).");
        if(a.equalsIgnoreCase(b))
            System.out.println("Hai chuoi bang nhau. ");
        else
            System.out.println("Hai chuoi khong bang nhau ");
        if(a.indexOf(b) != -1)
            System.out.println("y xuat hien trong x o vi tri" + a.indexOf(b));
        else 
            System.out.println("y khong xuat hien trong x");
        for(int i = 0;i<a.length();i++)
        {
            if(a.indexOf(b, i) != -1)
            {
                System.out.println(a.indexOf(b, i));
                i = a.indexOf(b, i)+ b.length()-1 ;
            }     
            else 
                break;
        }
    }
    public static void cau5(Scanner sc)
    {
        int so_dien = sc.nextInt();
        int tien_dien = 0;
        if(so_dien <= 50)
            System.out.println("tien dien: "+ so_dien*2000);
        else if(so_dien >100)
        {
            so_dien = so_dien - 50;
            tien_dien = so_dien*3500 + 50*2000;
            System.out.println("tien dien: "+tien_dien);
        }
        else
        {
            so_dien = so_dien - 50;
            tien_dien = so_dien*2500 + 50*2000;
            System.out.println("tien dien: "+tien_dien);
        }
    }
    public static void Bai06(Scanner sc)
    {
        System.out.println("##################################\n1.  Bai1\n2.  Bai2\n3.  Bai3\n4.  Bai4"
                + "\n5.  Bai5\n6.  Thoat\n##################################");
        Boolean run = true;
        while(run)
        {
            System.out.print("Chon chuc nang: ");
            int chuc_nang = sc.nextInt();
            switch(chuc_nang)
            {
                case 1:
                    Bai1(sc);
                    break;
                case 2:
                    Bai2(sc);
                    break;
                case 3:
                    Bai3(sc);
                    break;
                case 4:
                    Bai4(sc);
                    break;
                case 5:
                    Bai05(sc);
                    break;
                case 6:
                    run = false;
                    break;
                default:
                    System.out.println("Options khong ton tai, vui long chon lai. ");
                    break;
            }
        }
    }
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        cau6(sc);
    }
}
