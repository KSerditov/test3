package ru.kserditov;

/**
 * Created by serdi on 15.09.2016.
 */
public class Outerclass {
    int j = 0;

    // Contents class is inner class (or class inside other class)
    // You may think this is the same like composition like this
    Dog dg = new Dog();
    // Now dg is inside Outerclass and you can use it's methods

    // However, there is a difference. Inner class can interact with outer class.
    class Contents{
        private  int i = 0;
        void Method(){
            //you can get link to outer class object (using .this)
            Outerclass oc = Outerclass.this;
            //you can invoke method of outer class
            Outerclass.this.Method();
            //you can get outer class field
            int t = Outerclass.this.j;
        }
    }

    void Method(){
        System.out.println("Method");
    }

}
