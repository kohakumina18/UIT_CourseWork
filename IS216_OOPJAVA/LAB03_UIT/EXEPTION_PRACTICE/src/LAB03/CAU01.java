package LAB03;
import java.util.Scanner;

public class CAU01 {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int soInt[] = new int[5];
		int so;
		int i=0;
		try {
			while(true) {
				System.out.println("Nhap so nguyen: ");
				so= sc.nextInt();
				soInt[i]=so;
				i++;
			}
		}catch (ArrayIndexOutOfBoundsException aie) {
			System.out.println("Ban da nhap quá số lượng phần tử!");
		}catch(Exception e ) {
			System.out.println("Vui lòng nhập số nguyên! ");
		}
		System.out.println("Mảng vừa nhập là: ");
		for (int j=0; j < soInt.length; j++) {
			System.out.println(soInt[j]);
		}
	}
}
