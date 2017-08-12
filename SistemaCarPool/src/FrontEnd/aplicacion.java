/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FrontEnd;

import java.util.ArrayList;

/**
 *
 * @author Andrés
 */
public class aplicacion {
    public static ArrayList<Integer>PortLists;
    public static void main(String []args)
    {
        int cont=0;
        int MiPuerto= 5000, PuertoS= 6000;
        String direccion="192.168.1";
        TReader s = new TReader(MiPuerto);
        s.start();
            for (int i=1;i<255;i++)
            {
                System.out.println("iteracion "+i);
                if(i!=9)
                {
                    direccion=direccion+"."+i;
                    try
                    {
                        TWriter c = new TWriter(PuertoS, direccion);
                        c.start();
                        cont++;
                    }catch(Exception e)
                    {
                        System.out.println("no pudo conectarse a la direccion "+direccion);
                    }
                }
            }
    }
}
