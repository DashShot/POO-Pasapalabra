package pasapalabra;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Aitor
 */
public class Almacen_Partidas implements Serializable {

    private ArrayList<Partida> Partidas;
    public Almacen_Partidas() {
        Partidas = new ArrayList<Partida>();
    }

    public void añadirPartida(Partida p) {
        Partidas.add(p);
    }

    public void consultarPartida(Partida p) {       
            if (Partidas.contains(p)) {
                System.out.println(p.toString());
            }
    }

    public ArrayList<Partida> getPartidas() {
        return Partidas;
    }

}

/*Para incluir los datos en el juego es necesario tener un acceso de administrador. El
administrador podrá dar de alta, editar y eliminar tanto a los jugadores como a las palabras
asociadas a cada una de las letras y a las definiciones asociadas a cada una de las palabras.
Además, el administrador podrá hacer todas las acciones que realizan los jugadores, pero
contará con 1.000.000 puntos para jugar. Por otra parte, el administrador puede obtener
información completa de las partidas. Para cada una de ellas, el administrador podrá
consultar los jugadores, el marcador, y el detalle de cada uno de los roscos (letras, palabras
y pistas utilizadas). Por último, el administrador podrá ver la clasificación de los distintos
jugadores, en la que aparecerá su nombre, partidas jugadas, partidas ganadas, partidas
empatadas, partidas perdidas y puntos conseguidos. Esta clasificación se podrá ordenar
tanto por partidas ganadas como por puntos conseguidos, y será posible exportarla a un
fichero de texto. */
