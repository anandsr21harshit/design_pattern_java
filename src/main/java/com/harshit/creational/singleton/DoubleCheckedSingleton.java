package com.harshit.creational.singleton;

import java.lang.reflect.Constructor;

public class DoubleCheckedSingleton {

    private static volatile DoubleCheckedSingleton instance;

    private DoubleCheckedSingleton(){}

    public DoubleCheckedSingleton getInstance(){
        if(instance == null){
            synchronized (DoubleCheckedSingleton.class){
                if(instance == null){
                    instance = new DoubleCheckedSingleton();
                }
            }
        }
        return instance;
    }
}
