/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pasapalabra;

import java.time.LocalDateTime;
import java.util.Scanner;

/**
 *
 * @author aleja
 */
public class Partida {

    int Accion = 0;
    private int precio;
    private int numPalabras;
    private LocalDateTime fecha;
    private Jugador uno;
    private Jugador dos;
    private Rosco runo;
    private Rosco rdos;
    private Almacen_Palabra ap;
    private Almacen_Palabra ap2;
    private Estadisticas e1;
    private Estadisticas e2;
    int aciertos1 = 0;
    int aciertos2 = 0;
    int fallos1 = 0;
    int fallos2 = 0;

    public Partida(Jugador uno, Jugador dos, int numPalabras, Almacen_Palabra ap, Almacen_Palabra ap2) {
        this.precio = 5;
        this.numPalabras = numPalabras;
        this.uno = uno;
        this.dos = dos;
        this.ap = ap;
        this.ap2 = ap2;
        fecha = LocalDateTime.now();
        uno.setPuntos(uno.getPuntos() - precio);
        dos.setPuntos(dos.getPuntos() - precio);
        Rosco raux1 = new Rosco(numPalabras, ap);
        Rosco raux2 = new Rosco(numPalabras, ap2);
        runo = raux1;
        rdos = raux2;

        e1 = uno.getE();
        e2 = dos.getE();

    }

    public String mostrarPartida() {
        String aux;
        if (aciertos1 > aciertos2) {
            aux = ("Partida de: " + uno.getNombre() + " vs " + dos.getNombre() + "\nEL GANADOR ES: " + uno.getNombre() + " con:(" + aciertos1 + " aciertos y " + fallos1 + " fallos), su rival " + dos.getNombre() + " con: (" + aciertos2 + " aciertos y " + fallos2 + " fallos)");
        } else if (aciertos2 > aciertos1) {
            aux = ("Partida de: " + uno.getNombre() + " vs " + dos.getNombre() + "\nEL GANADOR ES: " + dos.getNombre() + " con: (" + aciertos2 + " aciertos y " + fallos2 + " fallos), su rival " + uno.getNombre() + " con: (" + aciertos1 + " aciertos y " + fallos1 + " fallos)");
        } else if (aciertos1 == aciertos2 && fallos1 < fallos2) {
            aux = ("Partida de: " + uno.getNombre() + " vs " + dos.getNombre() + "\nEL GANADOR ES: " + uno.getNombre() + " con: (" + aciertos1 + " aciertos y " + fallos1 + " fallos), su rival " + dos.getNombre() + " con: (" + aciertos2 + " aciertos y " + fallos2 + " fallos)");
        } else if (aciertos1 == aciertos2 && fallos1 > fallos2) {
            aux = ("Partida de: " + uno.getNombre() + " vs " + dos.getNombre() + "\nEL GANADOR ES: " + dos.getNombre() + " con: (" + aciertos2 + " aciertos y " + fallos2 + " fallos), su rival " + uno.getNombre() + " con: (" + aciertos1 + " aciertos y " + fallos1 + " fallos)");
        } else {
            aux = ("Partida de: " + uno.getNombre() + " vs " + dos.getNombre() + "\nSE HA PRODUCIDO UN EMPATE CON: " + aciertos1 + " aciertos y " + fallos1 + " fallos");
        }
        String rosco1 = "";
        String rosco2 = "";
        for (int i = 0; i < numPalabras; i++) {
            rosco1 = (rosco1 + runo.getPalabras(i).getPalabra() + ", ");
            rosco2 = (rosco2 + rdos.getPalabras(i).getPalabra() + ", ");
        }

        return (aux + "\nEl rosco de " + uno.getNombre() + " constaba de " + numPalabras + " palabras que son: " + rosco1 + "\nEl rosco de" + dos.getNombre() + " constaba de " + numPalabras + " palabras que son: " + rosco2);
    }

    public String EnunciadoJ1(int i) {
        return ("\nTurno de " + uno.getNombre() + "\n Comienza por la letra " + runo.getPalabras(i).getInicial() + ": " + runo.getPalabras(i).getDefinicion(0));
    }

    public String EnunciadoJ2(int i) {
        return ("\nTurno de " + dos.getNombre() + "\n Comienza por la letra " + rdos.getPalabras(i).getInicial() + ": " + rdos.getPalabras(i).getDefinicion(0));
    }

    public Rosco getRuno() {
        return runo;
    }

    public Rosco getRdos() {
        return rdos;
    }

    public String responder(Palabra pr, String r) {
        String aux = new String(pr.getPalabra());
        if (aux.equals(r)) {
            pr.setAcertada(true);
            pr.setFallado(false);
            return ("Respuesta Correcta, pulsa Continuar para seguir jugando");
        } else {
            pr.setAcertada(false);
            pr.setFallado(true);
            return ("Respuesta Incorrecta, la palabra era: " + aux + ", pulsa Continuar para seguir jugando");
        }

    }

    public String Ayuda(Jugador j, Palabra pr) {
        if (j.getPuntos() >= 5) {
            j.setPuntos(j.getPuntos() - 5);

            if (pr.getDefinicion().size() == 1) {

                Letras l = new Letras(pr);
                return (l.mostrarInfo());
            } else {
                SegundaDefinicion s = new SegundaDefinicion(pr);
                return (s.mostrarInfo());

            }
        } else {
            return ("No hay puntos suficientes para comprar pista");
        }

    }

