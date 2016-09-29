package ru.kserditov;

/**
 * Created by serdi on 29.09.2016.
 */
public class RealObject implements Interface{

    @Override
    public void doSomething() {
        System.out.println("doSomething");
    }

    @Override
    public void doSomethingElse(String arg) {
        System.out.println("doSomethingElse " + arg);
    }

}
