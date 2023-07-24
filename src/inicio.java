import javax.swing.*;

public class inicio {
    private JPanel Jpanel;
    private JLabel bienvenido;
    private JLabel mensaje1;
    private JLabel mensaje2;
    private JLabel usuario;
    private JLabel contrasenia;
    private JButton inicio;
    private JButton registrarse;
    private JTextField textField1;
    private JTextField textField2;

    public static void main(String[] args) {
        JFrame frame = new JFrame("inicio");
        frame.setContentPane(new inicio().Jpanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
