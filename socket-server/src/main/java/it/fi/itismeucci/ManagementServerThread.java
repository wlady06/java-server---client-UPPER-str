package it.fi.itismeucci;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ManagementServerThread extends Thread
{
    ArrayList<ServerThread> clientsArray = new ArrayList<ServerThread>();
    
    public ManagementServerThread () { }
    public void addThread(ServerThread thread)
    {
        clientsArray.add(thread);
    }
    public void closeClients(ServerSocket server) throws IOException
    {
        for (ServerThread thread : clientsArray) {
            
            thread.closeClient();
            System.out.println("chiuso");

        }
        server.close();

    }

}
