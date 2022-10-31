class ClassMain{
    void disp(int number){
        System.out.println ("method:" + number);
    }
    void disp(int number1, int number2){
        System.out.println ("method:" + number1 + "," + number2);
    }
    double disp(double number) {
        System.out.println("method:" + number);
        return number;
    }
}

class Compiletimepolymorphism
{
    public static void main (String[] args)
    {
        ClassMain obj = new ClassMain();
        double result;
        obj.disp(40);
        obj.disp(50, 30);
        result = obj.disp(5.1);
        System.out.println("Answer is:" + result);
    }
}