package com;

public class Binary extends Expr
{
    Expr operator;
    Expr left, right;

    int compute(){return operator.compute();}

    String print(){return "(" + left.print() + operator.print() + right.print() + ")";}
}
