package com.test.singleton;

public class Singleton04 {
    //getInstance()가 호출되었을 떄 JVM메모리에 로드 되고 인스턴스를 생성함
    private Singleton04() {}

    private static class SingletonHelper {
        private static final Singleton04 INSTANCE = new Singleton04();
    }

    public static Singleton04 getInstance() {
        return SingletonHelper.INSTANCE;
    }
}
