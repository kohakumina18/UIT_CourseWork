package com.bookstore.models;
class Sach {
	
	
    long maSach;
    String tenSach;
    double donGia;
    int soLuong;
    String nxb;


    Sach() {}

    Sach(long maSach, String tenSach, double donGia, int soLuong, String nxb) {
        this.maSach = maSach;
        this.tenSach = tenSach;
        this.donGia = donGia;
        this.soLuong = soLuong;
        this.nxb = nxb;
    }


    void thongtinSach() {
        System.out.println("Mã Sách: " + maSach);
        System.out.println("Tên Sách: " + tenSach);
        System.out.println("Giá: " + donGia);
        System.out.println("Số Lượng: " + soLuong);
        System.out.println("Nhà Xuất Bản: " + nxb);
    }


    double thanhTien() {
        return donGia * soLuong;
    }
}
