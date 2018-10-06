package com;

/*
Sean Lesch, 2018
This file contains all interesting cases for unit testing the Expr
hierarchy.
 */
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
        Expr testExpr = new Mult(new Plus(new Value(1), new Value(2)), new Value(3));
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

    @Test
    void complexDivisionTest(){
        Expr a = new Div(new Value(16), new Value(4));
        Expr b = new Sub(new Value(9), new Value(1));
        Expr c = new Mult(b, new Value(2));
        Expr testResult = new Div(c, a);
        assertEquals(4, testResult.compute());
    }

    @Test
    void negativeAdditionTest(){
        Expr testResult = new Plus(new Value(-1), new Value(2));
        assertEquals(1, testResult.compute());
    }

    @Test
    void negativeSubtractionTest(){
        Expr testResult = new Sub(new Value(8), new Value(-5));
        assertEquals(13, testResult.compute());
    }

    @Test
    void negativePrintTest(){
        Expr testExpr = new Sub(new Value(8), new Value(-5));
        assertEquals("(8--5)", testExpr.print());
    }

    @Test
    void longExpressionTest(){
        Expr a = new Plus(new Value(56), new Value(188));//244
        Expr b = new Sub(new Value(3), new Value(-78));//81
        Expr c = new Mult(a, new Value(2));//488
        Expr d = new Div(b, new Value(3));//27
        Expr e = new Plus(c, d);//
        assertEquals(515, e.compute());
        assertEquals("(((56+188)*2)+((3--78)/3))", e.print());
    }

}
