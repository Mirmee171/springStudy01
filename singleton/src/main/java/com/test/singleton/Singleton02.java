package com.test.singleton;

public class Singleton02 {
    //만약 인스턴스가 생성되지 않은 시점에서 여러 쓰레드가 동시에 getInstance를 호출 한다면 단 하나의 인스턴스를 생성한다는 싱글톤 패턴에 위배
    private static Singleton02 instance;

    private Singleton02() {}

    public static Singleton02 getInstance() {
        if (instance == null) {
            instance = new Singleton02();
        }
        return instance;
    }
}
