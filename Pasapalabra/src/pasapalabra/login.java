/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pasapalabra;

/**
 *
 * @author Aitor
 */
public class login {

    private String Nombre;
    private String key;
    
    private static Almacen_Jugadores Usuarios = new Almacen_Jugadores();

    public login(Almacen_Jugadores x) {
        Usuarios=x;
        this.Nombre = "";
        this.key = "";
    }


    public String getNombre() {
        return Nombre;
    }

    public String getKey() {
        return key;
    }

    public void setNombre(String N) {
        this.Nombre = N;
    }

    public void setKey(String k) {
        this.key = k;
    }

    public boolean AnadirJugador(String n, String k) {
        Jugador j = new Jugador(n, k);
        if (!Usuarios.validarExistencia(j)) {
            Usuarios.AñadirJugador(j);
            return true;
        }
        return false;
    }

    public boolean AnadirAdmin (String n, String k) {
        Administrador j = new Administrador(n, k);
        if (!Usuarios.validarExistencia(j)) {
            Usuarios.AñadirJugador(j);
            return true;
        }
        return false;
    }

    public boolean BuscarJugador(String n, String k) {
        Jugador j = new Jugador(n, k);
        if (Usuarios.validarExistencia(j)) {
            return true;
        } else {
            return false;
        }

    }

    public void registro(String n, String k) {
        this.setNombre(n);
        this.setKey(k);
        AnadirJugador(n, k);
    }

    @Override
    public String toString() {
        return "Bienvenido: " + this.Nombre + "," + this.key;
    }
}
