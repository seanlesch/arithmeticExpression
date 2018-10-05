package com;

public class Mult extends Binary
{
    String value = "*";
    Expr left, right;

    Mult(Expr left, Expr right){
        this.left = left;
        this.right = right;
    }

    int compute(){return this.left.compute() * this.right.compute();}

    String print(){return this.value;}
}
