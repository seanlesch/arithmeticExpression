package com;

/*
Sean Lesch, 2018
Value represents any integer number in the expression.
 */

public class Value extends Expr
{
    int number;

    Value(int aNumber){this.number = aNumber;}

    String print(){return Integer.toString(this.number);}

    int compute(){return this.number;}
}
