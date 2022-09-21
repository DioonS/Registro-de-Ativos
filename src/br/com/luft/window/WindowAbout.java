package br.com.luft.window;

import javax.swing.*;

public class WindowAbout extends javax.swing.JFrame{
    private JPanel tblabout;

    public WindowAbout() {
        setContentPane(tblabout);
        setTitle("Sobre");
        setVisible(true);
        setSize(850,500);
        setLocationRelativeTo(null);
        setResizable(false);
    }
}
