/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackEnd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.InetAddress;

/**
 *
 * @author Andrés
 */
public class ThClient extends UDPServer
{   
    InetAddress address;
    public ThClient(InetAddress direccion) throws IOException
    {
        address=direccion;
    }

    public void run() 
    {
        Writing();
    }
    
    public void Writing()
    {
        while(true)
        {
            try 
            {
                //get parameters
                byte[] buf = new byte[256];
                BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
                //create message
                String message;
                message = input.readLine();
                buf=message.getBytes();
                //send message
                DatagramPacket packet = new DatagramPacket(buf, buf.length, address, 5000);
                socket.send(packet);
            } 
            catch (IOException e) 
            {
                e.printStackTrace();
            }
        }        
    }
}
