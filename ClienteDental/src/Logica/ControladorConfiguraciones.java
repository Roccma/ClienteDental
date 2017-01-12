/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;
import java.io.*;
import java.util.*;

/**
 *
 * @author usuario
 */
public class ControladorConfiguraciones {
    private String carpetaSistema;
    private String fondoMenuPrincipal;
    private String lookAndFeel;
    private Properties propiedades;
    private InputStream archivo;
    
    public ControladorConfiguraciones() throws IOException{
        propiedades = new Properties();
        
        File fichero = new File("C:\\ClienteDental.conf");
        if(!fichero.exists()){
            fichero.mkdirs();
        }
        fichero = new File("C:\\ClienteDental.conf\\CDConf.properties");
        if(!fichero.exists()){
            if(fichero.createNewFile()){
                BufferedWriter crearProperties = new BufferedWriter(new FileWriter(fichero.getPath().toString()));
                crearProperties.write("carpetaSistema = /Documents/NetBeansProjects/ClienteDental/ClienteDental\n");
                crearProperties.write("fondoMenuPrincipal = menuPrincipal 2.png\n"); 
                crearProperties.write("lookAndFeel = com.sun.java.swing.plaf.windows.WindowsLookAndFeel\n");
                crearProperties.close();
            }                        
        }
        
        archivo = new FileInputStream(fichero.getPath());
        //System.out.println(fichero.getPath());
        propiedades.load(archivo);
        //System.out.println("Listooo");
        carpetaSistema = propiedades.getProperty("carpetaSistema");
        fondoMenuPrincipal = propiedades.getProperty("fondoMenuPrincipal");
        lookAndFeel = propiedades.getProperty("lookAndFeel");
        
    }

    public String getCarpetaSistema() {
        return carpetaSistema;
    }

    public String getFondoMenuPrincipal() {
        return fondoMenuPrincipal;
    }

    public String getLookAndFeel() {
        return lookAndFeel;
    }    
}
