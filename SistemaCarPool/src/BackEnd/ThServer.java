/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackEnd;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 *
 * @author Andrés
 */
public class ThServer extends Thread {

    DatagramSocket socket;
    InetAddress address;
    
    public ThServer(InetAddress direccion)
    {
        try
        {
            socket = new DatagramSocket(5000);
            address = direccion;
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
