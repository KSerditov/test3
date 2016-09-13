package ru.kserditov;

import java.math.BigInteger;

/**
 * Created by serdi on 06.09.2016.
 */
public class Fibo {

    public String FindFibo(int fNum) {

        String output = "";

        java.math.BigInteger a = BigInteger.valueOf(0);
        BigInteger b = BigInteger.valueOf(1);
        BigInteger fib = BigInteger.valueOf(1);

        for (int i = 0; i < fNum; i++) {
            System.out.print(fib);
            output = output + fib + ", ";
            fib = a.add(b);
            a = b;
            b = fib;
            if (i < fNum - 1) {
                System.out.print(", ");

            }
        }

        return output;

    }

}
