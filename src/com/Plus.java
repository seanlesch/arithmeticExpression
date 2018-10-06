package com;
/*
Sean Lesch, 2018
Plus implements the behavior for computing the addition operator.
 */

public class Plus extends Operator
{
    Plus(Expr left, Expr right) {
        this.value = "+";
        this.left = left;
        this.right = right;
    }

    int compute(){return left.compute() + right.compute();}
}
