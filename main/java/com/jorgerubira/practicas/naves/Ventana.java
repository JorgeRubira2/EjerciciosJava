/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.com.jorgerubira.practicas.naves;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

/**
 *
 * @author PC
 */
public class Ventana extends javax.swing.JFrame {

    
    BufferedImage iFondo;
    BufferedImage iNave;
    BufferedImage iNaveSin;
    BufferedImage iExplosion;
    BufferedImage bufferedImage = new BufferedImage(1200, 800, BufferedImage.TYPE_INT_ARGB);
    Graphics2D g2d = (Graphics2D)bufferedImage.getGraphics();
    
    Nave n=new Nave();
    IDecision decision = new TuAlgoritmoDeDecision();
    
    /**
     * Creates new form Ventana
     */
    public Ventana() {
        initComponents();
        String path="com/jorgerubira/practicas/naves";
        try {
            path=getClass().getClassLoader().getResource(path).toString().replaceAll("target/classes", "src/main/java");
            iFondo=ImageIO.read(new URL(path + "/imagenes/Fondo.png"));
            iNave=ImageIO.read(new URL(path + "/imagenes/NaveBase.png"));
            iNaveSin=ImageIO.read(new URL(path + "/imagenes/NaveSin.png"));
            iExplosion=ImageIO.read(new URL(path + "/imagenes/Explosion.png"));
        } catch (Exception ex) {
        }
        iniciarHilo();
    }
    
    private int mlseconds=0;
    public void time(){
        mlseconds+=1;
        decision.decision(n, mlseconds/100);
        n.time();
        repaint();
        
    }
    
    ScheduledExecutorService ses=null;
    public void iniciarHilo(){
        ses=Executors.newScheduledThreadPool(1);
        ses.scheduleAtFixedRate(()->time(), 0, 10, TimeUnit.MILLISECONDS);
        
    }

    @Override
    public void update(Graphics g) {
        paint(g);
    }

  

    
    Font font=new Font ("TimesRoman", Font.BOLD | Font.ITALIC, 50);
    boolean mensaje=false;
    boolean explosion=false;
    @Override
    public void paint(Graphics g) {
        //super.paint(g); 
        
        if (iFondo!=null){
            g2d.drawImage(iFondo,0,0,1200,800,this);
        }
        g2d.setColor(Color.red);
        g2d.fillRect(1000, 700, 100, 20);
        if (iNave!=null){
            int x=n.getMetrosRecorridos()-iNave.getWidth()/2+240;
            int y=800-n.getAltura()-iNave.getHeight()/2+150;
            float angulo=(float)(n.getAngulo()*Math.PI*2/360);
            g2d.translate(x, y);
            g2d.rotate(angulo);
            int goal=0;
            if (n.getMetrosRecorridos()>=950 && n.getMetrosRecorridos()<=1050 && n.getAltura()>=50 && n.getAltura()<=80){
                if (n.getVelocidad()<200 && Math.abs(n.getAngulo())<20){
                    goal=1;
                }else{
                    goal=2; 
                }
            }
            if (goal==1 && explosion==false){
                ses.shutdown();
                if (mensaje==false){
                    mensaje=true;
                    JOptionPane.showMessageDialog(this, "Felicidades! Lo has conseguido");    
                }
                
            }else if (goal==2 || explosion || n.getMetrosRecorridos()>1150 || n.getAltura()<0){
                g2d.drawImage(iExplosion, 0, 0,iNave.getWidth()/4,iNave.getHeight()/4,this);    
                explosion=true;
            }else if (n.getPropulsion()){
                g2d.drawImage(iNave, 0, 0,iNave.getWidth()/4,iNave.getHeight()/4,this);    
            }else{
                g2d.drawImage(iNaveSin, 0, 0,iNave.getWidth()/4,iNave.getHeight()/4,this);    
            }
            
            g2d.rotate(-angulo);
            g2d.translate(-x, -y);
        }
        g2d.setColor(Color.BLACK);
        g2d.setFont(font);
        g2d.drawString("Segundos " + mlseconds/100, 30, 100);
        g2d.drawString("Altura " + n.getAltura(), 30, 150);
        g2d.drawString("Metros " + n.getMetrosRecorridos(), 30, 200);
        g2d.drawString("Velocidad " + n.getVelocidad(), 30, 250);
        g2d.drawString("Angulo " + n.getAngulo(), 30, 300);
        if (n.isViento()){
            g2d.drawString("Viento " + Math.round(n.getFuerzaViento()*500), 30, 350);
        }
        g.drawImage(bufferedImage, 0, 0, getWidth(), getHeight(), this);

        
        //g.drawLine(0,0,100,100);
        //g.drawOval(n.getMetrosRecorridos()-5+10, getHeight()-n.getAltura()-50, 20, 20);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        canvas1 = new java.awt.Canvas();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(209, 209, 209)
                .addComponent(canvas1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(719, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(193, 193, 193)
                .addComponent(canvas1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(398, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        if (ses!=null){
            ses.shutdown();
        }
    }//GEN-LAST:event_formWindowClosing

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
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ventana().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Canvas canvas1;
    // End of variables declaration//GEN-END:variables
}
