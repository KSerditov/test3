package ru.kserditov;

import java.util.LinkedList;

/**
 * Created by serdi on 21.09.2016.
 */
public class Stack<T> {

    LinkedList<T> storage = new LinkedList<T>();

    public void push(T in){
        storage.addFirst(in);
    }

    public T peek(){
        return storage.getFirst();
    }

    public T pop(){
        return storage.removeFirst();
    }

    public boolean empty(){
        return storage.isEmpty();
    }



}
