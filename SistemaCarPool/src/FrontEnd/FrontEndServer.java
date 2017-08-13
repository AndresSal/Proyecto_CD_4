/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FrontEnd;

import java.net.ServerSocket;
import java.util.ArrayList;

/**
 *
 * @author Andrés
 */
public class FrontEndServer 
{
    public static ArrayList<String> inputqueue= new ArrayList<>();
    public static ArrayList<String> outputqueue= new ArrayList<>();
    public static int requestN;
    
    public static void main (String [] args)
    {
        int port = 5000;
        boolean listening = true;
        try
        {
            ServerSocket FE = new ServerSocket(port);
            while(listening)
            {
                new ThreadServer(FE.accept()).start();
            }
        }catch(Exception e)
        {
            System.out.println("No se pudo establecer conexión en dicho puerto");
        }
    }
}
