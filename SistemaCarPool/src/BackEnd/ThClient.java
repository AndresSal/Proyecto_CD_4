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
    private long FIVE_SECONDS = 5000;
    
    public ThClient() throws IOException
    {
        super("UDPMultiple");
    }

    public void run() 
    {
        while(true)
        {
            try 
            {
               byte[] buf = new byte[256];
                InetAddress group = InetAddress.getByName("230.0.0.1");
                BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
                String message;

                    message = input.readLine();
                    buf=message.getBytes();

                    DatagramPacket packet = new DatagramPacket(buf, buf.length, group, 4446);
                    socket.send(packet);

            } 
            catch (IOException e) 
            {
                e.printStackTrace();
            }
        }
    }
}
