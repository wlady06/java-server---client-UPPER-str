package it.fi.itismeucci;
import java.io.*;
import java.net.*;
import java.util.*;

public class SocketClient
{
    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;
    private Scanner keyboard = new Scanner(System.in);
    private String userString;
    private String serverString;

    public Socket connect() throws IOException
    {
        this.socket = new Socket(InetAddress.getLocalHost(), 34567);
        this.in = new DataInputStream(socket.getInputStream());
        this.out = new DataOutputStream(socket.getOutputStream());
        this.userString = "";
        return socket;
    }
    
    public void send() throws IOException
    {
        while (true)
        {
            System.out.print("Inserisci la stringa da trasmettere al server" + '\n');
            this.userString = this.keyboard.next();
            
            if(userString.toUpperCase().equals("FINE"))
            {
                break;
            }

            else{
                out.writeBytes(userString + '\n');
                serverString = in.readLine();
                System.out.println("Risposta dal server: " + '\n' + serverString);
            }
            if(serverString.toUpperCase().equals("MORTO"))
            {
                break;
            }
            
        }
        
        socket.close();
    }
}
