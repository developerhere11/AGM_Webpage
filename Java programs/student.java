//6
class Student{
	int Rollno;
	String Name;
	int Age;

	Student(int i,String n){
		Rollno = i;
		Name = n;
		}

	Student(int i,String n,int a){
		Rollno = i;
		Name = n;
		Age = a;
		}
	
	void display(){
		System.out.println(Rollno+" "+Name+" "+Age);
		}
	public static void main(String args[]){
		Student s1 = new Student(111,"Sumit");
		Student s2 = new Student(222,"Akshay",19);
		s1.display();
		s2.display();
	}
}

					