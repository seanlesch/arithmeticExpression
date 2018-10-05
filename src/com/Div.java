package com;

public class Div extends Binary
{
    String value = "/";
    Expr left, right;

    Div(Expr left, Expr right){
        this.left = left;
        this.right = right;
    }

    int compute(){
        if(this.right.compute()==0){
            System.out.println("Divide by zero error, no value in expression.");
            return 0;
        }
        else{
            int result = this.left.compute()%this.right.compute();
            if(result != 0)
            {
                System.out.println("Integers not factors for division, no value in expression");
                return 0;
            }
            return this.left.compute()/this.right.compute();
        }
    }

    String print(){return this.value;}
}
