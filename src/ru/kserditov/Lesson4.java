package ru.kserditov;

import java.util.*;
import java.util.logging.Logger;

/**
 * Created by serdi on 21.09.2016.
 */
public class Lesson4 {

    public static void main(String[] args) throws ExceptionDog, NullPointerException {

        //List, Set, Queue are Collections interfaces
        //Example:
        Collection<IDog> coll = new ArrayList<IDog>();
        //ArrayList is realisation of List
        //<IDog> means we preserve IDog objects inside
        //If you don't specify it when it contains type Object

        Integer[] arr = new Integer[]{1,2,3,4,5};//Create array of Integer objects from privitive int type. This is called Boxing. //int -> Integer

        Collection<Integer> col2 = new ArrayList<Integer>();//create empty Collection
        col2.addAll(Arrays.asList(arr));//Populate collection with elements from array

        col2.size();//Get number of elements in collection
        System.out.println(col2);//Print collection elements, you don't need to override toString for collection, it works fine as is.
        // However you still may want to override toString for your objects there.

        Collection<Integer> col3 = new ArrayList<Integer>(Arrays.asList(arr));//Populating collection as initialization (this is slower than above)

        //List implementations:
        //ArrayList - high speed access to elements, but slow insert and delete operations for elements in the middle of list
        //LinkedList - slower access to elements but fast insert and delete in middle of list
        ArrayList<Integer> i = new ArrayList<Integer>();
        i.add(5);//add element
        i.add(3);
        i.add(1);
        System.out.println(i);
        System.out.println(i.get(0));//get element by index and print it
        i.remove(1);//removing element by index

        //get iterator from collection
        //iterator allows to move by collection's elements (and you don't need to know about collection internal structure or about any other details to get elements)
        //iterator can only move forward
        Iterator<Integer> iter = i.iterator();
        iter.next();//get next element
        iter.hasNext();//do we have next element?
        //iterator allows to use foreach syntax

        //You can make your class which implements Iterable intrface and define your own iterator there

        ArrayList<Integer> i3 = new ArrayList<Integer>();
        Set<Integer> i2 = new HashSet<Integer>();
        //you can make method with works just with iterator and so you don't need to know exact type - you can make universal method (like 'display' below)
        display(i3.iterator());
        display(i2.iterator());

        ListIterator<Integer> itl = i.listIterator();//listiterator is another iterator type - allows to move backwards as well

        LinkedList<Integer> ll = new LinkedList<Integer>();
        //Also, LinkedList allows you to implement stack functionality
        //push
        //pop
        //peek
        //empty
        //Please see implementation of Stack class
        Stack stack = new Stack();

        //ArrayList and LinkedList contains values in order in which you put them

        //Set interface doesn't allow duplicates and has following implementations:
        //HashSet
        //TreeSet
        //LinkedHashSet
        testSet();

        Set<String> strset = new TreeSet<String>();
        strset.add("dog");
        strset.add("frog");
        strset.add("cat");

        System.out.println(strset);

        //TreeSet and HashSet elements order is not obvious, it is optimized for internal structure (tree or hash). LinkedHashSet returns elements in insert order like LinkedList.
        //If you want you results sorted - use TreeSet. It's constructor allows to use custom Comparator (will talk more about this later)
        //For objects you need to implement Comparable interface to use with TreeSet, otherwise it can't understand if object is the same or different one.
        //See Cat class and overriden method compareTo for the following example:
        Set<Cat> setcat = new TreeSet<Cat>();
        setcat.add(new Cat(1));
        setcat.add(new Cat(1));
        setcat.add(new Cat(1));
        System.out.println(setcat);

        //Map contains pairs Key - Value
        Map<Integer, Dog> m1 = new HashMap<Integer, Dog>();
        m1.put(new Integer(4), new Dog());
        m1.put(new Integer(5), new Dog());
        m1.put(new Integer(10), new Dog());
        System.out.println(m1);

        //You can have complex objects inside (List of List of Dogs like below)
        Map<Integer, ArrayList<ArrayList<Dog>>> m2 = new HashMap<Integer, ArrayList<ArrayList<Dog>>>();

        //Exceptions
        // please to to method test Exception


        //you can use logger to write exceptions
        //it can be configured for logging into file and for log rotation
        Logger logger = Logger.getLogger("MyApplication");
        //try-catch allows to supress exception and execute something in catch block
        try{
            throw new ExceptionDog();//custom exception (just need to extend Exception class)
        }catch(ExceptionDog e){

        }catch(NullPointerException e){

        }catch(Exception e){
            System.out.println("Catched");
            throw new RuntimeException(e);//you can rethrow exception if you want
            //e has number of methods - you can print StackTrace to console, for example

        } finally {//finally is executed regardless of exception
            System.out.println("Finally");
        }


    }

    public static void testSet(){
        Random rn = new Random();
        Set<Integer> intset = new HashSet<Integer>();
        for(int i = 0; i < 1000; i++){
            intset.add(rn.nextInt(30));
        }
        System.out.println(intset);

    }

    public static void testException(){

        // Exceptions
        // Error - JVM errors
        // checked Exceptions - custom Exception, if you throw it you have to put try-catch or put 'throws MyException' to method signature
        // unchecked Exceptions - RuntimeExceptions
        Dog t = null;
        if ( t == null) {
            //here we throw exception
            throw new NullPointerException("Invoked exception");
        }
    }


    public static void display(Iterator<Integer> it){

        while (it.hasNext()){
            System.out.println(it.next());

        }
    }

}
