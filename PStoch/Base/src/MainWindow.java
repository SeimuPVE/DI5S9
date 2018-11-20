import javax.swing.*;
import java.awt.event.*;


public class MainWindow extends JFrame {
   public MainWindow() {
      super("Title TODO");

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
      JFrame frame = new MainWindow();
   }
}
