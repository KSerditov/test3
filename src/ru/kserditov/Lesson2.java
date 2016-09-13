package ru.kserditov;

/**
 * Created by serdi on 13.09.2016.
 */
public class Lesson2 {

        // http://github.com
        // install Git for Windows
        // specify path to git.exe in IntelliJ File - Settings - Source Control - Git
        public static void main(String[] args) {
            int i = 0;
            //i = i + 1;
            i+=1; //short version of i = i + 1;
            i-=1;
            System.out.println(i);

            i++;//postfix increment
            i--;

            ++i;//prefix increment
            --i;

            int a = 0;
            System.out.println(a++);//value is used first for println and is incremented AFTER that
            System.out.println(a);

            int b = 0;
            System.out.println(++b);//value is incremented first and used for println after that

            //logic AND
            if(a > 0 && b > 0){

            }
            //logic OR
            if(a > 0 || b > 0){

            }
            //logic NOT
            if(!(a > 0)){

            }

            //primitive type conversion
            int k = 200;
            long l = k;//no problem since long is larger than int

            long l2 = 200;
            int k2 = (int) l2;//need to convert explicitly because int is smaller - will lead to data loss

            //if you convert from double or float to int the Java just drops fraction part: 12.785 --> 12
            // If you need correct rounding - use Math.round()

            System.out.println("****************");
            label1://label works like goto but in Java it is allowed only in very few cases - for example if you want to quit from cycle inside cycle
            for(int i2 = 0; i2 < 10; i2++){
                if(i2 == 5){
                    continue; //move to next iteration
                }else {
                    System.out.println(i2);
                }
                if(i2 == 7) {
                    break; //stops cycle execution
                }
            }

            //example of using switch operator
            char c = 'x';
            switch(c){
                case 'a': System.out.println("a");
                    break;
                case 'b': System.out.println("b");
                default: System.out.println("Default");
            }

            //example of work with static variable
            //static variable is the same between all objects of class
            Cat cat1 = new Cat(5);
            Cat cat2 = new Cat(5);

            System.out.println(Cat.i);

            cat1.Meow();

            System.out.println(Cat.i);

            cat2.Meow();

            cat1.dg2.Bark();

            System.out.println(Cat.i);

            Cat.Meow();

            System.out.println(Cat.i);

            //public
            //protected
            //< >
            //private

            //polimorphism
            //Piano and Guitar are childs of Instrument
            //if you have method working with Instrument you can use it with it's childs too!
            Piano i1 = new Piano();
            Guitar i2 = new Guitar();
            Play(i1);
            Play(i2);

            //upcasting - Piano=>Instrument, this is also happens above
            Instrument ins = i1;

            Instrument instr2 = new Piano();//and here too
            Piano p1 = (Piano) instr2;//downcasting must be explicit. Throws exception if instr2 is not really Piano.

        }

        //example method which uses Instrument (and you can pass Piano and Guitar as parameter)
        public static void Play(Instrument i){
            i.play();
        }
}
