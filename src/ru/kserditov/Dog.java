package ru.kserditov;

/**
 * Created by serdi on 06.09.2016.
 */
//Base class for all dogs
public class Dog implements IProcessor{

    //Properties (or fields)
    public int age;
    public int tail;

    //Constructor by default
    Dog(){

    }

    //Custom constructor
    Dog(int age, int tail){
        this.age = age; //set object property using value provided as parameter to constructor
        this.tail = tail;   //set object property using value provided as parameter to constructor
       System.out.println("Creating dog");
    }

    //Method 1, returns int
    public int Bark(){
        System.out.println("Barking");
        return age * tail;
    }

    //Method 2, returns nothing
    public void Bark2(){
        Bark();
    }

    protected void Bark3(){
        System.out.println("Bark");
    }

    @Override
    public Object process(Object input) {
        return null;
    }
}
