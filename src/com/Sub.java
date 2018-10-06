package com;

public class Sub extends Binary
{
    String value = "-";
    Expr left, right;

    Sub(Expr left, Expr right){
        this.left = left;
        this.right = right;
    }

    int compute(){return this.left.compute()-this.right.compute();}

    String print(){return "(" + this.left.print() + this.value + this.right.print() + ")";}
}
