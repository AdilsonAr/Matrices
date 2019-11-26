/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.vistas;

import com.clases.Matriz;
import java.util.Scanner;

/**nombre de clase: PruevaMatriz
 * fecha: 16-04-2019
 * @author: Adilson Arbuez
 * copyRight: Adilson Arbuez
 * version: 1.0
 */
public class PruevaMatriz 
{
    public static void main(String [] args)
    {
        Scanner leer = new Scanner(System.in);
        Matriz m=new Matriz();
        int opcion=0;
        do
        {
        double [][] matriz =  m.crear();
        m.print(matriz,m.getX());
        do
        {
        opcion = m.menu();
        switch(opcion)
        {
            case 1:
                m.print(m.transponer(matriz,m.getX()), m.getX());
                break;
                
            case 2:
                System.out.println("la suma es: " + m.sumaDiagonal(matriz, m.getX()));
                break;
                
            case 3:
                if(m.getX()==2)
                {
                    System.out.println("el determinante es: " + m.determinante2x2(matriz));
                }
                else
                {
                    System.out.println("el determinante es: " + m.determinante3x3(matriz));
                }
                break;
                
            case 5:
                if(m.nula(matriz, m.getX())==1)
                {
                    System.out.println("La matriz es nula");
                }
                
                else
                {
                    System.out.println("La matriz no es nula");
                }
                break;
                
            case 4:
                if(m.identidad(matriz, m.getX())==1)
                {
                    System.out.println("La matriz es identidad");
                }
                
                else
                {
                    System.out.println("La matriz no es identidad");
                }
                break;                                           
        }
        }while(opcion!=6&&opcion!=7);
       }while(opcion!=7);
    }

}
