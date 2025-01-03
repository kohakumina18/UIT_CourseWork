package LAB01;
import java.util.Scanner;

public class Main {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);	
		System.out.println("Nhap vao toa do diem 1: ");
		double x1 = sc.nextDouble();
		double y1 = sc.nextDouble();
		Pointer point1 = new Pointer(x1,y1);
		System.out.println("Nhap vao toa do diem 2: ");
		double x2 = sc.nextDouble();
		double y2 = sc.nextDouble();
		Pointer point2 = new Pointer(x2, y2);
		double distance = point1.calculateDistance(point2);
        System.out.println("Distance between the two points" + point1 + " and " + point2 + " is " + distance);
        sc.close();
	}
}
