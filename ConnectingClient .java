// Client class
// Version 1
// Chris Weightman 12/11/20

import java.net.*;
import java.util.Scanner;
import java.io.*;

public class ConnectingClient
{
    public static void main(String[] args){
        //Scanner mainScanner = new Scanner(System.in);
        String serverName = "localhost";
        int port = 12345;
        
        try {
            System.out.println("Connecting to "+ serverName +" on port " + port);
            Socket client = new Socket(serverName, port);
         
            System.out.println("Just connected to " + client.getRemoteSocketAddress());
            OutputStream outToServer = client.getOutputStream();
            DataOutputStream out = new DataOutputStream(outToServer);
         
            out.writeUTF("Hello from " + client.getLocalSocketAddress());
            InputStream inFromServer = client.getInputStream();
            DataInputStream in = new DataInputStream(inFromServer);
         
            System.out.println("Server says " + in.readUTF());
            client.close();
        } 
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
