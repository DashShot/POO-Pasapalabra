/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pasapalabra;

/**
 *
 * @author Aitor
 */
public class SegundaDefinicion extends Pista {

    private Palabra p;
    private static final int PrecioSD = 5;

    public SegundaDefinicion(Palabra o) {

        super(PrecioSD);
        this.p = o;

    }

    public String mostrarInfo() {  
         return(p.getDefinicion(1).getDefinicion());
          
    }
        
}
