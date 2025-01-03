package LAB03;
import java.util.Random;
import java.util.Scanner;
public class CAU02 {
	public static void exceptionThrows() throws ArrayIndexOutOfBoundsException, Exception{
		int randomN[]=new int[10];
		Random rand=new Random();
		for (int i=0; i< randomN.length; i++) {
			randomN[i] = rand.nextInt(100);
		}
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhập vào vị trí phần tử muốn in giá trị: ");
		int index =sc.nextInt();
		if(index<0)throw new Exception();
		System.out.println("Ok, phan tu mang thu "+ index +" co gia tri "+ randomN[index]);
		
	}
	
	public static void main (String [] args) {
		while(true) {
			try {
				exceptionThrows();
				
			}catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("Ban da nhap qua chi so cua mang.");
				break;
			}catch(Exception e) {
				System.out.println("Chi so index phai lon hon 0!");
			}
		}
	}
	
}
