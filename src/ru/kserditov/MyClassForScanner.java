package ru.kserditov;

import java.io.IOException;
import java.nio.CharBuffer;

/**
 * Created by serdi on 15.09.2016.
 */
public class MyClassForScanner implements Readable {
    public static int i = 0;

    @Override
    public int read(CharBuffer cb) throws IOException {
        i++;
        if(i < 2) {
            return 1;
        }else
            return 0;
    }
}
