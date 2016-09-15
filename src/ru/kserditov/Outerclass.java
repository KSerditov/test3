package ru.kserditov;

/**
 * Created by serdi on 15.09.2016.
 */
public class Outerclass {
    int j = 0;


    void Method(){

        class Contents{
            private  int i = 0;
            void Method(){

            }
        }

        Contents cnt = new Contents();

    }

}
