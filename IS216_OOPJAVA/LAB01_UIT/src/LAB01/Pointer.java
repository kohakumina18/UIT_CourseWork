package LAB01;

public class Pointer {
	private double x;
	private double y;
	
	public Pointer (double x, double y) {
		this.x = x;
		this.y = y;
	}
	public double CDistance(Pointer otherP) {
		return Math.sqrt(Math.pow(otherP.x - this.x,2)+ Math.pow(otherP.y - this.y, 2));
	
	}
		public String toString() {
	        return "(" + x + ", " + y + ")";	//return "(" + x + ", " + y + ")";
	}
	public double calculateDistance (Pointer anotherPointer) {
		return Math.sqrt(Math.pow(anotherPointer.x - this.x, 2) + Math.pow(anotherPointer.y -this.y, 2));
	}
}
