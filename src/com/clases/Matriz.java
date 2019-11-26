/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.clases;

import java.util.Scanner;

/**nombre de clase: Matriz
 * fecha: 16-04-2019
 * @author: Adilson Arbuez
 * copyRight: Adilson Arbuez
 * version: 1.0
 */
public class Matriz 
{
    static Scanner leer = new Scanner(System.in);
    private int x;  
    private double [][] matriz;

    public Matriz() {
    }

    public Matriz(int x, int y, double[][] matriz) {
        this.x = x;      
        this.matriz = matriz;
    }

    public double[][] getMatriz() {
        return matriz;
    }

    public int getX() {
        return x;
    }

    public void setMatriz(double[][] matriz) {
        this.matriz = matriz;
    }

    public void setX(int x) {
        this.x = x;
    }
    
    public double [][] crear()
    {
        System.out.println("Ingrese la longitud de la matriz cuadrada");
        int x=leer.nextInt();
        setX(x);
        double [][] matriz= new double [x][x];
        
        for(int i=0;i<x;i++)
        {
            for(int j=0; j<x;j++)
            {
                System.out.println("Ingrese el elemento " + (j+1)+" de la fila " + (i+1));
                matriz [i][j]= leer.nextDouble();
            }
        }
        return matriz;
    }
    
    public double sumaDiagonal(double [][] matriz, int x)
    {
        double suma=0;      
        for(int i=0; i<x; i++)
        {
           suma = suma+matriz[i][i];
        }
        return suma;
    }
    
    public double [][] transponer(double [][] matriz, int x)
    {
        double [][] traspuesta = new  double [x][x];
        for(int i=0;i<x;i++)
        {
            for(int j=0; j<x;j++)
            {
                traspuesta [j][i]= matriz[i][j];
            }
        }
        return traspuesta;
    }
    
    public double determinante2x2(double [][] matriz)
    {
        double solucion=0;
        solucion = matriz [0][0]*matriz [1][1] - matriz [1][0]*matriz [0][1];
        return solucion;
    }
    
    public double[][] cofactores(double [][] matriz,int opcion)
    {
        double [][] factor = new double[2][2];
        switch(opcion)
        {
            case 1://i
                for(int i=0;i<2;i++)
                {                  
                  for(int j=0;j<2;j++)
                  {
                    factor[i][j] = matriz [(i+1)][(j+1)];
                  }            
                }
                break;
                
            case 2://j
                for(int i=0;i<2;i++)
                {                  
                  for(int j=0;j<2;j++)
                  {
                      int co = j;
                      if(j==1)
                      {
                        co = 2;  
                      }   
                      factor[i][j] = matriz [(i+1)][co];
                  }            
                }
                break;
                
            case 3://k
                for(int i=0;i<2;i++)
                {                  
                  for(int j=0;j<2;j++)
                  {
                    factor[i][j] = matriz [(i+1)][j];
                  }            
                }
                break;
        }  
        return factor;
    }
    
    public double [] uni(double [][] matriz)
    {
        double [] unit = new double [3];
        
        for(int i=0;i<3;i++)
        {
          unit[i] = matriz [0][i];
        } 
        return unit;
    }
    
    public double determinante3x3(double [][] matriz)           
    {
        double solucion=0;
        double unit [] = uni(matriz);
        solucion = unit [0]*determinante2x2(cofactores(matriz,1)) - unit [1]*determinante2x2(cofactores(matriz,2)) + unit [2]*determinante2x2(cofactores(matriz,3));
        return solucion;
    }
    
    public int identidad(double [][] matriz,int x)
    {
        int identidad=1;
        double suma1=0;
        double suma2=0;
        
        for(int i=0;i<x;i++)
        {
            for(int j=0;j<x;j++)
            {
                if(j==i && matriz [j][j]!=1)
                {
                    identidad=0;
                    break;
                }
                
                else
                {
                   if(j!=i &&matriz [i][j]!=0) 
                   {
                       identidad=0;
                       break;
                   }
                }                
            }
        }
        return identidad;
    }
    
    public int nula(double [][] matriz,int x)
    {
        int nula=1;
        
        for(int i=0;i<x;i++)
        {
            for(int j=0;j<x;j++)
            {
                if(matriz[i][j]!=0)
                {
                    nula=0;
                }
            }
        }
        return nula;
    }
          
    public int menu()
    {
        int opcion=0;
        int v=1;
        do
        {
        if(getX()==2||getX()==3)
        {
           System.out.println("Seleccione una opcion:\n[1] transponer una matriz\n[2]sumar la diagonal de"
                + " la matriz\n[3]imprimir el determinante de una matriz(2x2 & 3x3)\n[4]"
                + "comprobar matriz identidad\n[5]comprobar matriz nula\n[6]ingresar nueva matriz"
                + "\n[7]salir");
           opcion=leer.nextInt();;
           
           if(opcion<0||opcion>7)
           {
               v=0;
           }
        }
        else
        {
           System.out.println("Seleccione una opcion:\n[1] transponer una matriz\n[2]sumar la diagonal de"
                + " la matriz\n[3]"
                + "comprobar matriz identidad\n[4]comprobar matriz nula\n[5]ingresar nueva matriz"
                + "\n[6]salir"); 
           opcion=leer.nextInt();
           if(opcion>=3)
           {
               ++opcion;
           }
           
           if(opcion<0||opcion>6)
           {
               v=0;
           }
        }
        }while(v==0);
        return opcion;
    }
    
    public void print(double [][] matriz, int d)
    {
        System.out.println("\n");
        for(int i=0;i<d;i++)
        {                
            for(int j=0;j<d;j++)
            {
                System.out.print(matriz[i][j]+"  ");
            }
            System.out.println("\n");
        }
    }
}
