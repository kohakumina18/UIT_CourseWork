
import java.util.Scanner;

public class QuanLySinhVien {
	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);	   
	        System.out.println("Nhập thông tin cho sinh viên 1:");
	        SinhVien sv1 = nhapThongTinSinhVien(scanner);

	        
	        System.out.println("Nhập thông tin cho sinh viên 2:");
	        SinhVien sv2 = nhapThongTinSinhVien(scanner);

	    
	        System.out.println("Nhập thông tin cho sinh viên 3:");
	        SinhVien sv3 = nhapThongTinSinhVien(scanner);

	  
	        System.out.println("\nDanh sách sinh viên:");
	        System.out.println(String.format("%-15s %-20s %-10s %-10s %-10s", "Mã sinh viên", "Họ tên", "Điểm LT", "Điểm TH", "Điểm TB"));
	        System.out.println(sv1);
	        System.out.println(sv2);
	        System.out.println(sv3);

	        scanner.close();
	    }

	    public static SinhVien nhapThongTinSinhVien(Scanner scanner) {
	        System.out.print("Nhập mã sinh viên: ");
	        int maSinhVien = scanner.nextInt();
	        scanner.nextLine();
	        System.out.print("Nhập họ tên: ");
	        String hoTen = scanner.nextLine();
	        System.out.print("Nhập điểm lý thuyết: ");
	        float diemLT = scanner.nextFloat();
	        System.out.print("Nhập điểm thực hành: ");
	        float diemTH = scanner.nextFloat();
	        return new SinhVien(maSinhVien, hoTen, diemLT, diemTH);
	    }
	}

