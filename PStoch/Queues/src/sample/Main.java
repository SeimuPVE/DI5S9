package sample;

import javax.swing.*;
import java.awt.event.*;


public class Main extends JFrame {
    public Main() {
        super("titre de l'application");

        WindowListener l = new WindowAdapter() {
            public void windowClosing(WindowEvent e){
                System.exit(0);
            }
        };

        addWindowListener(l);
        setSize(200,100);
        setVisible(true);
    }

    public static void main(String [] args){
        JFrame frame = new Main();
    }
}
