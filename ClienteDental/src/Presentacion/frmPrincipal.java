/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.util.logging.*;
import Logica.*;
import java.io.*;

/**
 *
 * @author usuario
 */
public class frmPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form frmPrincipal
     */
    
    //private JLabel lblNuevoPaciente = new JLabel();
    private String hora;
    private String minutos;
    private String segundos;
    private String dia;
    private String mes;
    private String anio;
    private Calendar calendario;
    private Fabrica fab;
    private ControladorConfiguraciones cconf;
    
    public frmPrincipal(){
        initComponents();
        try {
            fab = new Fabrica();            
            cconf = fab.getCconf();
        } catch (IOException ex) {
            Logger.getLogger(frmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        try{
            JFrame.setDefaultLookAndFeelDecorated(true);
            JDialog.setDefaultLookAndFeelDecorated(true);
            UIManager.setLookAndFeel(cconf.getLookAndFeel());
        }
        catch (Exception e){
            e.printStackTrace();
        }
        
        Toolkit t = Toolkit.getDefaultToolkit();
        Dimension miPantalla = t.getScreenSize();
        
        int x = (miPantalla.width - 1200) / 2;
        int y = (miPantalla.height - 725) / 2;
        
        this.setResizable(false);
        
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(x, y, 1200, 745);
        this.setTitle("Cliente Dental - Menú principal");
        Panel p = new Panel();
        //lblNuevoPaciente.setLocation(500, 500);
        //JPanel p = new JPanel();
        agregarIcono("iconoNuevoPaciente", 58, 62, p);        
        agregarIcono("iconoModificarPaciente", 208, 62, p);        
        agregarIcono("iconoVerPaciente", 358, 62, p);
        agregarIcono("iconoNuevaConsulta", 58, 224, p);
        agregarIcono("iconoModificarConsulta", 208, 224, p);
        agregarIcono("iconoNuevaPlaca", 58, 388, p);
        agregarIcono("iconoQuitarPlaca", 208, 388, p);
        agregarIcono("iconoHistoriaClinica", 58, 558, p);
        agregarIcono("iconoListadoPacientes", 208, 558, p);
        agregarIcono("iconoListadoConsultas", 358, 558, p);
        agregarIcono("iconoSalir", 1035, 571, p);
        JLabel lblFecha = new JLabel("01/01/1990");
        lblFecha.setFont(new Font("Arial", Font.PLAIN, 38));
        lblFecha.setBounds(740, 525, 250, 150);
        lblFecha.setForeground(Color.WHITE);
        p.add(lblFecha);        
        JLabel lblHora = new JLabel("12:12:00");
        lblHora.setFont(new Font("Arial", Font.PLAIN, 42));
        lblHora.setBounds(753, 567, 250, 150);
        lblHora.setForeground(Color.WHITE);
        
        p.add(lblHora);
        
        this.setContentPane(p);
        while (true){
            try {
                calcular();
                lblFecha.setText(dia + "/" + mes + "/" + anio);
                lblHora.setText(hora + ":" + minutos + ":" + segundos);
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(frmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
    }
    
    public void calcular(){
        calendario = new GregorianCalendar();
        Date fechaHoraActual = new Date();
        
        calendario.setTime(fechaHoraActual);
        //ampm = calendario.get(Calendar.AM_PM) == Calendar.AM? "AM" : "PM";
        hora = calendario.get(Calendar.HOUR_OF_DAY) > 9 ? String.valueOf(calendario.get(Calendar.HOUR_OF_DAY)) : "0" + String.valueOf(calendario.get(Calendar.HOUR_OF_DAY));
        minutos = calendario.get(Calendar.MINUTE) > 9 ? String.valueOf(calendario.get(Calendar.MINUTE)) : "0" + String.valueOf(calendario.get(Calendar.MINUTE));
        segundos = calendario.get(Calendar.SECOND) > 9 ? String.valueOf(calendario.get(Calendar.SECOND)) : "0" + String.valueOf(calendario.get(Calendar.SECOND));
        dia = calendario.get(Calendar.DAY_OF_MONTH) > 9 ? String.valueOf(calendario.get(Calendar.DAY_OF_MONTH)) : "0" + String.valueOf(calendario.get(Calendar.DAY_OF_MONTH));
        mes = calendario.get(Calendar.MONTH) + 1 > 9 ? String.valueOf(calendario.get(Calendar.MONTH) + 1) : "0" + String.valueOf(calendario.get(Calendar.MONTH) + 1);
        //mes = String.valueOf(calendario.get(Calendar.MONTH) + 1);
        anio = calendario.get(Calendar.YEAR) > 9 ? String.valueOf(calendario.get(Calendar.YEAR)) : "0" + String.valueOf(calendario.get(Calendar.YEAR));     
    }
    
    public void agregarIcono(String nombre, int x, int y, JDesktopPane p){
        JLabel nuevo = new JLabel();
        ImageIcon icono = new ImageIcon(getClass().getResource("Imagenes/" + nombre + ".png"));
        icono = new ImageIcon(icono.getImage().getScaledInstance(115, 115, Image.SCALE_DEFAULT));
        nuevo.setIcon(icono);
        nuevo.setBounds(x, y , 115, 115);
        nuevo.setCursor(new Cursor(Cursor.HAND_CURSOR));
        nuevo.addMouseListener(new OyenteMouse(nuevo, nombre));
        p.add(nuevo);
    }
    
    class OyenteMouse implements MouseListener{
        private JLabel icono;
        private String nombre;
        public OyenteMouse(JLabel icono, String nombre){
            this.icono = icono;
            this.nombre = nombre;
        }
                
        @Override
        public void mouseClicked(MouseEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void mousePressed(MouseEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            ImageIcon icono = new ImageIcon(getClass().getResource("Imagenes/" + this.nombre + "Seleccionado.png"));
            icono = new ImageIcon(icono.getImage().getScaledInstance(115, 115, Image.SCALE_DEFAULT));
            this.icono.setIcon(icono);            
        }

        @Override
        public void mouseExited(MouseEvent e) {
            ImageIcon icono = new ImageIcon(getClass().getResource("Imagenes/" + this.nombre + ".png"));
            icono = new ImageIcon(icono.getImage().getScaledInstance(115, 115, Image.SCALE_DEFAULT));
            this.icono.setIcon(icono);  
        }
        
    }
    
    private class Panel extends JDesktopPane{
    
        public Panel(){

        }

        @Override
        public void paintComponent(Graphics g){
            Dimension tamanio = getSize();
            ImageIcon imagen = new ImageIcon(getClass().getResource("Imagenes/" + cconf.getFondoMenuPrincipal()));
            g.drawImage(imagen.getImage(), 0, 0, null);
            setOpaque(false);
            super.paintComponent(g);
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}



