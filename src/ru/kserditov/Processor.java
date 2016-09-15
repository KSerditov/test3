package ru.kserditov;

/**
 * Created by serdi on 15.09.2016.
 */
public class Processor {

    String name(){
        return getClass().getSimpleName();
    }

    Object process(Object input){
        return input;
    }
}
