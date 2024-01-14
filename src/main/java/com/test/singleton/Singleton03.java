package com.test.singleton;

public class Singleton03 {
    //synchronized 키워드 자체에 대한 비용이 크기 때문에 싱글톤 인스턴스 호출이 잦은 어플리케이션에서는 성능이 떨어짐
    private static Singleton03 instance;

    private Singleton03() {}

    public static synchronized Singleton03 getInstance() {
        if (instance == null) {
            instance = new Singleton03();
        }
        return instance;
    }
}
