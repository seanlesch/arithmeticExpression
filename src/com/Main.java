package com;

import java.util.LinkedList;
import java.util.List;

public class Main
{
    static public void main(String [] args){
        Expr a = new Value(10);
        Expr b = new Value(10);
        Expr c= new Value(10);
        Expr d = new Value(10);
        Expr [] values = new Expr[]{a, b, c, d};
        splitAndCompute(values);
    }

    static void splitAndCompute(Expr [] values){

        List<Expr> list1 = new LinkedList<>();
        for(int i = 0; i < values.length/2; i++){
            list1.add(values[i]);
        }
        List<Expr> list2 = new LinkedList<>();
        for(int i = list1.size(); i < values.length; i++){
            list2.add(values[i]);
        }
        buildOuter(list1, list2);

        list1 = new LinkedList<>();
        list2 = new LinkedList<>();
        list1.add(values[0]);
        for(int i = 1; i < 3; i++){
            list2.add(values[i]);
        }
        buildOuter(list1, list2);

        list1 = new LinkedList<>();
        list2 = new LinkedList<>();
        list2.add(values[3]);
        for(int i = 0; i < 3; i++){
            list1.add(values[i]);
        }
        buildOuter(list1, list2);
    }

    static void buildOuter(List<Expr> list1, List<Expr> list2){
        for(int i = 0; i < 4; i ++) {
            try {
                Expr finalExpr = new Plus(build(list1, i), build(list2, i));
                int result = finalExpr.compute();
                if ((0 <= result) && (result <= 9)) {
                    System.out.println(finalExpr.print() + " = " + result);
                }
            }catch(ArithmeticException e){
                System.out.println(e + " One expression of interest removed.");
            }
        }
        for(int i = 0; i < 4; i ++) {
            try {
                Expr finalExpr = new Sub(build(list1, i), build(list2, i));
                int result = finalExpr.compute();
                if ((0 <= result) && (result <= 9)) {
                    System.out.println(finalExpr.print() + " = " + result);
                }
            }catch(ArithmeticException e){
                System.out.println(e + " One expression of interest removed.");
            }
        }
        for(int i = 0; i < 4; i ++) {
            try {
                Expr finalExpr = new Mult(build(list1, i), build(list2, i));
                int result = finalExpr.compute();
                if ((0 <= result) && (result <= 9)) {
                    System.out.println(finalExpr.print() + " = " + result);
                }
            }catch(ArithmeticException e){
                System.out.println(e + " One expression of interest removed.");
            }
        }
        for(int i = 0; i < 4; i ++) {
            try {
                Expr finalExpr = new Div(build(list1, i), build(list2, i));
                int result = finalExpr.compute();
                if ((0 <= result) && (result <= 9)) {
                    System.out.println(finalExpr.print() + " = " + result);
                }
            }catch(ArithmeticException e){
                System.out.println(e + " One expression of interest removed.");
            }
        }
    }

    static Expr build(List<Expr> list, int opChoice){
        if(list.size()==1){
            return list.get(0);
        }
        Expr expression = null;

        if(list.size() == 3) {
            List<Expr> split = new LinkedList<>();
            split.add(list.get(1));
            split.add(list.get(2));
            for (int j = 0; j < 4; j++) {
                expression = new Plus(list.get(0), build(split, opChoice));
            }
            for (int j = 0; j < 4; j++) {
                expression = new Sub(list.get(0), build(split, opChoice));
            }
            for (int j = 0; j < 4; j++) {
                expression = new Mult(list.get(0), build(split, opChoice));
            }
            for (int j = 0; j < 4; j++) {
                expression = new Div(list.get(0), build(split, opChoice));
            }

            split = new LinkedList<>();
            split.add(list.get(0));
            split.add(list.get(1));
            for (int j = 0; j < 4; j++) {
                expression = new Plus(build(split, opChoice), list.get(2));
            }
            for (int j = 0; j < 4; j++) {
                expression = new Sub(build(split, opChoice), list.get(2));
            }
            for (int j = 0; j < 4; j++) {
                expression = new Mult(build(split, opChoice), list.get(2));
            }
            for (int j = 0; j < 4; j++) {
                expression = new Div(build(split, opChoice), list.get(2));
            }
        }

        if(list.size() == 2) {
            if (opChoice == 0) {
                expression = new Plus(list.get(0), list.get(1));

            }
            if (opChoice == 1) {
                expression = new Sub(list.get(0), list.get(1));

            }
            if (opChoice == 2) {
                expression = new Mult(list.get(0), list.get(1));

            }
            if (opChoice == 3) {
                expression = new Div(list.get(0), list.get(1));

            }
        }
        return expression;
    }
}
