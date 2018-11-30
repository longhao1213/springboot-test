package com.lh.test;

public class B {
 
    public static void main(String[] args) {
 
 
        System.out.println( isRed( Color.BLANK ) ) ;  //结果： false
        System.out.println( isRed( Color.RED ) ) ;    //结果： true
        System.out.println(isBlank(Color.BLANK));

        System.out.println(Color.RED.getName());
        System.out.println(Color.BLANK.getIndex());

        for (Color color : Color.values()) {
            System.out.println(color);
        }
    }
 
 
    static boolean isRed( Color color ){
        if ( Color.RED.equals( color )) {
            return true ;
        }
        return false ;
    }

    static boolean isBlank(Color color) {
        if (Color.BLANK.equals(color)) {
            return true;
        } else {
            return false;
        }
    }
 
}