/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pasapalabra;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author aleja
 */
public class Almacen_Jugadores implements Serializable {

    private ArrayList<Jugador> jugadores;

    public Almacen_Jugadores() {
        jugadores = new ArrayList<Jugador>();
        Administrador admin = new Administrador("admin", "admin");
        admin.setAdmin(true);
        Jugador x = new Jugador("alex", "alex");
        Jugador y = new Jugador("carlos", "carlos");
        //jugadores.add(x);
       // jugadores.add(y);
       //jugadores.add(admin);
    }

    public void ordenar(boolean por_puntos) {
       // jugadores.get(1).setPuntos(1200);                 DAMOS PUNTOS Y PARTIDAS GANADAS PARA QUE SE ORDNENE AL CLASIFICAR
        //jugadores.get(0).getE().setPartidasG(10);
        if (por_puntos == true) {
            Jugador aux;
            for (int i = 0; i < jugadores.size(); i++) {
                for (int j = i + 1; j < jugadores.size(); j++) {
                    if (jugadores.get(i).getPuntos() < jugadores.get(j).getPuntos()) {
                        aux = jugadores.get(i);
                        jugadores.set(i, jugadores.get(j));
                        jugadores.set(j, aux);
                    }
                }
            }
        } else {
            Jugador aux;
            for (int i = 0; i < jugadores.size(); i++) {
                for (int j = i + 1; j < jugadores.size(); j++) {
                    if (jugadores.get(i).getE().getPartidasG() < jugadores.get(j).getE().getPartidasG()) {
                        aux = jugadores.get(i);
                        jugadores.set(i, jugadores.get(j));
                        jugadores.set(j, aux);
                    }
                }
            }
        }
    }

    public void CrearFichero() {        //ESTO LO TIENE QUE REVISAR AITOR QUE NO SE BIEN COMO VA

        try ( ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("C:\\Almacen_Jugadores.ddr"))) {
            Jugador aux;
            for (int i = 0; i < jugadores.size(); i++) {
                for (int j = 1; j < (jugadores.size() - i); j++) {
                    if (jugadores.get(j - 1).getPuntos() < jugadores.get(j).getPuntos()) {
                        aux = jugadores.get(j - 1);
                        jugadores.set(j - 1, jugadores.get(j));
                        jugadores.set(j, aux);
                    }
                }
                for (int k = 0; k < jugadores.size(); k++) {
                    oos.writeObject(jugadores.get(i));
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public ArrayList<Jugador> getJugadores() {
        return jugadores;
    }

    public boolean validarExistencia(Jugador user) {
        for (int i = 0; i < this.jugadores.size(); i++) {
            if (user.getNombre().equals(jugadores.get(i).getNombre()) && user.getClave().equals(jugadores.get(i).getClave())) {
                return true;
            }
        }
        return false;
    }

    public void AñadirJugador(Jugador x) {
        jugadores.add(x);
    }

    public String Clasificacion() {
        String aux = "";
        for (int i = 0; i < jugadores.size(); i++) {
            int aux1 = i + 1;
            aux = "" + aux + " " + aux1 + "-" + jugadores.get(i).getNombre() +" Partidas ganadas: "+jugadores.get(i).getE().getPartidasG()+" Puntos: "+jugadores.get(i).getE().getPuntos()+ "\n";
        }
        return aux;
    }

    public int buscarPosicion(String n, String k) {
        for (int i = 0; i < this.jugadores.size(); i++) {
            if (n.equals(jugadores.get(i).getNombre()) && k.equals(jugadores.get(i).getClave())) {
                return i;
            }
        }
        return (jugadores.size()+3);
    }
}
