package com;
/*
Sean Lesch, 2018
The Mult class implements the behavior for computing the multiplication operator.
 */
public class Mult extends Operator
{
    Mult(Expr left, Expr right){
        this.value = "*";
        this.left = left;
        this.right = right;
    }

    int compute(){return this.left.compute() * this.right.compute();}
}
