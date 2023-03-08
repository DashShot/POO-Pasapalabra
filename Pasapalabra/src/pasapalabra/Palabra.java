/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pasapalabra;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Aitor
 */
public class Palabra implements Serializable{

    private char inicial;
    private StringBuilder palabra;
    private boolean acertada;
    private boolean fallado;
    private boolean aplazado;;
    private ArrayList<Definicion> definicion;

    public ArrayList<Definicion> getDefinicion() {
        return definicion;
    }


    public Palabra(StringBuilder p, Definicion d) {

        setAplazado(false);
        setAcertada(false);
        setFallado(false);

        this.palabra = p;
        this.inicial = p.charAt(0);
        definicion = new ArrayList<Definicion>();
        definicion.add(d);

    }
    public Palabra(){
        setAplazado(false);
        setAcertada(false);
        setFallado(false);
    }

    @Override
    public String toString() {
        return "Palabra{" + "inicial=" + inicial + ", palabra=" + palabra + ", acertada=" + acertada + ", fallado=" + fallado + ", aplazado=" + aplazado + ", definicion=" + definicion + '}';
    }

    public String mostrar() {
        if (fallado == true) {
            return("Palabra: " + palabra + "\n"+"Definicion: " + definicion.get(0).getDefinicion() + " ha sido fallada");
        } else {                                                                                                                       // dar una 2 vuelta
            return("Palabra: " + palabra + "\n"+"Definicion: " + definicion.get(0).getDefinicion() + " ha sido acertada");
        }
    }

    public void añadirDefinicion(Definicion d) {
        definicion.add(d);
    }

    public void borrarDefinicion(Definicion d) {
        if(definicion.contains(d)){
            definicion.remove(d);
        }
    }

    public void cambiarDefinicion(Definicion d) {
        definicion.set(0,d);
    }

    public char getInicial() {
        return inicial;
    }

    public void setAcertada(boolean acertada) {
        this.acertada = acertada;
    }

    public StringBuilder getPalabra() {
        return palabra;
    }

    public Definicion getDefinicion(int i) {      
        return definicion.get(i);
    }

    public void setDefinicion(ArrayList<Definicion> definicion) {
        this.definicion = definicion;
    }

    public boolean isAcertada() {
        if(acertada==true){
            return true;
        }else{
            return false;
        }
        
    }

    public boolean isFallado() {
        return fallado;
    }

    public boolean isAplazado() {
        return aplazado;
    }

    public void setFallado(boolean fallado) {
        this.fallado = fallado;
    }

    public void setAplazado(boolean aplazado) {
        this.aplazado = aplazado;
    }


    public void setPalabra(StringBuilder palabra) {
        this.palabra = palabra;
    }


}
