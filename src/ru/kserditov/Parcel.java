package ru.kserditov;

/**
 * Created by serdi on 15.09.2016.
 */
public class Parcel {

    public IDog newDogInside(){
        //this is anonymous class
        return new IDog(){
            private int i = 11;
            public void woof(){
                System.out.println("Woof");
            }
        };
    }

    // This is exactly the same like everything below:
    /*
    class MyDog implements IDog{
        @Override
        public void woof() {
            System.out.println("Woof");
        }
    }

    public IDog newDogInside(){
        return new MyDog();
    }
    */
    // But you don't need to create separate MyDog class - object is created and casted to IDog.
    // You can pass argument to newDogInside() and you can use it in anonymous class constructor.
    // But if you want to use this argument somewhere else in anonymous class (for example you want to assign new field there) when argument must be declared final.
}