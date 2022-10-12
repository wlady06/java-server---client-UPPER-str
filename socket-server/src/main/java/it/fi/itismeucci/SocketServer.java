package it.fi.itismeucci;

import java.io.*;
import java.net.*;

public class SocketServer {

    public Socket avvia() throws IOException {
        ServerSocket server = new ServerSocket(34567);
        for (;;) {
            Socket client = server.accept();
            communicate(client);
        }
    }

    void communicate(Socket client) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
        DataOutputStream out = new DataOutputStream(client.getOutputStream());
        String recv = in.readLine();
        System.out.print("Stringa ricevuta: " + recv);
        String modifiedRecv = recv.toUpperCase();
        out.writeBytes(modifiedRecv + '\n');
        client.close();

    }
}
