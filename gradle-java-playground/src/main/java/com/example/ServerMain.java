package com.example;

public class ServerMain {
    public static void main(String[] args) {

        XXXProcessor processor = new XXXProcessor(); //클래스 타입 객체 생성->메서드 호출
        int nRet = processor.doProcess(5000); //메서드 호출
        System.out.println("Connect ret : " + nRet);
    }
}
