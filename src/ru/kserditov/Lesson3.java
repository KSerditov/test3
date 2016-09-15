package ru.kserditov;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by serdi on 15.09.2016.
 */
public class Lesson3 {

    public static void main(String[] args) {

        //Interfaces

        //Let's start with some base class
        Processor pr = new Processor();
        System.out.println(pr.name());

        //class Lowercase extends Processor
        Lowercase lpr = new Lowercase();
        System.out.println(lpr.process(new String("tTt")));

        //class Upcase extends Processor
        Upcase upr = new Upcase();
        System.out.println(upr.process(new String("tTt")));
        //you create new instances of each class and need to call their methods

        // We can, instead, create method process(Processor p, Object s) and
        // provide Upcase or Lowercase as first parameter and object for input as a second one
        // So, logic of method "process" in fact depends on object whis is provided as argument! This is so-called "Strategy" pattern.

        // Now, let's say you have class Dog which is not derived from Processor. So you can't use it with process(Processor p, Object s) method!
        // But you can, instead, use interface IProcessor instead of class Processor. And you can make Dog and Processor implements this interface.
        // As a result, you can use Dog too!
        process(new Upcase(), new String("tTt"));
        process(new Lowercase(), new String("tTt"));
        process(new Dog(), new String("tTt"));

        // Interfaces are often used for built-in classes
        // There is built-in class Scanner which works with Readable interface
        // So you can make Scanner works with your class if you want. Without interface you had to modify Scanner class as itself or create class derived from Scanner.
        // Take a look on my stupid MyClassForScanner implementation in corresponding java file.
        // I was working with it incorrectly during the meeting. My implementation has correct syntax but doesn't do anything.
        // This will be your first homework task.
        Scanner sc = new Scanner(new MyClassForScanner());

        // You can implement multiple interfaces (the only limitation is different names of methods)

        // Please go to Outerclass to learn about inner classes and return here to continue
        // Outerclass object must exists to be able to work with inner class
        Outerclass oc = new Outerclass();
        // here we create new instance of inner class
        Outerclass.Contents occ = oc.new Contents();
        // you can make inner class private and, so, hide all realisation inside. Nobody will be able even to derive from such class.

        // Important thing that I forgot to tell you, sorry!
        // Anonymous classes
        // Let's send few Dogs in parcel, see Parcel.java and come back here
        Parcel p = new Parcel();
        p.newDogInside();

        // You can make interfaces inside interfaces
        // You can make classes inside interfaces!
        // You can make class inside class inside class, etc.
        // You can't extend several classes directly. But your outer class can extend one base class and your inner class can extend another base class. This is a way!


        // Closure (замыкания) - object which can be invoked/called and which has information about context where it has been created. Inner class is a closure because it knows about it's outer class.
        // Using closure you can make 'callback' to its context (or in other words, you can pass link to inner's class object, call it's method which call's outer class method. (Devil created all these things, I guess).

        // Collections
        // array has fixed length
        int[] a = new int[5];
        // Collections or Container has variable length
        //List - list of objects
        //Set - list of objects with no dupes
        //Queue - queue of objects
        //Map - key-pair values (both are some objects or primiitive types)

        // Example, ArrayList for Dogs:
        ArrayList<Dog> lst = new ArrayList<Dog>();
        lst.add(new Dog());
        lst.add(new Dog());
        System.out.println(lst.size());
        lst.remove(0);

        for(Dog d : lst){
            d.Bark();
        }

        // List if interface, ArrayList is implementation
        List<Object> lst2 = new ArrayList<Object>();
        try {
            Dog testdg = (Dog) lst2.get(0);
        } catch(Exception e){

        }

    }

    public static void process(IProcessor p, Object s){
        p.process(s);
    }
}
