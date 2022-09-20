package br.com.luft.window;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.text.DateFormat;
import java.util.Date;
import java.util.EventListener;

public class PrincipalWindow extends javax.swing.JFrame {

    Connection conexao;

    private JPanel tblPrincipal;
    private JLabel imgLogo;
    private JLabel txtUsuario;
    private JLabel txtData;

    private JLabel statusBar;

    private JMenuItem about;
    public PrincipalWindow() {
        criarMenuBar();
        formWindowActivated(txtData);
        setContentPane(tblPrincipal);
        setTitle("Registro de Ativos");
        setSize(800, 400);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

    }

    // O codigo a baixo cria a barra de menu (MenuBar)

    private void criarMenuBar() {

        var menuBar = new JMenuBar();
        var fileMenu = new JMenu("Arquivo");
        fileMenu.setMnemonic(KeyEvent.VK_A);

        var addMenu = new JMenu("Cadastro");
        addMenu.setMnemonic(KeyEvent.VK_C);

        var helpMenu = new JMenu("Ajuda");
        helpMenu.setMnemonic(KeyEvent.VK_J);

        var optionsMenu = new JMenu("Opções");
        optionsMenu.setMnemonic(KeyEvent.VK_P);

        var print = new JMenuItem("Imprimir");
        print.setMnemonic(KeyEvent.VK_I);
        print.setDisplayedMnemonicIndex(1);
        print.setSelected(true);

        var search = new JMenuItem("Pesquisar");
        search.setMnemonic(KeyEvent.VK_P);
        search.setDisplayedMnemonicIndex(2);
        search.setSelected(true);

        var addDelete = new JMenuItem("Cadastrar/Excluir");
        addDelete.setMnemonic(KeyEvent.VK_C);
        addDelete.setDisplayedMnemonicIndex(5);
        addDelete.setSelected(true);

        var about = new JMenuItem("Sobre");
        about.setMnemonic(KeyEvent.VK_O);
        about.setDisplayedMnemonicIndex(1);
        about.setSelected(true);
        about.setVisible(true);

        var exit = new JMenuItem("Sair");
        exit.setMnemonic(KeyEvent.VK_S);
        exit.setDisplayedMnemonicIndex(3);
        exit.setSelected(true);


        fileMenu.add(print);
        addMenu.add(search);
        addMenu.add(addDelete);
        helpMenu.add(about);
        optionsMenu.add(exit);

        menuBar.add(fileMenu);
        menuBar.add(addMenu);
        menuBar.add(helpMenu);
        menuBar.add(optionsMenu);

        setJMenuBar(menuBar);
    }

    private void aboutActionPerformed(java.awt.event.ActionEvent evt) {
        // Tela Sobre
        WindowAbout about = new WindowAbout();
        //about.setVisible(true);
    }

    private void exitActionPerformed(ActionEvent evt) {
        // exibe uma caixa de dialogo
        int sair = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja sair ?" + "Atenção" + JOptionPane.YES_NO_OPTION);
        if (sair == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }

    private void formWindowActivated (JLabel evt) {
        // o codigo a baixo substitui a labl data pela data atual ao inicializar
        Date data = new Date();
        DateFormat formatador = DateFormat.getDateInstance(DateFormat.SHORT);
        txtData.setText(formatador.format(data));
    }

}
