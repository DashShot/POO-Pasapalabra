/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pasapalabra;

import java.io.Serializable;


/**
 *
 * @author Aitor
 */
public class Definicion implements Serializable{

    private String Definicion;

    public Definicion(String definicion) {
        this.Definicion = definicion;
    }

    public String getDefinicion() {
        return this.Definicion;
    }

    public void setDefinicion(String definicion) {
        this.Definicion = definicion;
    }

    @Override
    public String toString() {
        return (this.getDefinicion());
    }
}
