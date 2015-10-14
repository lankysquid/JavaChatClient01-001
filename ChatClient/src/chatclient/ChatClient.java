/**
 *
 * @author stefan
 */
package chatclient;

import java.net.*;
import java.io.*;
import java.util.Scanner;

public class ChatClient {
    private Socket socket = null;
    private DataInputStream console = null;
    private DataOutputStream streamOut = null;
    
    public ChatClient (String serverName, int serverPort)
    {
        System.out.println("Establishing connection. please wait ...");
        try 
        {
            socket = new Socket(serverName, serverPort);
            System.out.println("Connected: " + socket);
            start();
        }
        catch(UnknownHostException uhe)
        {
            System.out.println("Host Unknown: " + uhe.getMessage());  
        }
        catch (IOException ioe)
        {
            System.out.println("Unexpected Exception: " + ioe.getMessage());
        }
        String line = "";
        while (!line.equals(".bye"))
        {
            try
            {
                System.out.println("You: ");
                Scanner keyboard = new Scanner(System.in);
                line = keyboard.nextLine();
                streamOut.writeUTF(line);
                streamOut.flush();
            }
            catch (IOException ioe)
            {
                System.out.println("Sending error: " + ioe.getMessage());
            }
        }
    }
    public void start() throws IOException
    {
        console = new DataInputStream(System.in);
        streamOut = new DataOutputStream(socket.getOutputStream());
    }
    public void strop()
    {
        try
        {
            if (console != null) console.close();
            if (streamOut != null) streamOut.close();
            if (socket != null) socket.close();
        }
        catch (IOException ioe)
        {
            System.out.println("Error cloasing ...");
        }
        
    }
}

