/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ajedrez;

/**
 *
 * @author Victor
 */
public abstract class Ficha {
    protected int codigo;
    protected String color;

    public Ficha(int codigo, String color) {
        this.codigo = codigo;
        this.color = color;
    }
    
    abstract boolean mover(int x, int y);
}
