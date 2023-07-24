import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class usuario {
    public JPanel JPanel;
    private JButton salirButton;
    public JTextField datostxt;
    private JLabel usuario;
    private JLabel bienvenido;

    public usuario() {
        salirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame1;
                frame1 = (JFrame) SwingUtilities.getWindowAncestor(JPanel);
                frame1.setVisible(false);

                JFrame frame2 = new JFrame("Login");
                inicio ventanaPrincipal = new inicio();
                frame2.setContentPane(ventanaPrincipal.JPanel);
                frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame2.pack();
                frame2.setVisible(true);
            }
        });
    }
}
