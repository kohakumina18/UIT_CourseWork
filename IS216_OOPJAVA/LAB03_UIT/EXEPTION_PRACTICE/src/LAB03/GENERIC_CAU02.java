package LAB03;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;

public class GENERIC_CAU02 {
	public static double getAverage(List<? extends Number> numList) {
		double total =0.0;
		for (Number number : numList)
			total += number.doubleValue();
		return total/numList.size();
	}
	public static void main(String[] args) {
	List<Integer> integerList	= new ArrayList<Integer>();
	integerList.add(3);
	integerList.add(30);
	integerList.add(60);
	System.out.println(getAverage(integerList));
	List<Double> doubleList = new ArrayList<Double>();
	doubleList.add(3.0);
	doubleList.add(10.0);
	doubleList.add(3.90);
	doubleList.add(80.0);
	System.out.println(getAverage(doubleList));
	}
}
