package ru.kserditov;

/**
 * Created by serdi on 13.09.2016.
 */
public class Cat {

    public static int i = 0;//static field - exists without object and can be accesses as Cat.i
    private static int j = 0;
    static Dog dg = new Dog();//composition - including other class objects in this class
    public Dog dg2 = new Dog();
    private Dog dg3 = new Dog();
    final int k = 0;//final - you can't change value of variable anymore after initialization
    public final Dog dg4 = new Dog();//same here, but because gd4 contains link to object, you still able to change object as itself, but not link

    private Cat(){
        i++;
        System.out.println("Default constructor");
        j++;
    }

    public Cat(int i){
        this();//call default constructor Cat()
        System.out.println("int constructor");
        this.i = i;
    }

    public static void Meow(){
       i = i + 1;
    }

    //use method to expose Dog's method for Cat class (useful if you want to make dg3 private variable)
    public void DogBark(){
        dg3.Bark();
    }

    private void Meow(Object... arr){//Object... same as Object[])
        System.out.println(arr[1]);
        dg.Bark();
    }

}
