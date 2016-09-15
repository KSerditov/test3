package ru.kserditov;

public class Lesson1 {

    //enter point for your program
    public static void main(String[] args) {
        if (args.length > 0) {
            int fNum = Integer.parseInt(args[0]);
            Fibo fibo = new Fibo();
            if (fNum > 0) {
                System.out.println(fibo.FindFibo(fNum));
            } else {
                System.out.print("Nothing to show here");
            }
        }
        Dog dg = new Dog(5, 10);
        dg.Bark3();

        // write your code here
       /* System.out.println("Lesson1");

        //everything is child of java.lang.Object
        //fields, properties
        //methods
        Dog dg = new Dog(5, 10); //create new Dog object using custom constructor
        Dog dg2 = new Dog(6, 12);  //create another new Dog object using custom constructor
        dg.Bark2(); //invoke method Bark2 for first Dog object

        int t = dg.Bark(); //get returned value from method Bark for first object
        System.out.println(t);

        String s1 = "Lesson1"; //this created new String object and s1 contains link to this object
        s1 = "Test2"; //this creates new String object and s1 contains link to new String object. Old String object will be removed by Garbadge Collector

        int t1 = 5; //primitive data type stores value directly, not link
        int t2 = t1;
        t1 = t1 + 5;

        System.out.println(t1 + " " + t2);

        Integer it1 = new Integer(5); //variable it1 stores link to new Integer object
        Integer it2 = new Integer(5);

        it1 = new Integer(10);

        System.out.println(it1.toString() + " " + it2.toString());

        if( it1.equals( it2 )){ //this is correct way to compare objects. You will need to define .equals for you custom classes if you need to compare them!

        }

        int[] a1 = new int[5];//define empty array with 5 ints
        int[] a2 = {1,2,3};//define array with values

        Dog[][] dogsArray = new Dog[10][100];//Define multidimensional array of dogs
        Dog newDog = dogsArray[1][3];//Get specific array element

        Dog[] dogs = new Dog[10];

        //populate dogs array with Dog objects
        for (int j = 0; j < 10; j++) {
            dogs[j] = new Dog();
        }

        //foreach cycle with no variable for iteration
        for (Dog d : dogs) {
            d.Bark();
        }

        boolean condition = true;

        //simple if
        if (condition) {

        } else {

        }

        //ternary operator
        String s = condition ? "string1 string1 string1string1string1string1string1string1string1string1string1string1 string1string1 string1" : "string2";
        //this is the same as
        String ss;
        if(condition){
            ss = "string1 string1 string1string1string1string1string1string1string1string1string1string1 string1string1 string1";
        } else {
            ss = "string2";
        }
        */



    }

    // Homework
    // Calculate Fibonacchi numbers:1, 1, 2, 3, 5, 8,...
    // n3 = n2 + n1
    // process: number of fibonacchi numbers for output
    // Example of output for process 5: "1, 1, 2, 3, 5"
    // Example of output for process 8: "1, 1, 2, 3, 5, 8, 13, 21"
    // Additional: Make it as separate class with method which returns string

}
