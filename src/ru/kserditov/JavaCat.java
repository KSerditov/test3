package ru.kserditov;

/**
 * Created by serdi on 26.09.2016.
 */
public class JavaCat extends JavaAnimal {

    JavaCat(){
        super();
    }

    JavaCat(int i) {
        super(i);
    }

    @Override
    public void makeSound() {
        System.out.println("JavaCat is meowing!");
    }

    @Override
    public void run() {
        System.out.println("JavaCat is running!");
    }

    public void meow(){
        makeSound();
    }
}
