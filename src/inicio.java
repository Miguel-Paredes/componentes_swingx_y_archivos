import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

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
    private boolean contador = true;
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
            try{
                FileInputStream datos =new FileInputStream("usuarios.dat");
                while (contador){
                    ObjectInputStream ois = new ObjectInputStream(datos);
                    infoUsuario info = (infoUsuario) ois.readObject();
                    if (info!=null){
                    String usu = info.getUsuario();
                    String contra = new String(info.getContrasenia());
                        if (username.equals(usu) && password.equals(contra)){
                            System.out.println("Ingreso exitoso");
                            usu_valido = true;
                            contra_valida = true;
                            break;
                        }
                        else{
                            System.out.println("No se ha realizado el registro");
                            usuario.setText("");
                            contrasenia.setText("");
                        }
                    }
                    else{
                        contador = false;
                    }
                }
                if (usu_valido==true && contra_valida==true){
                    JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(JPanel);
                    frame.setVisible(false);

                    JFrame usserFrame = new JFrame("USUARIO");
                    usuario usserventana = new usuario();
                    usserventana.datostxt.setText(username);
                    usserFrame.setContentPane(usserventana.JPanel);
                    usserFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    usserFrame.pack();
                    usserFrame.setVisible(true);
                }
            }catch (FileNotFoundException ex){
                throw new RuntimeException(ex);
            }catch(IOException ex){
                JOptionPane.showMessageDialog(JPanel, "Credenciales incorrecta. Inténtalo de nuevo.");
            }catch (ClassNotFoundException ex){
                throw new RuntimeException(ex);
            }
            }
        });


        registrarse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame loginFrame = (JFrame)SwingUtilities.getWindowAncestor(JPanel);
                loginFrame.setVisible(false);
                JFrame registroFrame = new JFrame("Registro");
                registro registroVentana = new registro();
                registroFrame.setContentPane(registroVentana.JPanel);
                registroFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                registroFrame.pack();
                registroFrame.setVisible(true);
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
