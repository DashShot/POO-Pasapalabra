package pasapalabra;

/**
 *
 * @author aleja
 */
public class Entrenar {

    private int beneficio;
    private int numPalabras;
    private Jugador jugador;
    private Rosco rosco;
    private Almacen_Palabra ap;

    public Entrenar(Jugador uno, int numPalabras, Almacen_Palabra ap) {
        beneficio = 5;
        jugador = uno;
        this.numPalabras = numPalabras;
        this.ap = ap;
        Rosco ros = new Rosco(numPalabras, ap);
        this.rosco = ros;

    }

    public Rosco getRosco() {
        return rosco;
    }

    public String Enunciado(int i) {
        return ("Turno de " + jugador.getNombre() + "\n Comienza por la letra " + rosco.getPalabras(i).getInicial() + ": " + rosco.getPalabras(i).getDefinicion(0));
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

    public String pasar(int i) {
        rosco.getPalabras(i).setAplazado(true);
        return ("Has pasado palabra, pulsa Continuar para seguir jugando");
    }

    public String Ayuda(Jugador j, Palabra pr) {
        if (j.getPuntos() >= 5) {
            j.setPuntos(j.getPuntos() - 5);
            
            if (pr.getDefinicion().size()==1) {

                Letras l = new Letras(pr);
                return (l.mostrarInfo());
            } else {
                SegundaDefinicion s = new SegundaDefinicion(pr);
                return(s.mostrarInfo());

            }
        } else {
            return ("No hay puntos suficientes para comprar pista");
        }
        
    }


    public String ComprarP(Jugador j, Palabra pr) {

        if (j.getPuntos() >= 20) {
            j.setPuntos(j.getPuntos() - 20);
            Compra c = new Compra(pr);
            return(c.mostrarInfo());
            
        } else {
            return("No hay puntos suficientes para comprar palabra");
        }
        
    }
    
    public void repartirPuntos(Jugador j){
        if(j.getPuntos()<5){
            j.setPuntos(beneficio);
        }
    }
}
