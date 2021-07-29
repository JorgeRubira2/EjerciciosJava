package com.jorgerubira.ejerciciosjava.pojo;

public class Pair<T,U> {
    
    private T value0;
    private U value1;

    public Pair(T value0, U value1) {
        this.value0 = value0;
        this.value1 = value1;
    }
    
    public static Pair with(Object value0, Object value1){
        return new Pair(value0,value1);
    }

    public T getValue0() {
        return value0;
    }

    public void setAt0(T value0) {
        this.value0 = value0;
    }

    public U getValue1() {
        return value1;
    }

    public void setAt1(U value1) {
        this.value1 = value1;
    }

    
    
    
}
