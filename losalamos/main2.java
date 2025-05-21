package losalamos;

import java.util.*;

class main2{
    public static void main(String[] args){

        Parentclass parent = new Parentclass();
        Childclass child = new Childclass();

        System.out.printf("Parent : %d Child : %d\n", parent.staticnumber, child.staticnumber);

        Parentclass.staticnumber = 500;

        System.out.printf("Parent : %d Child : %d\n", parent.staticnumber, child.staticnumber);


    }
}

class Parentclass{
    public int number;
    public static int staticnumber;

    public Parentclass(){
        number=0;
        staticnumber=10;
    }
}

class Childclass extends Parentclass{
    public Childclass(){
        super();
    }


}