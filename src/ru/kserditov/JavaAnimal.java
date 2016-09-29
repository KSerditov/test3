package ru.kserditov;

/**
 * Created by serdi on 26.09.2016.
 *
 */
public abstract class JavaAnimal {
    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    JavaAnimal(){
        this.age = 0;
    }

    JavaAnimal(int i){
        this.age = i;
    }

    public abstract void makeSound();

    public abstract void run();

}
