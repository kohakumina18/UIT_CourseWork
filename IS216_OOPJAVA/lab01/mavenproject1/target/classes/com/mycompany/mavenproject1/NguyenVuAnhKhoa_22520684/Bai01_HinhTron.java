
package com.mycompany.mavenproject1;

/**
 *
 * @author nvakt
 */
public class HinhTron {
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
