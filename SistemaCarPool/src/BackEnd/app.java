/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackEnd;

import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.NetworkInterface;

/**
 *
 * @author Andrés
 */
public class app {
    public static InetAddress address;
    public static void main(String [] arguments)
    {
        myBroadCast();
        try
        {
            ThClient C = new ThClient(address);
            ThServer S = new ThServer(address);
            C.start();
            S.start();
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }        
    public static void myBroadCast()
    {
        try
        {
            NetworkInterface network = NetworkInterface.getByName("wlan0");
            for(InterfaceAddress interfaz:network.getInterfaceAddresses())
            {
                InetAddress broadcast=interfaz.getBroadcast();
                if(broadcast==null)
                {
                    continue;
                }else
                {
                    address = broadcast;
                }
            }
            
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }    
}
