/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pasapalabra;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Aitor
 */
public class Almacen_Palabra implements Serializable {

    public Palabra[][] palabra;
    public int length;

    public Almacen_Palabra() {
        Palabra paux[][] = new Palabra[26][50];
        palabra = paux;

    }

    public Palabra getPalabra(int a, int b) {

        Palabra aux = palabra[a][b];
        return aux;
    }

    public void añadirPalabra(Palabra p) {
        char i = p.getInicial();
        int aux = (int) i;
        aux = aux - 65;

        for (int j = 0; j < 50; j++) {
            if (palabra[aux][i] == null) {
                palabra[aux][i] = p;
                break;
            }
        }
    }


    

}
