package br.com.luft.window;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.metal.DefaultMetalTheme;
import javax.swing.plaf.metal.MetalLookAndFeel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class WindowLogin extends JFrame{
    private JButton btnCancel;
    private JPasswordField fieldSenha;
    private JTextField fieldUsuario;
    private JPanel mainPanel;
    private JButton btnLogin;
    private JPanel panelImage;

    public WindowLogin() {
        setContentPane(mainPanel);
        setTitle("Login");
        setSize(318, 250);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);
        ImageIcon image = new ImageIcon(getClass().getResource("luft logo.png"));
        JLabel labelImage = new JLabel(image);
        labelImage.add(labelImage);
        labelImage.repaint();
    }


    public static void main(String[] args) {
        WindowLogin myFrame = new WindowLogin();
    }
}
