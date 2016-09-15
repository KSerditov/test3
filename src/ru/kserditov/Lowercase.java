package ru.kserditov;

/**
 * Created by serdi on 15.09.2016.
 */
public class Lowercase extends Processor implements IProcessor{
    @Override
    public Object process(Object input) {
        return ((String)input).toLowerCase();
    }
}
