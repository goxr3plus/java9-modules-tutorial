package pack4;

import pack1.Func;
import pack2.Func2;
import pack3.Func3;

public class Main{

    public static void main(String args[]){
        Func f1 = new Func();
        f1.m1();
        Func2 f2 = new Func2();
        f2.m2();
        Func3 f3 = new Func3();
        f3.m3();
	System.err.println("Hello from useModule");
    }
}