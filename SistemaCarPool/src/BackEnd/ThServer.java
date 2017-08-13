/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackEnd;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

/**
 *
 * @author Andrés
 */
public class ThServer extends Thread {

    MulticastSocket socket;
    InetAddress address;
    
    public ThServer()
    {
        try
        {
            socket = new MulticastSocket(4446);
            address = InetAddress.getByName("230.0.0.1");
        }
        catch(Exception e)
        {
            System.err.println("error al crear el multicastsocket");
            e.printStackTrace();
        }
    }
    
    public void Receiving()
    {
        byte[] buf = new byte[256];
        try 
        {
            socket.joinGroup(address);
            while(true)
            {
                DatagramPacket packet = new DatagramPacket(buf, buf.length);
                socket.receive(packet);
                String received = new String(packet.getData(), 0, packet.getLength());
                System.err.println("Recibo el mensaje: "+received);
            }
        }
        catch (Exception e)
        {
            System.out.println("Error al recibir el paquete");
            e.printStackTrace();
            System.exit(1);
        }
	socket.close();
    }
	
    public void run ()
    {
        Receiving();
    }

}
