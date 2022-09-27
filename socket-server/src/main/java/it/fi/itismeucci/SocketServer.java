package it.fi.itismeucci;

import java.io.*;
import java.net.*;

public class SocketServer {
    private ServerSocket server;
    private Socket client;
    private String recv;
    private String modifiedRecv;
    private BufferedReader in;
    private DataOutputStream out;

    public Socket listen() throws IOException
    {
        this.server = new ServerSocket(3390);
        this.client = server.accept();
        this.server.close();
        this.in = new BufferedReader(new InputStreamReader(client.getInputStream()));
        this.out = new DataOutputStream(client.getOutputStream());
        return client;
    }

    public void communicate() throws IOException
    {
        this.recv = in.readLine();
        System.out.print("Stringa ricevuta: " + this.recv);
        this.modifiedRecv = this.recv.toUpperCase();
        out.writeBytes(this.modifiedRecv + '\n');
        this.client.close();
    }
}
