package it.fi.itismeucci;

import java.io.*;
import java.net.*;

public class serverThread extends Thread{
    Socket client;
    serverThread (Socket client)
    {
        this.client = client;
    }
    @Override
    public void run() {
        try {
            communicate(client);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("ciao");
        }
    }
    public void communicate(Socket client) throws IOException {
        String recv = "";
        BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            
        DataOutputStream out = new DataOutputStream(client.getOutputStream());
        while(!recv.toUpperCase().equals("fine")){

            recv = in.readLine();
            if(recv.toUpperCase().equals("spegni"))
            {
                client.close();
            }
            System.out.println(recv);
            System.out.print("Stringa ricevuta: " + recv);
            String modifiedRecv = recv.toUpperCase();
            out.writeBytes(modifiedRecv + '\n');

        }
        client.close();

    }
}
