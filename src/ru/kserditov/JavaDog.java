package ru.kserditov;

/**
 * Created by serdi on 26.09.2016.
 */
public class JavaDog extends JavaAnimal {

    JavaDog(){
        super();
    }

    JavaDog(int i) {
        super(i);
    }

    @Override
    public void makeSound() {
        System.out.println("JavaDog is barking!");
    }

    @Override
    public void run() {
        System.out.println("JavaDog is running!");
    }

    public void Bark(){
        makeSound();
    }
}
