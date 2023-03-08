/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pasapalabra;

import java.io.*;


public class MiObjectOutputStream extends ObjectOutputStream{
    
    /** 
     * Constructor que recibe OutputStream 
     * @param out OutputStream
     * @throws java.io.IOException IOException
     */
    public MiObjectOutputStream(OutputStream out) throws IOException{
        super(out); //Llama al constructor de la superclase(OutputStream)
    }
    /** 
     * Constructor sin parámetros 
     * @throws java.io.IOException IOException
     */
    protected MiObjectOutputStream() throws IOException, SecurityException{
        super(); //Llama al constructor de la superclase(OutputStream)
    }
    
    @Override
    protected void writeStreamHeader() throws IOException{
        //No hacemos nada
    }
}
    

