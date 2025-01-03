package LAB03;

public class GENERIC_CAU01 {
	public static <T> void xuatMang(T[] arr) {
		for (int i =0; i< arr.length;i++) {
			System.out.println(arr[i]);
		}
	}
	public static void main (String[] args) {
		Integer[] arrInt = {1,2,3,4};
		String [] arrString = {"A","B","C"};
		Double[] arrDouble = {10.0, 9.0,8.0,7.0,8.5,5.5};
		xuatMang(arrInt);
		xuatMang(arrString);
		xuatMang(arrDouble);
	}
}
