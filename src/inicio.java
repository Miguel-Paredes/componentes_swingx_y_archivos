import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class inicio {
    private JPanel Jpanel;
    private JLabel bienvenido;
    private JLabel mensaje1;
    private JLabel mensaje2;
    private JLabel usuario;
    private JLabel contrasenia;
    private JButton inicio;
    private JButton registrarse;
    private JTextField ingreso_usuario;
    private JPasswordField ingreso_contrasenia;
    private boolean conta = true;
    private boolean usu_valido;
    private boolean contra_valida;
    public String username;
    public String password;



    public inicio() {
        inicio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                username = ingreso_usuario.getText();
                password =new String(ingreso_contrasenia.getPassword());
                usu_valido = false;
                contra_valida = false;
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("inicio");
        frame.setContentPane(new inicio().Jpanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
