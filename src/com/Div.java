package com;
/*
Sean Lesch, 2018
The Div class implements the behavior for computing the division operator.
 */
public class Div extends Operator
{
    Div(Expr left, Expr right){
        this.value = "/";
        this.left = left;
        this.right = right;
    }

    int compute() throws ArithmeticException{
        if(this.right.compute()==0){ //Checking if the denominator is zero.
            throw new ArithmeticException("Divide by zero error!");
        }
        else{
            //Taking the modulus of the division terms tells if the terms are
            //factors if there is no remainders. If we receive a non-zero
            //result we leave the capability of integers.
            int result = this.left.compute()%this.right.compute();
            if(result != 0){
                throw new ArithmeticException("Non-integer value in result!");
            }
            return this.left.compute()/this.right.compute();
        }
    }
}
