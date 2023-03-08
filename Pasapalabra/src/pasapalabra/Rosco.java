package pasapalabra;

import java.util.ArrayList;

/**
 *
 * @author Aitor
 */
public class Rosco {

    private int num_letras;
    public int vuelta;
    private Almacen_Palabra ap;
    ArrayList<Palabra> palabras;
    private boolean terminado;

    public Rosco(int n, Almacen_Palabra apu) {
        this.num_letras = n;
        palabras = new ArrayList<Palabra>();
        
        this.ap = apu;
        this.vuelta = 1;
        terminado = false;
        this.llenarRosco();

    }

    public void limpiarRosco() {

        for (int i = 0; i < num_letras; i++) {

            getPalabras().get(i).setAcertada(false);
            getPalabras().get(i).setFallado(false);
            getPalabras().get(i).setAplazado(false);
        }
    }

    public void llenarRosco() {

        for (int i = 0; i < num_letras; i++) {

            //int aux = (int) (Math.random() * ap.palabra[i].length + 1);//
            palabras.add(ap.getPalabra(i, 0));
        }
    }

    public int getVuelta() {
        return vuelta;
    }

    public void setVuelta(int vuelta) {
        this.vuelta = vuelta;
    }

    public ArrayList<Palabra> getPalabras() {
        return palabras;
    }

    public Palabra getPalabras(int a) {
        return palabras.get(a);
    }

    public boolean isTerminado() {
        return terminado;
    }

    public void setTerminado(boolean terminado) {
        this.terminado = terminado;
    }

}
