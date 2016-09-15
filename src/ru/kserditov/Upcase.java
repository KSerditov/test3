package ru.kserditov;

/**
 * Created by serdi on 15.09.2016.
 */
public class Upcase extends Processor implements IProcessor, IProcessor2, IProcessor2.ISubProcessor2 {
    @Override
    public Object process(Object input) {
        return ((String)input).toUpperCase();
    }

    @Override
    public void process2(Object obj) {

    }

    @Override
    public void subprocess(Object obj) {

    }

    class ExtDog extends Dog {

    }
}
