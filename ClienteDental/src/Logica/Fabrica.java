/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.io.IOException;

/**
 *
 * @author usuario
 */
public class Fabrica {
    private ControladorConfiguraciones cconf;
    
    public Fabrica() throws IOException{
        cconf = new ControladorConfiguraciones();
    }

    public ControladorConfiguraciones getCconf() {
        return cconf;
    }    
}
