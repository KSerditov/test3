package ru.kserditov;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by serdi on 23.09.2016.
 *
 */
public class Lesson5 {

    public static void main(String[] args) {

        // Strings
        String s = "abc";//simple String initialization
        "abc".length();//"abd" is also String object and you can call String's methods for it
        s = s + "d";//When you modify String you create new String object, not modifying old one!
        //Because of this it is bad practice to use String if you need to modify it frequently. For example:
        for (int i = 0; i < 10000; i++) {
            s = s + Integer.toString(i);
        }

        //Use instead:
        //StringBuffer
        //StringBuilder - this is available starting from Java 5 and it is most commonly used now:
        StringBuilder sb = new StringBuilder("abc");
        for (int i = 0; i < 10000; i++) {
            sb = sb.append(i);// append works as "+" for Strings
        }

        //If you need to append parameter to String and print result
        int x = 1;

        //you can do this
        String str = "Test string with cats. " + x;
        System.out.println(str);

        //or you can work with printf (or format) method
        System.out.printf("Test string %d with cats. ", x);
        //%d means integer number, %s is a string, %f - float, there are also %c, %b, %e, %x, %h
        //learn Formatter class for full list of specificators and available format options
        //Please note that String also has format method which returns formatted String

        System.out.println("\n***************Regexp examples below**************");

        //Regular expressions are used for generic description of string and you can make search (or replace) with them
        //Some examples:

        // -? means there is or there is no '-' symbol
        System.out.println("-".matches("-?"));
        // \\d means there is one number
        System.out.println("8".matches("\\d"));
        // \\d+ means there is one or more numbers
        System.out.println("1234".matches("\\d+"));
        // . means any symbol
        System.out.println("abrwalg1234".matches(".+\\d+"));
        // brackets with pipe means OR
        // (\\d+|a)
        System.out.println("1234".matches("(\\d+|abc)"));
        System.out.println("abc".matches("(\\d+|abc)"));
        // \\W means non-word symbol (for example '&%^$#!$%*() etc)
        System.out.println("&".matches("\\W"));
        // \\w means word symbol
        System.out.println("k".matches("\\w"));
        // ^ means start of string
        System.out.println("cats".matches("^ca.+"));
        // ^ means end of string
        System.out.println("cats".matches(".+ts$"));
        // [abc] means any of a, b or c
        System.out.println("c".matches("[abc]"));
        // [a-d] means any of a, b, c or d
        System.out.println("c".matches("[abc]"));
        // \\s means any kind of space (whitespace, tab, new line, carriage return)
        System.out.println(" ".matches("\\s"));
        // {n} - exactly n times
        System.out.println("aaaa".matches("a{4}"));
        // {n,} - not less than n times
        System.out.println("aaaaa".matches("a{4,}"));
        // {n,m} - not less than n times and not more than m times
        System.out.println("aaaaaaa".matches("a{4,9}"));

        //.matches is String's method
        String s1 = "asdffgdfg890";
        // you can split String to String array using regexp
        // by letter 'd' in this example
        String[] strarr = s1.split("d");
        for (String ss : strarr) {
            System.out.println(ss);
        }

        // String's .matches method is slow. Use Pattern class instead. It also provides more functionality:
        Pattern ptn = Pattern.compile("\\d");//find any number
        Matcher m = ptn.matcher("234 cats cats cats 567");
        while (m.find()) {
            System.out.println("Found " + m.group() + " at position " + m.start());
        }

        // A(B(C))D brackes define groups. If there are no brackets, there is one group with index 0.
        // You can get matches for groups. Example above is equals to:
        m.reset();
        while (m.find()) {
            System.out.println("Found " + m.group(0) + " at position " + m.start());
        }
        // For A(B(C))D indexes are following:
        // ABCD = 0
        // BC = 1
        // C = 2
        System.out.println("***********group example************");
        Pattern ptn2 = Pattern.compile("(ca)ts");//find any number which has following symbol. note there is group defined
        Matcher m2 = ptn2.matcher("234 cats cats cats 567");
        while (m2.find()) {
            System.out.println("Found " + m2.group(0) + " at position " + m2.start(0));
        }
        //now lets get another group
        m2.reset();
        while (m2.find()) {
            System.out.println("Found " + m2.group(1) + " at position " + m2.start(1));
        }

        // Note that Pattern constructor has number of flags. For example, Pattern.DOTALL means that . matches ANY symbol
        // including end of line. By default it is not matched.
        // You can study all possible values in Pattern class as usual.
        Pattern ptn3 = Pattern.compile("[fg[h-l]]", Pattern.DOTALL);

    }
}
