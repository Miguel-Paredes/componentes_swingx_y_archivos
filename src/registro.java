import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class registro {
    public JPanel JPanel;
    private JTextField nombrer;
    private JButton registrarseButton;
    private JPasswordField contraseniar;
    private String registroUsuario;
    private String registroContrasenia;
    private JLabel registrate;
    private JLabel nombre;
    private JLabel contrasenia;
    private JButton regresar;
    private JLabel mensajetxt;

    public registro() {
        registrarseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Aquí puedes implementar la lógica para registrar al usuario
                // Por ahora, simplemente cerraremos la ventana de registro
                infoUsuario usuarioN = new infoUsuario();
                registroUsuario = nombrer.getText();
                usuarioN.setUsuario(registroUsuario);
                registroContrasenia = String.valueOf(contraseniar.getPassword());
                usuarioN.setContrasenia(registroContrasenia);
                try {
                    FileOutputStream nombreF = new FileOutputStream("USUARIOS.dat", true);
                    ObjectOutputStream obd = new ObjectOutputStream(nombreF);
                    obd.writeObject(usuarioN);
                    mensajetxt.setText("USUARIO REGISTRADO");
                    nombrer.setText("");
                    contraseniar.setText("");
                } catch (FileNotFoundException ex) {
                    System.out.println("NO SE ENCUENTRA EL ARCHIVO " + ex);
                } catch (IOException ex) {
                    System.out.println("NO SE PUDO GUARDAR EL ARCHIVO" + ex);
                }
            }
        });

        regresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame registroFrame = (JFrame) SwingUtilities.getWindowAncestor(JPanel);
                registroFrame.setVisible(false);

                JFrame loginframe = new JFrame("Login");
                inicio loginventana = new inicio();
                loginframe.setContentPane(loginventana.JPanel);
                loginframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                loginframe.pack();
                loginframe.setVisible(true);
            }
        });
    }
}
