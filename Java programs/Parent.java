public class Parent {
    void show()
    {
        System.out.println("THis is the aprent calss");
    }
}
class child extends Parent{
    void show2()
    {
        System.out.println("This is a child class ");
    }

    public static void main(String[] args) {
        Parent p=new Parent();
        p.show();//calling a methid of parent class by object of parent class
        child c=new child();
        c.show2();//calling a thod of child class by object of child class
        c.show();//calling a method of parent class by object of child class
    }
}
