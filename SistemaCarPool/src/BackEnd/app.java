/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackEnd;

/**
 *
 * @author Andrés
 */
public class app {
    public static void main(String [] arguments)
    {
        try
        {
            ThClient C = new ThClient();
            ThServer S = new ThServer();
            C.start();
            S.start();
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
