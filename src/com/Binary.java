package com;

public class Binary extends Expr
{
    Expr operator;
    Expr left, right;

    Binary(){}

    /*Binary(String str, Expr left, Expr right)
    {
        if (str.equals("+"))
        {
            operator = new Plus(left, right);
        } else if (str.equals("-"))
        {
            operator = new Sub(left, right);
        } else if (str.equals("*"))
        {
            operator = new Mult(left, right);
        } else if (str.equals("/"))
        {
            operator = new Div(left, right);
        } else
        {
            System.out.println("Invalid operator: " + str + ", not an expression.");
        }
    }*/

    int compute(){return operator.compute();}

    String print(){return "(" + operator.print() + ")";}
}
