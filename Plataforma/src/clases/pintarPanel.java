/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package clases;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import vistas.plataforma;
import vistas.panelPublicaciones;

/**
 *
 * @author alvaro
 */
public class pintarPanel {
            public void pintaPanel(plataforma frame,panelPublicaciones panel){
                        frame.add(panel);
                        panel.setBounds(150, 80, 650, 520);
                        panel.setVisible(true);
                        panel.setBackground(Color.red);
                        

            }
}
