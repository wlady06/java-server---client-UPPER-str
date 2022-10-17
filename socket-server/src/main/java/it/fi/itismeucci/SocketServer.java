package it.fi.itismeucci;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer  {
    public Socket avvia() throws IOException {
        ServerSocket server = new ServerSocket(34567);
        ManagementServerThread m = new ManagementServerThread(server);

        for (;;) {
            Socket client = server.accept();
            m.addClient(client);
            ServerThread t = new ServerThread(client, m,server);
           
           
            t.start();   
        }
    }

    
}