    public String ComprarP(Jugador j, Palabra pr) {

        if (j.getPuntos() >= 20) {
            j.setPuntos(j.getPuntos() - 20);
            Compra c = new Compra(pr);
            return (c.mostrarInfo());

        } else {
            return ("No hay puntos suficientes para comprar palabra");
        }

    }

    public String pasar1(int i) {

        runo.getPalabras(i).setAplazado(true);
        return ("Has pasado palabra, pulsa Continuar para seguir jugando");
    }

    public String pasar2(int i) {
        rdos.getPalabras(i).setAplazado(true);
        return ("Has pasado palabra, pulsa Continuar para seguir jugando");
    }

    public String cambiarTurno() {
        if (runo.isTerminado() && rdos.isTerminado()) {
            return ("\nLos 2 jugadores ya han terminado sus respectivos roscos");
        } else {
            if (uno.isTurno()) {
                if (rdos.isTerminado()) {
                    uno.setTurno(true);
                    return ("Como " + dos.getNombre() + " ya ha terminado su rosco continua jugando " + uno.getNombre());
                } else {
                    dos.setTurno(true);
                    uno.setTurno(false);
                    return ("CAMBIO DE TURNO \nContinua jugando " + dos.getNombre());
                }
            } else if (dos.isTurno()) {
                if (runo.isTerminado()) {
                    dos.setTurno(true);
                    return ("Como " + uno.getNombre() + " ya ha terminado su rosco continua jugando " + dos.getNombre());
                } else {
                    uno.setTurno(true);
                    dos.setTurno(false);
                    return ("CAMBIO DE TURNO \nContinua jugando " + uno.getNombre());
                }
            }

        }
        return("");
    }

    public int repartirPuntos() {

        for (int i = 0; i < numPalabras; i++) {
            if (runo.palabras.get(i).isAcertada() == true) {
                aciertos1++;
            } else if (runo.palabras.get(i).isFallado() == true) {
                fallos1++;
            }
            if (rdos.palabras.get(i).isAcertada() == true) {
                aciertos2++;
            } else if (rdos.palabras.get(i).isFallado() == true) {
                fallos2++;
            }
        }

        if (aciertos1 == numPalabras) {
            uno.setPuntos(uno.getPuntos() + 100);
            e1.setPartidasJ(e1.getPartidasJ() + 1);
            e1.setPartidasG(e1.getPartidasG() + 1);
            e2.setPartidasP(e2.getPartidasP() + 1);
            e2.setPartidasJ(e2.getPartidasJ() + 1);
        } else if (aciertos2 == numPalabras) {
            dos.setPuntos(dos.getPuntos() + 100);
            e2.setPartidasJ(e2.getPartidasJ() + 1);
            e2.setPartidasG(e2.getPartidasG() + 1);
            e1.setPartidasP(e1.getPartidasP() + 1);
            e1.setPartidasJ(e1.getPartidasJ() + 1);
        } else if (aciertos1 > aciertos2) {
            uno.setPuntos(uno.getPuntos() + 10);
            e1.setPartidasJ(e1.getPartidasJ() + 1);
            e1.setPartidasG(e1.getPartidasG() + 1);
            e2.setPartidasP(e2.getPartidasP() + 1);
            e2.setPartidasJ(e2.getPartidasJ() + 1);
        } else if (aciertos2 > aciertos1) {
            dos.setPuntos(dos.getPuntos() + 10);
            e2.setPartidasJ(e2.getPartidasJ() + 1);
            e2.setPartidasG(e2.getPartidasG() + 1);
            e1.setPartidasP(e1.getPartidasP() + 1);
            e1.setPartidasJ(e1.getPartidasJ() + 1);
        } else if (fallos1 > fallos2) {
            dos.setPuntos(dos.getPuntos() + 10);
            e2.setPartidasJ(e2.getPartidasJ() + 1);
            e2.setPartidasG(e2.getPartidasG() + 1);
            e1.setPartidasP(e1.getPartidasP() + 1);
            e1.setPartidasJ(e1.getPartidasJ() + 1);
        } else if (fallos2 > fallos1) {
            uno.setPuntos(uno.getPuntos() + 10);
            e1.setPartidasJ(e1.getPartidasJ() + 1);
            e1.setPartidasG(e1.getPartidasG() + 1);
            e2.setPartidasP(e2.getPartidasP() + 1);
            e2.setPartidasJ(e2.getPartidasJ() + 1);
        } else {
            uno.setPuntos(uno.getPuntos() + 5);
            dos.setPuntos(dos.getPuntos() + 5);
            e1.setPartidasE(e1.getPartidasE() + 1);
            e1.setPartidasJ(e1.getPartidasJ() + 1);
            e2.setPartidasE(e2.getPartidasE() + 1);
            e2.setPartidasJ(e2.getPartidasJ() + 1);
        }
        if (aciertos1 > aciertos2) {
            return 0;
        } else if (aciertos2 > aciertos1) {
            return 1;
        } else if (aciertos2 == aciertos1 && fallos1 < fallos2) {
            return 2;
        } else if (aciertos2 == aciertos1 && fallos2 < fallos1) {
            return 3;
        } else {
            return 4;
        }

    }

    @Override
    public String toString() {
        return "Partida{" + "precio=" + precio + ", numPalabras=" + numPalabras + ", fecha=" + fecha + ", uno=" + uno + ", dos=" + dos + ", runo=" + runo + ", rdos=" + rdos + ", ap=" + ap + '}';
    }

}
