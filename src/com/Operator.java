package com;

/*
Sean Lesch, 2018
Operator is a parent to all the operators, and inherits Expr
methods. It is a means of differentiating between operators
and constants.
 */

public class Operator extends Expr
{
    //In the tree diagram for the execution of an expression,
    //the left and right subtrees of an operator contain either
    //more expressions or a constant value.
    Expr left, right;
    String value; //In the case of the operator the value String
                  // is the operator character.

    Operator(){}

    //The compute class makes no sense in implementation here since
    //we do not know the actual operator until runtime. Thus it
    //returns 0 in this case.
    int compute(){return 0;}

    String print(){return "(" + this.left.print() + this.value + this.right.print() + ")";}
}
