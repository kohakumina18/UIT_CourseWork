package com.bookstore.models;

public class SachTrinhTham extends Sach {
	float thue;
	SachTrinhTham() {};
	SachTrinhTham(long ma, String ten, double dG, int sL, String nxb, float th){
		super(ma,ten,dG,sL,nxb);
		this.thue=th;
	}
	@Override 
	void thongtinSach() {
		super.thongtinSach();
		System.out.println("Thue: "+thue);
	}
	@Override 
	double thanhTien() {
		return super.thanhTien() + (super.thanhTien() *thue);
	}
	
}
