class Input{
   	double area;
	double perimeter;
	double volume;
	Input(){
		int radius = 4;
		area = 3.14*radius*radius;
		perimeter = 2*3.14*radius;
		System.out.println("Circle with radius ="+" "+radius);
		System.out.println("Area ="+" "+area+" "+"Perimeter ="+" "+perimeter);
	} 

	Input(int l){
		area = l*l;
		perimeter = 4*l;
		System.out.println("Square with side ="+" "+l);
		System.out.println("Area ="+" "+area+" "+"Perimeter ="+" "+perimeter);
	} 

	Input(int l,int b){
		area = l*b;
		perimeter = 2*(l+b);
		System.out.println("Rectangle with Length="+" "+l+" "+"and"+" "+"Breadth ="+" "+b);
		System.out.println("Area ="+" "+area+" "+"Perimeter ="+" "+perimeter);
	} 

	Input(int l,int b,int h){
		volume = l*b*h;
		perimeter = 4*(l+b+h);
		System.out.println("Cuboid with Length="+" "+l+" "+"and"+" "+"Breadth ="+" "+b+" "+"and"+" "+"Height ="+" "+h);
		System.out.println("Volume ="+" "+volume+" "+"Perimeter ="+" "+perimeter);
	} 

}

class Shape{
	public static void main(String args[]){
		int n=args.length,side,breadth,height;
		if(n==0){
			Input p1=new Input();
		}
	
		else if(n==1){
			side=Integer.parseInt(args[0]);
			Input p2=new Input(side);
		}
	
		else if(n==2){
			side=Integer.parseInt(args[0]);
			breadth=Integer.parseInt(args[1]);
			Input p3=new Input(side,breadth);
		}

		else if(n==3){
			side=Integer.parseInt(args[0]);
			breadth=Integer.parseInt(args[1]);
			height=Integer.parseInt(args[2]);
			Input p4=new Input(side,breadth,height);
		}

		else{
			System.out.println("Input Limit Exceeded");	
		}	
	}
}

