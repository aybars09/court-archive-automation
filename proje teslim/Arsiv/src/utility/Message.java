
package utility;



import javax.swing.JOptionPane;


public class Message {

    void hataMesaji(String title, String msj) {
        JOptionPane.showInternalMessageDialog(null,msj, title,JOptionPane.ERROR_MESSAGE);
    }
}
