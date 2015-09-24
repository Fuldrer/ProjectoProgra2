/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ajedrez;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Victor
 */
public class Ajedrez {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner lea= new Scanner(System.in);
        Jugadores usuario;
        int opcion;
        String user, pass;
        boolean salida= false;

        do{
            do{
                System.out.println("\nMENU INICIO\n----------------------");
                System.out.println("Selecione Una Opcion: ");
                System.out.println("\t 1.Login"
                               + "\n\t 2.Crear Player"
                               + "\n\t 3.Salir");
                    try{
                        opcion = lea.nextInt();
                        break;
                    }
                    catch(InputMismatchException e){
                        lea.next();
                        System.out.println("Ingrese un entero");
                    }
            }while(true);
                    
            switch (opcion){

                case 1:
                    System.out.println("Ingrese el Usuario: ");
                    user = lea.next();
                    System.out.println("Ingrese la Contraseña: ");
                    pass = lea.next();
                    usuario= MenuInicio.LogIn(user, pass);
                    if(MenuInicio.LogIn(user, pass) == null){
                        System.out.print("Contraseña incorrecta o");
                        System.out.println(" Jugador no existe");
                    }
                    else{
                        do{
                        MenuPrincipal.subMenu1(usuario);
                        salida = true;
                        }while(salida!=true);
                    }
                    salida = false;
                    break;
      
                case 2:
                    System.out.println("Ingrese el nombre del nuevo usuario: ");
                    user= lea.next();
                    System.out.println("Ingrese la contraseña del nuevo usuario (5 Caracteres): ");
                    pass= lea.next();
                    MenuInicio.CrearJugador(user, pass);
                    break;
                
                case 3:
                    salida= true;
                    break;
                        
                default:System.out.println("Opcion no se encuentra en el menu");
                    }
        }while(salida!=true);
    }
}