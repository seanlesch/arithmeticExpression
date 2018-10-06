package com;

/*
Sean Lesch, 2018
The Sub class implements the behavior for computing the subtraction operator.
 */

public class Sub extends Operator
{
    Sub(Expr left, Expr right){
        this.value = "-";
        this.left = left;
        this.right = right;
    }

    int compute(){return this.left.compute()-this.right.compute();}

    //String print(){return "(" + this.left.print() + this.value + this.right.print() + ")";}
}
