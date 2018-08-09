package com.nishant.practice;

public class Test3 {
    static int x() {
        try {
            // int a=0;
            System.out.println("try block");
            // System.exit(0);
            return 1;
            // throw new Exception();
        } catch (Exception e) {
            System.out.println("inside catch");
        } finally {

            System.out.println("finally");
//			return 1;
        }
        return 0;
    }

    public static void main(String[] args) {
        x();
        System.out.println("n");
    }

}
