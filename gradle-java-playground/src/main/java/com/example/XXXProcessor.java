package com.example;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class XXXProcessor {

    private final ServerSocketFactory factory = new ServerSocketFactory();
    private final SocketListener listener = new SocketListener();

    public int doProcess(int portNumber) {
        try {
            ServerSocket serverSocket = factory.getServerSocket(portNumber);
            while (true) {
                Socket socket = listener.listen(serverSocket);
                extracted(socket);
            }

        } catch (IOException e) {
            e.printStackTrace();
            return 1;
        }
    }

    private void extracted(Socket socket) {
        Runnable run = new SomeClass_XXXXXXXX(socket);
        Thread t = new Thread(run);
        t.start();
    }
}
