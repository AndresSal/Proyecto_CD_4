/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FrontEnd;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

/**
 *
 * @author Andrés
 */
public class TWriter extends Thread
{
    Socket C = null;
    int port;
    String addr;
    InetAddress add;
    
    public TWriter(int puerto, String direccion)
    {    
        port=puerto;
        addr=direccion;
    }
    
    public void Writing()
    {
        try
        {
            Socket C = new Socket(addr, port);
            PrintWriter writer = new PrintWriter(C.getOutputStream(),true);
            BufferedReader StdIN = new BufferedReader(new InputStreamReader(System.in));
            String message;
            while((message=StdIN.readLine())!=null)
            {
                writer.println(message);
            }
        }
        catch(Exception e)
        {
            System.out.println("Error de comunicación");
        }
    }
    
    public void run()
    {
        Writing();
    }
}
