package com.example;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.SecretKey;

public class CipherStreamEx {
    static String transformation = "AES/ECB/PKCS5Padding"; //알고리즘/모드/패딩
//AES알고리즘, ECB(Electronic Code Block) Mode 암호화 방식, Padding
//ECB모드 : 평문 블록을 암호화한 것이 그대로 암호문 블록이 됨

    //암호화
    public int encryptFile(SecretKey secretKey, String orgFileName, String encFileName, String decFileName)
            throws Exception {
//try-catch문을 사용하면 오류별로 리턴값을 설정해서 다르게 할 수 있지만 , throws하면 main에 예외가 발생하는 함수를 호출

        File plainFile = new File(orgFileName); //평문 파일
        File encryptFile = new File(encFileName); //암호화 파일
        File decryptFile = new File(decFileName); //복호화 파일

        Cipher cipher = Cipher.getInstance(transformation); //암호화, 복호화 기능을 제공하는 Cipher 클래스
//transformation : 변환이름
        cipher.init(Cipher.ENCRYPT_MODE, secretKey); //암호화 적용
//cipher 객체를 ENCRYPT_MODE(암호화 모드)로 초기화
        InputStream input = null;
        OutputStream output = null;

        try {
            input = new BufferedInputStream(new FileInputStream(plainFile)); //데이터 읽기위한 stream
            output = new CipherOutputStream(new BufferedOutputStream(new FileOutputStream(encryptFile)),
                    cipher); //데이터 보내는 stream
            int read;
            byte[] buffer = new byte[1024];
            while ((read = input.read(buffer)) != -1) {
                output.write(buffer, 0, read);
            }
        } finally { //finally문은 항상 실행
            if (output != null) //할당되어 있을 경우
            {
                try {
                    output.close(); //outputstream close
                } catch (IOException ie) {
                }
            }
            if (input != null) {
                try {
                    input.close(); //inputstream close
                } catch (IOException ie) {
                }
            }
        }
        return 0;
    }

    //복호화
    public int decryptFile(SecretKey secretKey, String orgFileName, String encFileName, String decFileName)
            throws Exception {

        File plainFile = new File(orgFileName);
        File encryptFile = new File(encFileName);
        File decryptFile = new File(decFileName);

        Cipher cipher = Cipher.getInstance(transformation);
        cipher.init(Cipher.DECRYPT_MODE, secretKey); //cipher 객체를 DECRYPT_MODE(복호화 모드)로 초기화

        InputStream input = null;
        OutputStream output = null;
        try {
            input = new CipherInputStream(new BufferedInputStream(new FileInputStream(encryptFile)), cipher);
            output = new BufferedOutputStream(new FileOutputStream(decryptFile));
            int read;
            byte[] buffer = new byte[1024];
            while ((read = input.read(buffer)) != -1) {
                output.write(buffer, 0, read);
            }
        } finally { //finally문은 항상 실행
            if (output != null) {
                try {
                    output.close(); //outputstream close
                } catch (IOException ie) {
                }
            }
            if (input != null) {
                try {
                    input.close(); //inputstream close
                } catch (IOException ie) {
                }
            }
        }
        return 0;
    }

    // mode에 따라 암호화, 복호화
    public int CipherFileEx(SecretKey secretKey, int mode, InputStream bis, OutputStream bos)
            throws Exception {

        Cipher cipher = Cipher.getInstance(transformation); //암호화, 복호화 기능을 제공하는 Cipher 클래스
//Cipher 객체를 인스턴스화 하기 위해서는 static getInstance 메서드를 호출하고, 원하는 변환 형태의 이름을 전달

        cipher.init(mode, secretKey); //cipher 객체를 초기화

        int nBufferSize = 1024;
        if (Cipher.DECRYPT_MODE == mode) {

            int base64Length = (nBufferSize / 3) * 4;
            if (nBufferSize % 3 != 0) {
                base64Length += 4; //int형
            }
            nBufferSize = base64Length;
        }
//nBufferSize = 1368; //Base64 인코딩을 사용하면 33%의 크기 증가 발생 (1024/3) = 341, 341*4=1364
//아스키코드 바이너리 데이터(0과 1의 이진형식) 126개를 64개의 문자로 이루어진 문자열로 변환하는 방법
//base64는 8bit 3개의 문자를 6bit 4개의 문자로 표현
//복호화할때 1366을 읽어줌

        int readCount = -1;
        byte[] input = new byte[nBufferSize];
        byte[] output = new byte[1024];
        byte[] bytesBase64 = null;
//base64로 암호화하는 이유는 nulll값이 포함되어 있을 수도 있어서 그대로 송신할경우 잘리거나 오류가 남

        try {//크기가 1024보다 클 때
            while ((readCount = bis.read(input, 0, nBufferSize)) == nBufferSize) {
                if (Cipher.ENCRYPT_MODE == mode) { //암호화
                    output = cipher.update(input); //암호화하는 부분
                    bytesBase64 = Base64.getEncoder().encode(output);//base64로 암호화
                    bos.write(bytesBase64);
                } else { //복호화
                    String strTemp = new String(input);
                    strTemp = strTemp.replace("==", "");//부족한 문자열에 대해서 '=' 문자가 추가, bit수를 맞춰주기 위해 0으로 채워주는 패딩
                    bytesBase64 = Base64.getDecoder().decode(strTemp.getBytes());
//temp를 이용해서 변수 교환
                    output = cipher.update(bytesBase64);
                    bos.write(output);
                }
            }

//크기가 1024보다 작을 때
            if (readCount > 0) {
                byte[] inputBackup = new byte[readCount];
                inputBackup = Arrays.copyOfRange(input, 0, readCount); //0 ~ readCount 복사

                if (Cipher.ENCRYPT_MODE == mode) { //암호화
                    output = cipher.doFinal(inputBackup); //Cipher 객체를 초기화한 후에, 암호화 또는 복호화 작업을 위해 doFinal() 메서드를 호출
                    bytesBase64 = Base64.getEncoder().encode(output);
                    bos.write(bytesBase64, 0, bytesBase64.length);

                } else { //복호화
                    String strTemp = new String(inputBackup);
                    strTemp = strTemp.replace("==", "");
                    bytesBase64 = Base64.getDecoder().decode(strTemp.getBytes());
//temp를 이용해서 변수 교환

                    output = cipher.doFinal(bytesBase64);
                    bos.write(output, 0, output.length);
                }
            }
        } finally {
        }

        return 0;
    }
}