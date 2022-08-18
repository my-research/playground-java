package com.example;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketListener {
    public Socket listen(ServerSocket serverSocket) throws IOException {
        return serverSocket.accept();
    }
}