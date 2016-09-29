package ru.kserditov;

/**
 * Created by serdi on 29.09.2016.
 */
public class SimpleProxy implements Interface {

    private Interface proxied;

    public SimpleProxy(Interface proxied){
        this.proxied = proxied;
    }

    @Override
    public void doSomething() {
        System.out.println("SimpleProxy doSomething");
        proxied.doSomething();
    }

    @Override
    public void doSomethingElse(String arg) {
        System.out.println("SimpleProxy doSomethingElse " + arg);
        proxied.doSomethingElse(arg);
    }

}
