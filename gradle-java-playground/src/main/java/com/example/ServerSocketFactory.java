package com.example;

import java.io.IOException;
import java.net.ServerSocket;

public class ServerSocketFactory {
    public ServerSocket getServerSocket(int portNumber) throws IOException {
        return new ServerSocket(portNumber);
    }
}
