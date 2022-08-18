package com.example;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class Client {

    private Socket socket; //클라이언트 소켓
    final static String encodedKey = "0123456789123456"; //AES128 -> 키의 길이 16

    /**
     * ip와 portnumber로 server 소켓에 연결
     *
     * @param ip         접속 ip
     * @param portNumber 접속포트번호
     * @return 성공 여부 ( 0: success, not 0: not success )
     */
    public int clientSocket(String ip, int portNumber) {

        try {
            socket = new Socket(ip, portNumber);  //클라이언트 소켓객체는 생성이 완료되면 해당 서버로 요청신호를 보냄
            boolean result = socket.isConnected(); //연결 성공 여부
            System.out.println("소켓 연결 여부 ? " + result);
            return 1;

        } catch (IOException e) {
            e.printStackTrace(); //예외에 대한 정보 출력
            return 0;
        }
    }

    /**
     * getFile : 요청한 파일을 Server로부터 수신
     *
     * @param fileName 파일 요청
     * @param filePath 파일 수신
     * @return 성공 여부 ( 0: success, not 0: not success )
     */
    public int getFile(String fileName, String filePath) throws Exception {

        try {
            //server에 파일 요청
            DataOutputStream dataOutput = new DataOutputStream(socket.getOutputStream());
            BufferedOutputStream bufferedOutput1 = new BufferedOutputStream(dataOutput);
            bufferedOutput1.write(fileName.getBytes(StandardCharsets.UTF_8));
            bufferedOutput1.flush();

            //파일 수신
            DataInputStream dataInput = new DataInputStream(socket.getInputStream());
            BufferedInputStream bufferedInput = new BufferedInputStream(dataInput);

            System.out.println("---파일 수신 시작---");

            byte[] bData1 = new byte[3];
            int nData;
            bufferedInput.read(bData1);
            String strHeader = new String(bData1, "UTF-8");
            String sct = "SCT";
            if ( sct.equals(strHeader) ) {
                byte[] bData2 = new byte[1368];
                bufferedInput.read(bData2, 0 ,1368);

                ByteArrayInputStream byteInput = new ByteArrayInputStream(bData2);
                ByteArrayOutputStream byteOutput = new ByteArrayOutputStream();

                //헤더 전체 다 복호화 - originalkey로(고정키)
                SecretKey originalKey = new SecretKeySpec(encodedKey.getBytes(), 0, encodedKey.length(), "AES");
                CipherStreamEx cs = new CipherStreamEx();
                cs.CipherFileEx(originalKey, Cipher.DECRYPT_MODE, byteInput, byteOutput);

                //키 부분 read해서 키 추출 한 뒤에
                byte[] bHeader = byteOutput.toByteArray();
                byte[] bHeader1 = new byte[16];
                System.arraycopy(bHeader, 0 ,bHeader1, 0, bHeader1.length);

                //파일 복호화 - 헤더에 있는 randomkey로 복호화
                File file = new File(filePath);
                FileOutputStream fileOutput = new FileOutputStream(file, false);
                BufferedOutputStream bufferedOutput = new BufferedOutputStream(fileOutput);
                SecretKey randomKey = new SecretKeySpec(bHeader1, 0, bHeader1.length, "AES");
                cs.CipherFileEx(randomKey, Cipher.DECRYPT_MODE, bufferedInput, bufferedOutput);

                bufferedOutput.flush();
                bufferedOutput.close();

            } else {

                //암호화된 파일 그대로 수신
                File encfile = new File("enc" + filePath);
                FileOutputStream ecnfileOutput = new FileOutputStream(encfile, false);
                BufferedOutputStream ecnbufferedOutput = new BufferedOutputStream(ecnfileOutput);

                byte[] bData = new byte[1024];
                int nData1;
                while ((nData1 = bufferedInput.read(bData)) != -1) {
                    ecnbufferedOutput.write(bData, 0, nData1);
                }
                ecnbufferedOutput.flush();
                ecnbufferedOutput.close();
            }
            
            bufferedInput.close();
            socket.close();
            return 1;

        } finally {
        }

    }
}
