package org.iptime.DunDunRST;

public class SingletonExample extends Abstract {

    private static SingletonExample instance;
    public static SingletonExample getInstance() {
        if(instance == null)
            instance = new SingletonExample();

        return instance;
    }

    private SingletonExample() {
        System.out.println("SingletonExample 생성됨");
    }

}
