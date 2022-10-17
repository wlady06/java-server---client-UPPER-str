package it.fi.itismeucci;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerThread extends Thread{
    public Socket client;
    public ManagementServerThread m;
    public  ServerSocket server;

    ServerThread (Socket client, ManagementServerThread m, ServerSocket server)
    {
        this.client = client;
        this.m = m;
        this.server = server;
    }
    @Override
    public void run() {
        try {
            communicate();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            
        }
    }
    public void communicate() throws IOException {

        String recv = "";
        BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
        DataOutputStream out = new DataOutputStream(client.getOutputStream());

        while(!recv.toUpperCase().equals("FINE")){

            recv = in.readLine();
            if(recv.toUpperCase().equals("SPEGNI"))
            {

                m.closeClients(server);
                return ;
            }
            System.out.println(recv);
            System.out.println("Stringa ricevuta: " + recv);
            String modifiedRecv = recv.toUpperCase();
            out.writeBytes(modifiedRecv + '\n');

        }
        client.close();

    }
    public void closeClient() throws IOException{
        this.client.close();

    }
}
