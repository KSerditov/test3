package ru.kserditov;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * Created by serdi on 26.09.2016.
 *
 */
public class Lesson6 {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {

        // Let's remind polimorfism
        // JavaAnimal is base class (or interface) for JavaCat and JavaDog
        // So if you have container for JavaAnimal
        LinkedList<JavaAnimal> l = new LinkedList<JavaAnimal>();
        // then you can put JavaDog and JavaCat into it
        l.add(new JavaDog());
        l.add(new JavaCat());
        // and if you get element from this container
        JavaAnimal javaAnimal = l.get(0);
        // you can invoke method which was defined for base class
        // but method logic is selected for specific class
        javaAnimal.makeSound();//here is JavaDog method is executed
        // this is polimorfism - exact class doesn't matter if they have same parent, you can substitute JavaDog with JavaCat and vice versa

        // There is RTTI mechanism - runtime type identification (?)
        // you can get exact class(type) information dynamically during runtime if you want
        // each class you have coded has also related Class object during runtime
        // you can get Class object for your object like this:
        Class cl = l.get(0).getClass();
        // Please see method printClassInfo in the end of this file - it is able to provide information like
        // class name, is this an interface, full class name including package and others
        printClassInfo(cl);
        // You can get Class object for base class for your class's object too:
        Class cl0 = cl.getSuperclass().getSuperclass();
        printClassInfo(cl0);

        // Here is another example
        JavaCat cat = new JavaCat(7);
        printClassInfo(cat.getClass());
        // You also can get Class object by providing class name
        // name should include package (or class should be included into classpath)
        //printClassInfo(Class.forName("JavaDog"));//wrong name!
        printClassInfo(Class.forName("ru.kserditov.JavaDog"));
        Class catClass = cat.getClass();
        Class up = catClass.getSuperclass();
        printClassInfo(up);
        // You even can call default constructor using Class object:
        // catClass.newInstance();

        // You can get Class object using Classname.class syntax:
        Class intClass = Integer.class;
        // Class class is generalized - you can tell compiler which object it works with
        // Here is Class for Integer
        Class<Integer> genIntClass = Integer.class;
        //Class<Number> genNumClass = Integer.class;
        // Or any class
        Class<?> anyClass = Integer.class;
        // Or any class derived from Number
        Class<? extends Number> genNumClass = Integer.class;

        // Now, using RTTI you can identify exact class for object from container
        List<JavaAnimal> ja = new LinkedList<JavaAnimal>();
        ja.add(new JavaCat(3));
        ja.add(new JavaDog(3));
        for( JavaAnimal animal : ja){
            // using instanceof you can check if object is object of some class
            // and then you can cast it without possibility of ClassCastException
            if( animal instanceof JavaDog){
                ((JavaDog) animal).Bark();
            }
        }

        // Here is example of code to generate objects for specified classes
        // First build container
        List<Class<? extends JavaAnimal>> types = new LinkedList<>();//contains Class objects!
        // Now specify possible classes as String array (or you can populate Class objects directly to container
        String[] typesStr = new String[]{JavaCat.class.getCanonicalName(), JavaDog.class.getCanonicalName()};//or JavaDog.class
        // Adding Class objects to container using String array with class names
        for( String type : typesStr ){
            types.add((Class<? extends JavaAnimal>)Class.forName(type));
        }

        Random rn = new Random();
        //Generate Random int from 0 to container size
        int i = rn.nextInt(types.size());
        // Call default constructor to get new object!
        JavaAnimal newJa = types.get(i).newInstance();
        // new Ja is one of JavaDog or JavaCat
        // print information about it:
        System.out.println(newJa);
        System.out.println(JavaDog.class.isInstance(newJa));

        // These are generics and we will talk about them more later
        // Here is just description
        // LinkedList<? extends Integer> - LinkedList for classes derived from Integer
        // LinkedList<? super Integer> - LinkedList for classes which are base for Integer (Number and Object in this case)
        // LinkedList<Integer> - LinkedList for Integers

        // Reflections
        // You can also get list of methods, constructors and fields for class
        Class<?> c = Class.forName(JavaAnimal.class.getCanonicalName());
        Method[] methods = c.getMethods();
        Constructor[] ctors = c.getConstructors();
        Field[] fields = c.getFields();
        for( Method method : methods ){
            System.out.println(method.toString());
        }
        for( Constructor ctor : ctors ){
            System.out.println(ctor.toString());
        }
        for( Field field : fields ){
            System.out.println(field.toString());
        }

        // Interestingly, using reflection you can call any method (even private!) by knowing its name
        //
        // You can disassemble compiled java files using javap - c Lesson6.class and get names from there
        //

        // Why is it helpful?
        // Let's consider so called 'dynamic proxy'
        //
        // Let's say you have type (interface or class) Interface with two methods
        // And you have RealObject which implements this interface (or extends class)
        // And you also have something working with Interface type - method consumer(Interface iface) in our case
        // Now, you want to execute additional code but you can't change Interface, RealObject or method consumer.
        // This is possible because you can have all these things from compiled library
        // In this case you create new class which also implements Interface and has RealObject as field inside it
        // see SimpleProxy code for example - methods executes custom code and then invoke RealObject's methods
        //
        // This is calling RealObject's method without proxy
        consumer(new RealObject());
        // This calls using SimpleProxy. Note, you don't change RealObject or Interface or Consumer method
        consumer(new SimpleProxy(new RealObject()));

        // However, SimpleProxy is not perfect - it works only for Interface type
        // With reflections, it can be done in generic way for any type
        // We use InvokationHandler class from Java and create DynamicProxyHandler class
        // Please see its code
        // Now you can pass any type of object by providing class loader and Class object to it and it redirects methods invokation using reflection
        // So now, instead of
        RealObject real = new RealObject();
        consumer(real);
        // We can call it this way
        Interface realProxy = (Interface) Proxy.newProxyInstance(
                Interface.class.getClassLoader(),
                new Class[]{Interface.class},
                new DynamicProxyHandler(real)
        );// Returns an instance of a proxy class for the specified interfaces that dispatches method invocations to the specified invocation handler.
        consumer(realProxy);

    }

    public static void printClassInfo(Class cc){
        System.out.println("Class name: " + cc.getName());
        System.out.println("Is Interface?: " + cc.isInterface());
        System.out.println("Class simple name: " + cc.getSimpleName());
        System.out.println("Class canonical name: " + cc.getCanonicalName());
    }

    public static void consumer(Interface iface){
        iface.doSomething();
        iface.doSomethingElse("bonobo");
    }

}