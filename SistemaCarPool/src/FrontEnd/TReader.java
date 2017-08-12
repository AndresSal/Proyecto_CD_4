/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FrontEnd;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Andrés
 */
public class TReader extends Thread
{
    boolean listening = true;
    ServerSocket S = null;
    int port;
    public TReader(int puerto)
    {
        port=puerto;
    }    
    
    public void Listening()
    {
        try
        {
            ServerSocket S = new ServerSocket(port);
            Socket client= S.accept();
            //new TWriter(6000, client.getInetAddress()).start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
            
            while(listening)
            {
                String input=reader.readLine();
                System.out.println(client.getInetAddress()+" dice:"+input);
            }
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
        
    
    public void run()
    {
        Listening();
    }
}
