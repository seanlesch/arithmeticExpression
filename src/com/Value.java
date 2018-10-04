package com;

public class Value extends Expression
{
    int number;

    Value(){
        this.number = 0;
    }

    Value(int aNumber){
        this.number = aNumber;
    }

    void print(){
        System.out.print(this.number);
    }
}
