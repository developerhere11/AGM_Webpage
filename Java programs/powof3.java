//7
import java.lang.Math;
class Powof3{
	public static void main(String args[]){
		int n=3;
		for(int i=30;i<=39;i++){
			double a=Math.pow(n,i);
			System.out.println("3^"+i+" "+"="+" "+a);
		}
	}
}