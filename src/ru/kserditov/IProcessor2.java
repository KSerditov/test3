package ru.kserditov;

/**
 * Created by serdi on 15.09.2016.
 */
public interface IProcessor2 {

    void process2(Object obj);

    interface ISubProcessor2 {
        void subprocess(Object obj);
    }

    class Test implements IProcessor2{
        @Override
        public void process2(Object obj) {
            System.out.println("");
        }
    }
}
