package com.bookstore.models;

class SachTieuThuyet extends Sach {
    boolean tinhTrang;

    SachTieuThuyet() {}

    SachTieuThuyet(long ma, String ten, double dG, int sL, String nxb, boolean tTrang) {
        super(ma, ten, dG, sL, nxb);
        this.tinhTrang = tTrang;
    }


    @Override
    void thongtinSach() {
        super.thongtinSach(); 
        System.out.println("Tình Trạng: " + (tinhTrang ? "Mới" : "Cũ"));
    }

 
    @Override
    double thanhTien() {
        double totalCost = super.thanhTien();
        if (!tinhTrang) { 
            totalCost *= 0.2; 
        }
        return totalCost;
    }
}