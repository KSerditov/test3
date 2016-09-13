package ru.kserditov;

/**
 * Created by serdi on 06.09.2016.
 */
//Child of base Dog class
public class DogExtended extends Dog {

    //This property was not defined in Dog class, we just add it.
    String name = "";

    //Method Bark was already defined in Dog class, if we want to change it we need to override.
    @Override
    public int Bark(){
        return 0;
    }
}
