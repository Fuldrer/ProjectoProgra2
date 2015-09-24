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
public class Jugar {
    private static String name, pass;
    private static Jugadores player1, player2;
    public static int turno = 1;
    static Scanner lea = new Scanner(System.in);
    public static Tablero e;
    public static boolean exit = false;
    
    public static void iniciar(){
        System.out.println("Iniciando Juego de Ajedrez");
        player1 = MenuInicio.getJugadorActual();
        System.out.println("Jugador 1: "+player1.getNombre());
        do{
            System.out.println("Jugador 2");
            System.out.println("Ingrese el nombre: ");
            String n = lea.next();
            player2 = Jugadores.searchJugador(n);
            if(player2 != null){
                if(!(player2.getNombre().equals(player1.getNombre()))){
                    System.out.println("Ingrese el password: ");
                    String p = lea.next();
                    if(player2.getPassword().equals(p)){
                        System.out.println("Jugador 2 Ingresado con exito");
                    }
                    else{
                        System.out.println("Contraseña Incorrecta");
                    }
                }
                else if(player2.getNombre().equals(player1.getNombre())){
                    MenuPrincipal.subMenu2(player1);
                }
            }
            else if(player2 == null){
                System.out.println("Jugador 2 no existe");
                System.out.println("Desea Crear el Jugador 2 ?");
                String r = lea.next();
                if(r.equalsIgnoreCase("si")){
                    System.out.println("Ingrese la contraseña: ");
                    String p = lea.next();
                    player2 = MenuInicio.CrearJugador(n, p);
                }
                else if(r.equalsIgnoreCase("no")){
                    System.out.println("Se regreso al Menu Principal");
                    System.out.println("Debido a que no existe un player 2");
                    MenuPrincipal.subMenu2(player1);
                }
            }
        }while(player2 == null);
        e = new Tablero();
    }
    
    public static void mover(){
        System.out.println("AJEDREZ 2.0\n------------------");
        System.out.println("Jugador: "+turno);
        e.printTablero();
        System.out.println("Ingrese la fila y columna de la ficha que desea mover:");
        System.out.print("Fila: ");
        int a = lea.nextInt();
        System.out.print("Columna: ");
        int b = lea.nextInt();
        if(a==-1 && b==-1 || a==-2 && b==-2){
            retirar(a,b);
        }
        else{
            if(turno == e.tablero[a][b].codigo){
                System.out.println("Ingrese la fila y columna a la cual desea moverse");
                System.out.print("Fila: ");
                int c = lea.nextInt();
                System.out.print("Columna: ");
                int d = lea.nextInt();
                if(c>=0 && d>=0 &&c<8 && d<8){
                    validmove(a,b,c,d,turno);
                }
            }
            else{
                System.out.println("Pieza seleccionada es enemiga");
            }
        }
    }
    
    public static boolean retirar(int x, int y){//valida si el jugador se quiere retirar 
        if(x==-1 && y==-1){                      
            System.out.println("Seguro que deseas retirarte Jugador: " + turno);
            String resp = lea.next();
            if (resp.equalsIgnoreCase("si")) {
                salir(turno);
                exit = true;
                return exit;
            }
            return false;
        }
        else if(x==-2 && y==-2){//Valida si el jugador que quiere guardar la partida es el jugador LogIn
            if(turno==1){
                System.out.println("Partida Guardada");
                exit = true;
                return exit;
            }
            System.out.println("Solo el Jugador 1 puede guardar la partida");
        }
        return false;
    }
    
    public static void salir(int t){//se recibe el turno para evaluar quien se esta retirando
        if(t==1){
            System.out.println("Jugador 2: "+player2.getNombre()+" a ganado. Jugador 1: "+
                                player1.getNombre()+" se retiro de la partida");
            adicionarPuntos(player2);
        }
        else if(t==2){
            System.out.println("Jugador 1: "+player1.getNombre()+" a ganado. Jugador 2: "+
                                player2.getNombre()+" se retiro de la partida");
            adicionarPuntos(player1);
        }
    }
    public static void salir2(int t){
            if(t==2){
            System.out.println("Jugador 2: "+player2.getNombre()+" a ganado. Se a comido al rey del Jugador 1: "+ player1.getNombre());
            adicionarPuntos(player2);
            exit = true;
        }
            else if(t==1){
            System.out.println("Jugador 1: "+player1.getNombre()+" a ganado. Se a comido al rey del Jugador 2: " + player2.getNombre());
            adicionarPuntos(player1);
            exit = true;
            } 
    }
    
    public static void adicionarPuntos(Jugadores ganador){
        ganador.setPuntos(3);
    }
    
    public static void turno(int t){
        if(turno == 1){
            turno = 2;
        }
        else{
            turno = 1;
        }
    }
    
    public static void validmove(int a, int b, int x, int y, int t){
        if(e.mover(a, b, x, y)){
            turno(t);
        }
        else{
            mover();
        }
    }
    
    public static void Play(){
        iniciar();
        do{
            try{
              mover(); 
            }
            catch(InputMismatchException j){
                lea.next();
                System.out.println("Ingrese un entero");
            }
            catch(ArrayIndexOutOfBoundsException a){
                System.out.println("Coordenadas Invalidas");
            }
            catch(NullPointerException f){
                System.out.println("No hay una pieza en esas coordenadas");
            }
            catch(Exception c){
                System.out.println("Error");
            }

        }while(exit!=true);
        exit = false;
        turno = 1;
    }
}