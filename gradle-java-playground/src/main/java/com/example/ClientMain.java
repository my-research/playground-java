package com.example;

import java.util.Scanner;

public class ClientMain {
    public static void main(String[] args) throws Exception {

        Client client = new Client(); //클래스 타입 객체 생성->메서드 호출
        int nRet = client.clientSocket("localhost", 5000);

        Scanner scanner = new Scanner(System.in);
        System.out.println("> Server에서 전송 받을 파일명을 입력하세요.");
        String fileName = scanner.next();

        System.out.println("> 저장할 파일명을 입력하세요. ");
        String filePath = scanner.next();

        nRet = client.getFile(fileName, filePath);
        System.out.println("Connect ret : " + nRet);
    }
}