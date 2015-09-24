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
public class Peon extends Ficha{

    public Peon(int codigo, String color) {
        super(codigo, color);
    }

    @Override
    boolean mover(int x, int y) {
        return true;
    }
    
    
}
