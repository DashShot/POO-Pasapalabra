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
public class Jugador implements Serializable {

    private String nombre;
    private String clave;
    protected int puntos;
    protected Estadisticas e;
    protected boolean admin;
    protected boolean turno;

    public Jugador(String n, String c) {
        this.nombre = n;
        this.clave = c;
        puntos = 100;
        Estadisticas est = new Estadisticas();
        this.e = est;
        admin = false;
        turno = false;
    }


    public Jugador() {

    }

    public void mostrarHistorial() {
        System.out.println("Patidas jugadas:" + e.getPartidasJ());
        System.out.println("Patidas ganadas:" + e.getPartidasG());
        System.out.println("Patidas empatadas:" + e.getPartidasE());
        System.out.println("Patidas perdidas:" + e.getPartidasP());
        System.out.println("Puntos:" + e.getPuntos());

    }
public void actualizarPuntos(){

       e.setPuntos(this.getPuntos());
   }

    public int getPuntos() {
        return puntos;
    }

    public String getNombre() {
        return nombre;
    }

    public String getClave() {
        return clave;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Estadisticas getE() {
        return e;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public boolean isTurno() {
        return turno;
    }

    public void setTurno(boolean turno) {
        this.turno = turno;
    }

}
