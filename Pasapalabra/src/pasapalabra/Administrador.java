/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pasapalabra;

public class Administrador extends Jugador {
    private int puntos;
    private boolean admin;
    public Administrador(String n, String c) {
        super(n, c);
        puntos = 1000000;
        admin= true;
    }

    public int getPuntos() {
        return puntos;
    }




}

