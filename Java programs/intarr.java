//LAB WEEK 1
//4
import java.util.Scanner;
class Intarr{
	public static void main (String[] args) 
	{
		int i,n;
		int a[]=new int[10];
		Scanner scn=new Scanner(System.in);
		System.out.print("Input size of Array(max 10): ");
		n=scn.nextInt();
		System.out.println("Enter Elements: ");
		for (i = 0; i < n; i++) 
		{ 
			a[i]=scn.nextInt();
		}
   
	System.out.print("Elements in tha array are: ");
	for (i = 0; i < n; i++)
		{ 
			System.out.print(a[i]+" ");
		}
	System.out.println();
	System.out.print("Enter element to be searched: ");
	int search = scn.nextInt();
	for(i=0;i<n;i++)
	{
		if(a[i]==search)
		{
			System.out.println(search +" is at the position "+(i+1)+".");
			break;
		}
	}
	if(i==n)
		System.out.println(search+" is not present in the array.");
	}
  
}