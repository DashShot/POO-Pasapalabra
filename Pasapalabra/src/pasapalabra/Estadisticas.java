/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pasapalabra;

import java.io.Serializable;

/**
 *
 * @author aleja
 */
public class Estadisticas implements Serializable {

    private int partidasJ;
    private int partidasG;
    private int partidasE;
    private int partidasP;
    private int puntos;



    public Estadisticas() {

        partidasJ = 0;
        partidasG = 0;
        partidasE = 0;
        partidasP = 0;
        this.puntos = 0;
    }

    public int getPartidasJ() {
        return partidasJ;
    }

    public int getPartidasG() {
        return partidasG;
    }

    public int getPartidasE() {
        return partidasE;
    }

    public int getPartidasP() {
        return partidasP;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPartidasJ(int partidasJ) {
        this.partidasJ = partidasJ;
    }

    public void setPartidasG(int partidasG) {
        this.partidasG = partidasG;
    }

    public void setPartidasE(int partidasE) {
        this.partidasE = partidasE;
    }

    public void setPartidasP(int partidasP) {
        this.partidasP = partidasP;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    @Override
    public String toString() {
        return "Estadisticas{" + "partidasJ=" + partidasJ + ", partidasG=" + partidasG + ", partidasE=" + partidasE + ", partidasP=" + partidasP + ", puntos=" + puntos + '}';
    }

  

}
