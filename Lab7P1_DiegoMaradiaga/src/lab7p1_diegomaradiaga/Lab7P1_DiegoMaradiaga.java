package lab7p1_diegomaradiaga;

import java.util.Scanner;
import java.util.Random;
import javax.swing.JOptionPane;

public class Lab7P1_DiegoMaradiaga {

    static Scanner leer = new Scanner(System.in);
    static Random aleatorio = new Random();
    
    public static void main(String[] args) {

        int opcion = MENU();
        while (opcion != 4) {

            switch (opcion) {
                case 1:{
                    System.out.println("");
                    System.out.print("Ingrese el numero de filas de la matriz: ");
                    int filas = leer.nextInt();
                    
                    System.out.print("Ingrese el numero de columnas de la matriz: ");
                    int columnas = leer.nextInt();
                    
                    int [][] numeros = lectura(filas,columnas);
                    
                    while (filas == columnas) {
                        System.out.println("No se puedenn las mismas filas y columnas!!");
                        System.out.print("Ingrese el numero de filas de la matriz: ");
                        filas = leer.nextInt();

                        System.out.print("Ingrese el numero de columnas de la matriz: ");
                        columnas = leer.nextInt();

                        numeros = lectura(filas, columnas);
                    }
                    
                    System.out.println("La matriz generada es: ");
                    System.out.println(imprimir(numeros));
                    
                    System.out.println("La matriz rotada es:");
                    System.out.println(imprimir(XCgrados(numeros)));
                    
                }break;
                case 2:{
                    System.out.println("");
                    System.out.println("Ingrese el numero de filas de la matriz: ");
                    int filas = leer.nextInt();
                    
                    System.out.println("Ingrese el numero de columnas de la matriz: ");
                    int columnas = leer.nextInt();
                    
                    int [][] numeros = lectura(filas,columnas);
                    
                    System.out.println(imprimir(numeros));
                    System.out.println(NumMag(numeros));
                    
                }break;
                case 3:{
                    System.out.println("");
                    System.out.println("Cadena 1: ");
                    String cadena1 = leer.next();
                    
                    System.out.println("Cadena 2: ");
                    String cadena2 = leer.next();
                   
                    System.out.println("El size de la subsecuencia mas grande es igual a: "+SubSecuencia(cadena1,cadena2));
                }break;
            }
            opcion = MENU();
        }//Fin while

    }//Fin main
    
    public static int MENU (){
        System.out.println("");
        System.out.println("-----------------------------------------");
        System.out.println("              >>>> MENU <<<<             ");
        System.out.println(" ");
        System.out.println("1) Portrait                  ");
        System.out.println("2) Numero magico             ");
        System.out.println("3) Subsecuencia              ");
        System.out.println("4) Salir                     ");
        System.out.print("Ingrese su opcion: ");
        int opcion = leer.nextInt();
        return opcion;
    }
    
    public static int [][] lectura (int filas, int columnas){
        int temporal [][] = new int [filas][columnas];
        
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                temporal [i][j] = 1+ aleatorio.nextInt(9);
            }
        }
        return temporal;
    }//Fin metodo lectura
     
    public static String imprimir(int[][] numeros) {
        String cadena = "";

        for (int i = 0; i < numeros.length; i++) {
            for (int j = 0; j < numeros[i].length; j++) {
                cadena += "["+numeros[i][j]+"]" + " ";
            }
            cadena += "\n";
        }
        return cadena;
    }//Fin metodo imprimir
    
    public static int [][] XCgrados (int[][]matriz){
        int [][] temporal = new int [matriz[0].length][matriz.length];
        
        for (int i = matriz[0].length-1; i >= 0; i--) {
            for (int j = 0; j <= matriz.length-1 ; j++) {
                temporal[i][matriz.length-1-j]= matriz[j][i];
            }
        }
        
        return temporal;
    }//Fin metodo 90 grados
    
    public static String NumMag (int [][] matriz){
        int acumContorno = 0;
        int acumInterno = 1;
        
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (i == 0 || i == matriz.length-1 || j == 0 || j == matriz[i].length-1){
                    acumContorno += matriz[i][j];
                }else{ 
                    acumInterno *= matriz[i][j];
                } 
            }
        }
        
        int Suma = acumContorno+acumInterno;
        String nuMagic = "Op. 1: "+acumContorno+"\nOp. 2 "+acumInterno+"\nEl numero generado: "+Suma;
        
        return nuMagic;
    }//Fin Numero Magico
    
    public static int SubSecuencia (String cadena, String cadena2){
       
        String cadenaN = "-"+cadena;
        String cadenaN2 = "-"+cadena2;
        int [][] temporal = new int [cadenaN.length()][cadenaN2.length()];
        
        for (int i = 0; i < cadenaN.length(); i++) {
            for (int j = 0; j < cadenaN2.length(); j++) {
                if (cadenaN.charAt(i) == '-'||cadenaN2.charAt(j) == '-' ){
                    temporal[i][j]= 0;
                }else if (cadenaN.charAt(i)==cadenaN2.charAt(j)){
                    temporal[i][j]= temporal[i-1][j-1]+1;
                }else {
                    temporal[i][j]= Math.max(temporal[i][j-1], temporal[i-1][j]);
                }
            }
        }
        System.out.println(imprimir(temporal));
        
        int digito = 0;
        for (int i = 0; i < temporal.length; i++) {
            for (int j = 0; j < temporal.length; j++) {
                if (i==temporal.length-1&& j== temporal[0].length-1){
                    digito = temporal[i][j];
                }
            }
        }
        int size = digito;
        return size;
    }
    
    
    
    
}
