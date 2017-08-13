/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import static java.lang.System.out;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Collections;
import java.util.Enumeration;

/**
 *
 * @author lsalazar
 */
public class ListNets {
    public static void main (String [] args) throws SocketException{
        Enumeration <NetworkInterface> nets = NetworkInterface.getNetworkInterfaces();
        for(NetworkInterface count:Collections.list(nets))
        {
            displayInterfaceInformation(count);
        }
    }
    
    static void displayInterfaceInformation(NetworkInterface count) throws SocketException
    {
        out.printf("Display name: %s \n", count.getDisplayName());
        out.printf("Name: %s\n",count.getName());
        Enumeration <InetAddress> address = count.getInetAddresses();
        for(InetAddress iadd:Collections.list(address))
        {
            out.printf("InetAddress: %s\n", iadd);
        }
        System.out.println("\n");
    }
}
