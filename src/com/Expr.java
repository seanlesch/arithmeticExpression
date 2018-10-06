package com;
/*
Sean Lesch, 2018
Expr is an abstract base class for the rudimentary Object Oriented
arithmetic expression evaluator. All other classes are derived from
Expr.
 */

public abstract class Expr
{
    abstract int compute();
    abstract String print();
}
