package com;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Tests
{

    @Test
    void basicArithmeticTest(){
        Expr testExpr = new Mult(new Plus(new Value(1), new Value(2)),new Value(3));
        assertEquals(9, testExpr.compute());
    }

    @Test
    void basicPrintTest(){
        Expr testExpr = new Mult(new Plus(new Value(1), new Value(2)),new Value(3));
        assertEquals("((1+2)*3)", testExpr.print());
    }

    @Test
    void divZeroTest(){
        try{
            Expr testExpr = new Div(new Value(4), new Value(0));
        }catch(ArithmeticException e){
            assertEquals("Divide by zero error!", e);
        }
    }

    @Test
    void divRemainderTest(){
        try{
            Expr testExpr = new Div(new Value(3), new Value(2));
        }catch(ArithmeticException e){
            assertEquals("Non-integer value in result!", e);
        }
    }


}
