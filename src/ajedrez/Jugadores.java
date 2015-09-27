/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ajedrez;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.io.RandomAccessFile;
import java.io.IOException;

/**
 *
 * @author Victor
 */
public class Jugadores {
static ArrayList<Jugadores> jugador = new ArrayList<>();
    private String nombre, contraseña;
    private int puntos;
    private final Calendar fechaC;
    private Jugadores current;
   static RandomAccessFile usuarios;

    private Jugadores(String nom, String pass, Calendar creacion) {
        nombre = nom;
        contraseña = pass;
        puntos = 0;
        this.fechaC= creacion;
        try{
        usuarios = new RandomAccessFile("usuarios.aj", "rw");
        }
        catch(IOException e){
            
        }
    }

    public static Jugadores addJugador(String n, String p) throws IOException {
        usuarios.seek(usuarios.length());
        if (searchJugador(n,p)== null){
            if (p.length() == 5) {
                usuarios.writeUTF(n);
                usuarios.writeUTF(p);
                usuarios.writeLong(new Date().getTime());
                return new Jugadores(n,p,Calendar.getInstance());
                //jugador.add(new Jugadores(n, p,Calendar.getInstance()));
                //System.out.println("Jugador Creado con Exito");
                //return searchJugador(n);
            }
            System.out.println("Longitud de la contraseña no es igual a 5");
            return null;
        }
        System.out.println("Jugador ya existe");
        return null;
    }

    public static Jugadores searchJugador(String n, String p) throws IOException {
        usuarios.seek(0);
        while(usuarios.getFilePointer() < usuarios.length()){
            String c = usuarios.readUTF();
            String a =usuarios.readUTF();
            usuarios.readLong();
            if(n.equals(c) && p.equals(a)){
                return new Jugadores(n,p,Calendar.getInstance());
            }
        }
        return null;
        /*for (Jugadores jug : jugador) {
            if (n.equals(jug.nombre)) {
                return jug;
            }
        }
        return null;*/
    }
    public static ArrayList<Jugadores> getJugador() {
        return jugador;
    }
    public String getNombre() {
        return nombre;
    }
    protected String getPassword(){
        return contraseña;
    }
    protected void setPassword(String con){
        contraseña = con;
    }
    public int getPuntos() {
        return puntos;
    }
    public Date getFechaC() {
        return fechaC.getTime();
    }
    public void eliminarCuenta(){
        nombre = null;
        contraseña = null;
    }
    public void setPuntos(int puntos) {
        this.puntos += puntos;
    }
    public Jugadores getcurrent(){
        return current;
    }
}