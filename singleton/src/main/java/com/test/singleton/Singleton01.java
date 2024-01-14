package com.test.singleton;

public class Singleton01 {
    //어플리케이션에서 해당 인스턴스를 사용하지 않더라고 인스턴스를 생성하기 때문에 낭비가 발생 할 수 있음
    private static final Singleton01 instance = new Singleton01();

    public static Singleton01 getInstance() {
        return instance;
    }

    private Singleton01() {};
}
