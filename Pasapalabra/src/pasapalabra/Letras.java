/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pasapalabra;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Aitor
 */
public class Letras extends Pista {

    private Palabra p;
    private static final int PistaL = 5;
    private ArrayList<Integer> numAleatorios;

    public Letras(Palabra o) {
        super(PistaL);
        this.p = o;

    }

    public String mostrarInfo() {

        int aux = p.getPalabra().length() / 3;
        StringBuilder info = new StringBuilder("");
        info.append(p.getPalabra());
        numAleatorios = new ArrayList<Integer>();
        int nAleatorio;
        Random rand = new Random();
        for (int i = 0; i < (p.getPalabra().length() - aux); i++) {
            nAleatorio = rand.nextInt(info.length());

            if (numAleatorios.contains(nAleatorio)) {

                do {
                    nAleatorio = rand.nextInt(info.length());
                } while (numAleatorios.contains(nAleatorio));
                numAleatorios.add(nAleatorio);

            } else {

                numAleatorios.add(nAleatorio);
            }
            info.setCharAt(nAleatorio, '_');
            
        }
        return (info.toString());

    }

}
