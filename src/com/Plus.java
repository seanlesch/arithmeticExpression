package com;

public class Plus extends Binary
{
    String value = "+";
    Expr left, right;

    Plus(Expr left, Expr right)
    {
        this.left = left;
        this.right = right;
    }

    String print(){return this.value;}

    int compute(){return left.compute() + right.compute();}
}
