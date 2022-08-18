
package com.example;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class SomeClass_XXXXXXXX implements Runnable {

    final static String encodedKey = "0123456789123456";

    private Socket socket;

    public SomeClass_XXXXXXXX(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            File file = getFile();

            SecretKey randomKey = getRandomKey();
            byte[] bKey = randomKey.getEncoded();

            byte[] bData1 = new byte[1024];
            extracted(bKey, bData1, 0);

            String size = String.valueOf(file.length());
            byte[] bDataSize = new byte[30];
            extracted(size.getBytes(StandardCharsets.UTF_8), bDataSize, 0);
            extracted(bDataSize, bData1, bKey.length);

            byte[] bDataDate = new byte[20];
            extracted(generateFileCreatedAtBy(file).getBytes(StandardCharsets.UTF_8), bDataDate, 0);
            extracted(bDataDate, bData1, bKey.length + 30);

            ByteArrayInputStream byteInput = new ByteArrayInputStream(bData1);
            ByteArrayOutputStream byteOutput = new ByteArrayOutputStream();

            SecretKey originalKey = new SecretKeySpec(encodedKey.getBytes(), 0, encodedKey.length(), "AES");
            CipherStreamEx cs = new CipherStreamEx();
            cs.CipherFileEx(originalKey, Cipher.ENCRYPT_MODE, byteInput, byteOutput);

            DataOutputStream dataOutput = new DataOutputStream(socket.getOutputStream());
            BufferedOutputStream bufferedOutput = new BufferedOutputStream(dataOutput);

            bufferedOutput.write("SCT".getBytes(StandardCharsets.UTF_8), 0, 3);
            bufferedOutput.write(byteOutput.toString().getBytes());

            BufferedInputStream bufferedInput = new BufferedInputStream(new FileInputStream(file));
            cs.CipherFileEx(randomKey, Cipher.ENCRYPT_MODE, bufferedInput, bufferedOutput);

            bufferedOutput.flush();
            byteOutput.close();
            bufferedOutput.close();
            bufferedInput.close();
            // fileInput.close();
            dataOutput.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void extracted(byte[] bKey, byte[] bData1, int destPos) {
        System.arraycopy(bKey, 0, bData1, destPos, bKey.length);
    }

    private File getFile() throws IOException {
        DataInputStream dataInput = new DataInputStream(socket.getInputStream());
        byte[] bDataPath = new byte[1024];
        int nRLen = dataInput.read(bDataPath);
        String filePath = new String(bDataPath, 0, nRLen);
        File file = new File(filePath);
        return file;
    }

    private SecretKey getRandomKey() throws NoSuchAlgorithmException {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(128);
        SecretKey randomKey = keyGenerator.generateKey();
        return randomKey;
    }

    private String generateFileCreatedAtBy(File file) throws IOException {
        BasicFileAttributes attrs = Files.readAttributes(file.toPath(), BasicFileAttributes.class);
        FileTime time = attrs.creationTime();
        String pattern = "yyyy-MM-dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String formatted = simpleDateFormat.format(new Date(time.toMillis())) + " ";
        return formatted;
    }

}