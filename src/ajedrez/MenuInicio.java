/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ajedrez;

import java.util.Scanner;
import java.io.IOException;

/**
 *
 * @author Victor
 */
public class MenuInicio {

    private static Jugadores jugadorActual;
    public static Scanner lea = new Scanner(System.in);

    public static Jugadores CrearJugador(String user, String pass) throws IOException {
        Jugadores current1 =Jugadores.addJugador(user, pass);
        return current1;
    }

    public static Jugadores LogIn(String usuario, String password) throws IOException {
        Jugadores actual = Jugadores.searchJugador(usuario, password);
        jugadorActual=actual;
        if (actual!= null) {
            if (actual.getPassword().equals(password)) {
                return actual;
            }
        }
        return null;
    }

    public static Jugadores getJugadorActual() {
        return jugadorActual;
    }
}