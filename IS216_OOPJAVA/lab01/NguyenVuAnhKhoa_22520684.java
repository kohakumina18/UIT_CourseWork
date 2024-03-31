
package com.mycompany.mavenproject1;

/**
 *
 * @author nvakt
 */
public static void HinhTron (Scanner sc) {
    private double r;
    
    public HinhTron (){
        r=1.0; }
    public HinhTron (double r) {
        this.r = r;
    }
    public double getR(){
        return r;
    }
    public void setR(double r){
        this.r = r;
    }
    public double TinhS() {
        return Math.PI *r*r;
    }
    public double TinhC() {
        return 2*Math.PI*r;
    }
    
    public static void main(String[] args) {
        System.out.println("Hello World!");
        HinhTron Htron = new HinhTron(5.0);
        System.out.println("Hinh Tron voi ban kinh = " + Htron.getR() + " co dien tich la: "+ Htron.TinhS() + " va chu vi la: "+ Htron.TinhC());
        
    }
}
--
public static void Bai02_TT_HaiSo (Scanner sc) {
    
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
--     
public static void Bai03_Fraction (Scanner sc) {
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

public static void Bai04_StringOperations (Scanner sc) {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        
        String x = scanner.nextLine();
        System.out.println("Nhap chuoi y:");
        String y = scanner.nextLine();
        int lengthX = x.length();
        System.out.println("Tong chieu dai cua chuoi x: " + lengthX);
        String firstThreeX = x.substring(0, Math.min(x.length(), 3));
        System.out.println("Ba ki tu dau tien cua chuoi x: " + firstThreeX);
        String lastThreeX = x.substring(Math.max(0, x.length() - 3));
        System.out.println("Ba ki tu cuoi cua chuoi x: " + lastThreeX);
        if (x.length() >= 6) {
            char charAtIndex6 = x.charAt(5);
            System.out.println("Ki tu thu 6 cua chuoi x: " + charAtIndex6);
        } else {
            System.out.println("Chuoi x khong du 6 ki tu.");
        }

        String newString = firstThreeX + y.substring(Math.max(0, y.length() - 3));
        System.out.println("Chuoi moi: " + newString);

        boolean isEqualCaseSensitive = x.equals(y);
        System.out.println("Chuoi x bang chuoi y (phan biet chu hoa, thuong)? " + isEqualCaseSensitive);

        boolean isEqualIgnoreCase = x.equalsIgnoreCase(y);
        System.out.println("Chuoi x bang chuoi y (khong phan biet chu hoa, thuong)? " + isEqualIgnoreCase);

        int positionOfY = x.indexOf(y);
        if (positionOfY != -1) {
            System.out.println("Chuoi y xuat hien trong chuoi x tai vi tri: " + positionOfY);
        } else {
            System.out.println("Chuoi y khong xuat hien trong chuoi x.");
        }
        int index = 0;
        while ((index = x.indexOf(y, index)) != -1) {
            System.out.println("Chuoi y xuat hien trong chuoi x tai vi tri: " + index);
            index += y.length();
        }

        scanner.close();
    }
}

public static void Bai05_TienDien (Scanner sc) {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập vào số điện sử dụng trong tháng (kWh): ");
        int soDienSuDung = scanner.nextInt();

        int tienDien = tinhTienDien(soDienSuDung);
        System.out.println("Số tiền điện cần thanh toán: " + tienDien + " đồng.");

        scanner.close();
    }

    public static int tinhTienDien(int soDienSuDung) {
        int giaMoiSoDien;
        int soDienVuotHanMuc50kW;

        if (soDienSuDung <= 50) {
            giaMoiSoDien = 2000;
            soDienVuotHanMuc50kW = 0;
        } else if (soDienSuDung <= 100) {
            giaMoiSoDien = 2500;
            soDienVuotHanMuc50kW = soDienSuDung - 50;
        } else {
            giaMoiSoDien = 3500;
            soDienVuotHanMuc50kW = soDienSuDung - 100;
        }

        return 50 * 2000 + soDienVuotHanMuc50kW * giaMoiSoDien;
    }
}