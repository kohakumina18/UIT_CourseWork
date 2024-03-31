package com.bookstore.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class main {
    private static List<Sach> books = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        menu menu = new menu();
        int choice;

        do {
 
            menu.displayMenu();

 
            choice = menu.getUserChoice();


            switch (choice) {
                case 1:
                    themSach();
                    break;
                case 2:
                    chonSach();
                    break;
                case 3:
                    System.out.println("Chương trình kết thúc. Hẹn gặp lại!");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn một tùy chọn hợp lệ.");
            }
        } while (choice != 3);

        menu.closeScanner();
    }


    private static void themSach() {
        System.out.println("Nhập thông tin sách:");
        System.out.print("Mã Sách: ");
        long maSach = scanner.nextLong();
        scanner.nextLine(); // Tiêu thụ ký tự xuống dòng
        System.out.print("Tên Sách: ");
        String tenSach = scanner.nextLine();
        System.out.print("Giá: ");
        double donGia = scanner.nextDouble();
        System.out.print("Số Lượng: ");
        int soLuong = scanner.nextInt();
        scanner.nextLine(); // Tiêu thụ ký tự xuống dòng
        System.out.print("Nhà Xuất Bản: ");
        String nxb = scanner.nextLine();
        System.out.print("Tình Trạng (mới hoặc cũ): ");
        boolean tinhTrang = scanner.next().equalsIgnoreCase("mới");

        SachTieuThuyet book = new SachTieuThuyet(maSach, tenSach, donGia, soLuong, nxb, tinhTrang);
        books.add(book);

        System.out.println("Thêm sách thành công!");
    }

    private static void chonSach() {
        if (books.isEmpty()) {
            System.out.println("Không có sách nào.");
            return;
        }

        System.out.println("Danh sách Sách:");
        for (Sach book : books) {
            book.thongtinSach();
            System.out.println();
        }

        System.out.println("Nhập mã sách để tính toán chi phí hoặc nhập 'info' để xem chi tiết:");
        String input = scanner.next();

        if (input.equalsIgnoreCase("info")) {
            System.out.print("Nhập mã sách để xem chi tiết: ");
            long bookId = scanner.nextLong();
            hienThiThongTinSach(bookId);
        } else {
            long bookId = Long.parseLong(input);
            tinhToanChiPhi(bookId);
        }
    }

    private static void hienThiThongTinSach(long maSach) {
        for (Sach book : books) {
            if (book.maSach == maSach) {
                book.thongtinSach();
                return;
            }
        }
        System.out.println("Không tìm thấy sách.");
    }

    private static void tinhToanChiPhi(long maSach) {
        for (Sach book : books) {
            if (book.maSach == maSach) {
                double tongChiPhi = book.thanhTien();
                System.out.println("Tổng chi phí cho Mã Sách " + maSach + ": $" + tongChiPhi);
                return;
            }
        }
        System.out.println("Không tìm thấy sách.");
    }
}
