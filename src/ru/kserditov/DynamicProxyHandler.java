package ru.kserditov;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by serdi on 29.09.2016.
 */
public class DynamicProxyHandler implements InvocationHandler {

    private Object proxied;

    public DynamicProxyHandler(Object proxied){
        this.proxied = proxied;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("**** Proxy " + proxy.getClass() + " , method " + method + " , args " + args);
        if(args != null) {
            for (Object arg : args) {
                System.out.println(" " + arg);
            }
        }
        return method.invoke(proxied, args);
    }

}
