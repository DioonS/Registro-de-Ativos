package br.com.luft.window;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.KeyEvent;
import java.sql.Connection;

public class PrincipalWindow extends javax.swing.JFrame {

    Connection conexao;

    private JPanel tblPrincipal;
    private JLabel imgLogo;

    private JLabel statusBar;
    public PrincipalWindow() {
        criarMenuBar();
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

        var showStatusBarMenuItem = new JMenuItem("Imprimir");
        showStatusBarMenuItem.setMnemonic(KeyEvent.VK_I);
        showStatusBarMenuItem.setDisplayedMnemonicIndex(1);
        showStatusBarMenuItem.setSelected(true);

        var showStatusBarMenuItem1 = new JMenuItem("Pesquisar");
        showStatusBarMenuItem1.setMnemonic(KeyEvent.VK_P);
        showStatusBarMenuItem1.setDisplayedMnemonicIndex(2);
        showStatusBarMenuItem1.setSelected(true);

        var showStatusBarMenuItem2 = new JMenuItem("Cadastrar/Excluir");
        showStatusBarMenuItem2.setMnemonic(KeyEvent.VK_C);
        showStatusBarMenuItem2.setDisplayedMnemonicIndex(5);
        showStatusBarMenuItem2.setSelected(true);

        var showStatusBarMenuItem3 = new JMenuItem("Sobre");
        showStatusBarMenuItem3.setMnemonic(KeyEvent.VK_O);
        showStatusBarMenuItem3.setDisplayedMnemonicIndex(1);
        showStatusBarMenuItem3.setSelected(true);

        var showStatusBarMenuItem4 = new JMenuItem("Sair");
        showStatusBarMenuItem4.setMnemonic(KeyEvent.VK_S);
        showStatusBarMenuItem4.setDisplayedMnemonicIndex(3);
        showStatusBarMenuItem4.setSelected(true);

        fileMenu.add(showStatusBarMenuItem);
        addMenu.add(showStatusBarMenuItem1);
        addMenu.add(showStatusBarMenuItem2);
        helpMenu.add(showStatusBarMenuItem3);
        optionsMenu.add(showStatusBarMenuItem4);

        menuBar.add(fileMenu);
        menuBar.add(addMenu);
        menuBar.add(helpMenu);
        menuBar.add(optionsMenu);

        setJMenuBar(menuBar);
    }
}
