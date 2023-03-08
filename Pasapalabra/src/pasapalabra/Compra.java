/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pasapalabra;

/**
 *
 * @author Aitor
 */
public class Compra extends Ayuda {

    private Palabra p;
    private static final int COMP = 20;

    public Compra(Palabra o) {
        super(COMP);
        this.p = o;
    }

    public String mostrarInfo() {
        p.setAcertada(true);
        return(p.mostrar());
    }

}
