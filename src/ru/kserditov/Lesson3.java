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
        Processor pr = new Processor();
        System.out.println(pr.name());

        Lowercase lpr = new Lowercase();
        System.out.println(lpr.process(new String("tTt")));

        Upcase upr = new Upcase();
        System.out.println(upr.process(new String("tTt")));

        process(new Upcase(), new String("tTt"));
        process(new Lowercase(), new String("tTt"));
        process(new Dog(), new String("tTt"));

        Scanner sc = new Scanner(new MyClassForScanner());


        // Collections
        // array
        int[] a = new int[5];
        //List
        //Set
        //Queue
        //Map
        ArrayList<Dog> lst = new ArrayList<Dog>();
        lst.add(new Dog());
        lst.add(new Dog());
        System.out.println(lst.size());
        lst.remove(0);

        for(Dog d : lst){
            d.Bark();
        }

        ArrayList<Object> lst2 = new ArrayList<Object>();
        try {
            Dog testdg = (Dog) lst2.get(0);
        } catch(Exception e){

        }

    }

    public static void process(IProcessor p, Object s){
        p.process(s);
    }
}
