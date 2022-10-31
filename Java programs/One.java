package First;

public class One {
   public static void show(){
        System.out.println("INSIDE FIRST PACKAGE ");

    }
}

package Second;


import First.One;

public class Two extends One {
    public static void main(String[] args) {
        show();
    }
}