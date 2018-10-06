package com;

public class Div extends Binary
{
    String value = "/";
    Expr left, right;

    Div(Expr left, Expr right){
        this.left = left;
        this.right = right;
    }

    int compute() throws ArithmeticException{
        if(this.right.compute()==0){
            throw new ArithmeticException("Divide by zero error!");
        }
        else{
            int result = this.left.compute()%this.right.compute();
            if(result != 0){
                throw new ArithmeticException("Non-integer value in result!");
            }
            return this.left.compute()/this.right.compute();
        }
    }

    String print(){return "(" + this.left.print() + this.value + this.right.print() + ")";}
}
