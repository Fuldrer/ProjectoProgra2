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
public class MenuPrincipal {
    public static Scanner lea = new Scanner(System.in);
    public static int opcion;
    public static boolean salida = false;
    
    public static void subMenu1(Jugadores jugador){
        do{
            System.out.println("\n   MenuPrincipal\n-----------------");
            System.out.println("1) JUGAR AJEDREZ"
                        +"\n2) MI PERFIL"
                        +"\n3) REPORTES"
                        +"\n4) CERRAR SESION");
            System.out.println("Ingrese una opcion: ");
            try{
                opcion = lea.nextInt();
                break;
            }
            catch(InputMismatchException p){
                lea.next();
                System.out.println("Ingrese un entero");
            }
            catch(Exception e){
                System.out.println("Ingrese una opcion valida dentro del menu");
            }
        }while(true);
        do{
            switch(opcion){
                case 1 :
                    subMenu2(jugador);
                    break;
                case 2 :
                    subMenu3(jugador);
                    break;
                case 3 :
                    subMenu4(jugador);
                    break;
                case 4 :
                    salida = true;
                    break;
                default:
                    subMenu1(jugador);
            }
        }while(salida!=true);    
    }
    
    public static void subMenu2(Jugadores jugador){
        do{
        System.out.println("\n   JUGAR AJEDREZ\n-----------------");
        System.out.println("1) Nueva Partida"
                        +"\n2) Cargar Partida"
                        +"\n3) Eliminar Partida"
                        +"\n4) Transferir Partida"
                        +"\n5) Regresar al menu principal");
        System.out.println("Ingrese una opcion: ");
        try{
        opcion = lea.nextInt();
        break;
        }
        catch(InputMismatchException l){
            lea.next();
            System.out.println("Ingrese un entero");
        }
        catch(Exception o){
            System.out.println("Ingrese una opcion valida del menu");
        }
        }while(true);
        
        switch(opcion){
            case 1:
                Jugar.Play();
                subMenu1(jugador);
                break;
            case 2:
                System.out.println("Disponible en la version FINAL del juego");
                subMenu2(jugador);
                break;
            case 3:
                System.out.println("Disponible en la version FINAL del juego");
                subMenu2(jugador);
                break;
            case 4:
                System.out.println("Disponible en la version FINAL del juego");
                subMenu2(jugador);
                break;
            case 5:
                subMenu1(jugador);
            default:
                subMenu2(jugador);
        }
    }
    
    public static void subMenu3(Jugadores jugador){
        do{
        System.out.println("\n   MI PERFIL\n-----------------");
        System.out.println("1) Ver Mis Datos"
                        +"\n2) Ver Mis Ultimos Juegos"
                        +"\n3) Cambiar Mi Password"
                        +"\n4) Conectar A Facebook"
                        +"\n5) Eliminar Cuenta"
                        +"\n6) Regresar al Menu Principal");
        System.out.println("Ingrese una opcion: ");
        try{
        opcion = lea.nextInt();
        break;
        }
        catch(InputMismatchException r){
            lea.next();
            System.out.println("Ingrese un entero");
        }
        catch(Exception e){
            System.out.println("Ingrese una opcion valida");
        }
        }while(true);
        
        switch(opcion){
            case 1:
                System.out.println("\n   DATOS\n-----------------");
                System.out.println("Nombre: "+jugador.getNombre()
                                +"\nPuntos: "+jugador.getPuntos()
                                +"\nDesde: "+jugador.getFechaC());
                subMenu3(jugador);
                break;
            case 2:
                System.out.println("Disponible en la version FINAL del juego");
                subMenu3(jugador);
                break;
            case 3:
                System.out.println("Ingrese la contraseña actual: ");
                String tem = lea.next();
                if(tem.equals(jugador.getPassword())){
                    System.out.println("Ingrese la nueva contraseña:");
                    String tem2 = lea.next();
                    if(tem2.length() == 5){
                        jugador.setPassword(tem2);
                        System.out.println("Contraseña se cambio con exito");
                        subMenu3(jugador);
                        break;
                    }
                    System.out.println("Longitud de contraseña no es igual a 5");
                    subMenu3(jugador);
                    break;
                }
                System.out.println("Contraseña incorrecta");
                subMenu3(jugador);
                
            case 4:
                System.out.println("Disponible en la version FINAL del juego");
                subMenu3(jugador);
                break;
            case 5:
                System.out.println("Esta seguro que queire eliminar la cuenta?");
                String res = lea.next();
                if(res.equals("si")){
                    jugador.eliminarCuenta();
                    salida = true;
                    break;
                }
                subMenu3(jugador);
            case 6:
                subMenu1(jugador);
            default:
                subMenu3(jugador);
        }
    }
    
    public static void subMenu4(Jugadores jugador){
        do{
        System.out.println("\nREPORTES\n-----------------");
        System.out.println("1) Ranking"
                        +"\n2) Ultimos Juegos Globales"
                        +"\n3) Regresar al Menu Principal");
        System.out.println("Ingrese una opcion: ");
        try{
        opcion = lea.nextInt();
        break;
        }
        catch(InputMismatchException c){
            lea.next();
            System.out.println("Ingrese un entero");
        }
        catch(Exception e){
            System.out.println("Ingrese una opcion valida");
        }
        }while(true);
        
        switch(opcion){
            case 1:
                System.out.println("Disponible en la version FINAL del juego");
                subMenu4(jugador);
                break;
            case 2:
                System.out.println("Disponible en la version FINAL del juego");
                subMenu4(jugador);
                break;
            case 3:
                subMenu1(jugador);
                break;
            default:
                subMenu4(jugador);
        }
    }
}