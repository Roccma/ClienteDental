/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import com.sun.glass.ui.Cursor;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author usuario
 */
public class ClienteDental {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        // TODO code application logic here
        
        frmBienvenido frmB = new frmBienvenido();
        
        try {
            float opacidad = 0.0f;
            frmB.setOpacity(opacidad);
            for(int i = 0; i < 4; i++){
            
                opacidad = opacidad + 0.2f;
                frmB.setOpacity(opacidad);
                Thread.sleep(45);            
            }
            
        
            frmB.setOpacity(1.0f);
            Thread.sleep(5000);
            //Thread.sleep(50);
            for(int i = 0; i < 4; i++){
            
                opacidad = opacidad - 0.2f;
                frmB.setOpacity(opacidad);
                Thread.sleep(45);            
            }
            frmB.setOpacity(0.0f);
            frmB.dispose();
            frmPrincipal frmP = new frmPrincipal();
            frmP.setVisible(true);
        } catch (InterruptedException ex) {
            Logger.getLogger(ClienteDental.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
}
