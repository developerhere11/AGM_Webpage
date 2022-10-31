//10
class Doctor {
    int DocId;
    String Name;
    String Department;
    String Specialization;
    String PhNo;
    String Address;
    Doctor(int DocId, String Name, String Department, String Specialization,  String PhNo, String Address){
        this.DocId = DocId;
        this.Name = Name;
        this.Department = Department;
        this.Specialization = Specialization;
        this.PhNo = PhNo;
        this.Address = Address;
    }

    void PrintDoctor(){
        System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-DOCTOR-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
        System.out.println("ID-------------->" + DocId);
        System.out.println("Name------------>" + Name);
        System.out.println("Department------>" + Department);
        System.out.println("Specialization-->" + Specialization);
        System.out.println("PhNo------------>" + PhNo);
        System.out.println("Address--------->" + Address);
    }
}
    class Patient{
        int Id;
        String Name;
        String Sex;
       	int RoomNo;
        String PhNo;
        String Address;
        Patient(int  Id , String Name, String Sex ,int RoomNo, String  PhNo ,String  Address){
            this.Id = Id ;
            this.Name=Name;
            this.Sex=Sex;
            this. PhNo= PhNo;
            this.Address= Address;
            this.RoomNo=RoomNo;
        }
       void PrintPatient(){
            System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-PATIENT-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
            System.out.println("ID------->"+ Id);
            System.out.println("Name----->"+ Name);
            System.out.println("Sex------>"+ Sex);
            System.out.println("RoomNo--->"+ RoomNo);
            System.out.println("PhNo----->"+ PhNo);
            System.out.println("Address-->"+ Address);
	}
}
public class Hospital{
    public static void main(String [] args ){
       Doctor XYZ =new Doctor(101 , "RAM" , "Neuromuscular Disorders", "NEUROLOGY" , "1234567890" , "Delhi");
       XYZ.PrintDoctor();
       Patient ABC = new Patient(902 , "SHYAM" , "Male", 506 ,"0987654321" ,"Jaipur");
       ABC.PrintPatient();
    }
}