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
public class Tablero {
    Ficha [][] tablero = new Ficha[9][9];
    Ficha fichaActual, temp;
    
    public Tablero(){
        //PIEZAS PRINCIPALES BLANCAS
        tablero[0][0] = new Torre(1,"|\u2656|");//Torre
        tablero[0][1] = new Caballo(1,"|\u2658|");//Caballo
        tablero[0][2] = new Alfil(1,"|\u2657|");//Alfil
        tablero[0][3] = new Rey(1,"|\u2655|");//Rey
        tablero[0][4] = new Reina(1,"|\u2654|");//Reina
        tablero[0][5] = new Alfil(1,"|\u2658|");//Alfil
        tablero[0][6] = new Caballo(1,"|\u2657|");//Caballo
        tablero[0][7] = new Torre(1,"|\u2656|");//Torre
        //PEONES BLANCOS
        tablero[1][0] = new Peon(1,"|\u2659|");
        tablero[1][1] = new Peon(1,"|\u2659|");
        tablero[1][2] = new Peon(1,"|\u2659|");
        tablero[1][3] = new Peon(1,"|\u2659|");
        tablero[1][4] = new Peon(1,"|\u2659|");
        tablero[1][5] = new Peon(1,"|\u2659|");
        tablero[1][6] = new Peon(1,"|\u2659|");
        tablero[1][7] = new Peon(1,"|\u2659|");
        //PIEZAS PRINCIPALES NEGRAS
        tablero[7][0] = new Torre(2,"|\u265c|");
        tablero[7][1] = new Caballo(2,"|\u265e|");
        tablero[7][2] = new Alfil(2,"|\u265d|");
        tablero[7][3] = new Rey(2,"|\u265b|");
        tablero[7][4] = new Reina(2,"|\u265a|");
        tablero[7][5] = new Alfil(2,"|\u265d|");
        tablero[7][6] = new Caballo(2,"|\u265e|");
        tablero[7][7] = new Torre(2,"|\u265c|");
        //PEONES NEGROS
        tablero[6][0] = new Peon(2,"|\u265f|");
        tablero[6][1] = new Peon(2,"|\u265f|");
        tablero[6][2] = new Peon(2,"|\u265f|");
        tablero[6][3] = new Peon(2,"|\u265f|");
        tablero[6][4] = new Peon(2,"|\u265f|");
        tablero[6][5] = new Peon(2,"|\u265f|");
        tablero[6][6] = new Peon(2,"|\u265f|");
        tablero[6][7] = new Peon(2,"|\u265f|");
        //NUMEROS PARA LAS POSICIONES DE LAS FICHAS
        tablero[0][8] = new Peon(0,"| 0|");
        tablero[1][8] = new Peon(0,"| 1|");
        tablero[2][8] = new Peon(0,"| 2|");
        tablero[3][8] = new Peon(0,"| 3|");
        tablero[4][8] = new Peon(0,"| 4|");
        tablero[5][8] = new Peon(0,"| 5|");
        tablero[6][8] = new Peon(0,"| 6|");
        tablero[7][8] = new Peon(0,"| 7|");
        
        tablero[8][0] = new Peon(0,"|  0|");
        tablero[8][1] = new Peon(0,"|  1|");
        tablero[8][2] = new Peon(0,"| 2|");
        tablero[8][3] = new Peon(0,"|  3|");
        tablero[8][4] = new Peon(0,"|  4|");
        tablero[8][5] = new Peon(0,"|  5|");
        tablero[8][6] = new Peon(0,"|  6|");
        tablero[8][7] = new Peon(0,"| 7|");
    }
    
    public void printTablero(){
        printTablero(0,0);
    }

    private void printTablero(int x, int y) {
        if(y%9==0 && y !=0){
            System.out.println("");
            printTablero(x+1, y=0);
        }
        else if(x<9 && y<9){
            if(tablero[x][y]!=null){
                System.out.print(tablero[x][y].color);
            }
            else if (tablero[x][y] == null) {
                System.out.print("|__|");
            }
            printTablero(x, y+1);
        }
        
    }
    
    public int validarMovimiento(int x, int y){
           temp = tablero[x][y];
           if(temp !=null){
                if(temp.codigo == fichaActual.codigo){
                    return 3;
                }
           }
           else{
                return 0;
           }
           return 0;
    }
    
    public boolean mover(int a, int b, int x, int y){
        fichaActual = tablero[a][b];
        if(validarMovimiento(x,y)==0){
            if(tablero[x][y] instanceof Rey){
                Jugar.salir2(Jugar.turno);
            }
            tablero[x][y] = tablero[a][b];
            tablero[a][b] = null;
            return true;
        }
        else{
            System.out.println("En esa posicion hay una ficha Aliada");
            return false;
        }
    }

}