package org.iptime.DunDunRST;

public class Main {

    public static void main(String[] args) {

        // Abstract extend (확장) Example, SingletonExample
        SingletonExample s1 = SingletonExample.getInstance();
        SingletonExample s2 = SingletonExample.getInstance();
        SingletonExample s3 = SingletonExample.getInstance();
        SingletonExample s4 = SingletonExample.getInstance();

        s1.setNumber(2525);

        new ABC().a();
    }

}