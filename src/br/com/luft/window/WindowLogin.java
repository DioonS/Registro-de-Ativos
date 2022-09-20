package br.com.luft.window;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import br.com.luft.dal.ModuloConexao;

public class WindowLogin extends javax.swing.JFrame{

    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    public void logar() {
        String sql = "SELECT * FROM Usuario WHERE login = ? AND senha = ?";
        try {
            // Caputar o que está sendo digitado pelo usuario
            // o ? é substitudo pelo conteudo informado
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtUsuario.getText());
            pst.setString(2, txtSenha.getText());
            // a linha a baixo executa a query
            rs = pst.executeQuery();
            // se existir usuario e senha correspondente
            if (rs.next()) {
                PrincipalWindow principal = new PrincipalWindow();
                principal.setVisible(true);
                this.dispose();
                conexao.close();
            } else {
                JOptionPane.showMessageDialog(null, "Usuário e/ou Senha inválido!");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    private JPasswordField txtSenha;
    private JTextField txtUsuario;
    private JPanel mainPanel;
    private JButton btnLogin;
    private JPanel panelImage;
    private JLabel lblStatus;

    public WindowLogin() {
        setContentPane(mainPanel);
        setTitle("Login");
        setSize(318, 280);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);

        // Permite conexao com o banco de dados
        conexao = ModuloConexao.conector();
        // a linha abaixo serve de apoio ao status da conexao com o banco
        //System.out.println(conexao);
        if (conexao != null) {
//            lblStatus.setText("CONECTADO");
//            lblStatus.setForeground(Color.GREEN);
            lblStatus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/luft/icons/dbyes.png")));

        } else {
//            lblStatus.setText("DESCONECTADO");
//            lblStatus.setForeground(Color.RED);
            lblStatus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/luft/icons/dbno.png")));
        }
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Chama ação logar
                logar();
            }
        });
    }

    public static void main(String[] args) {

        WindowLogin myFrame = new WindowLogin();

        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (UnsupportedLookAndFeelException e) {
            // handle exception
        } catch (ClassNotFoundException e) {
            // handle exception
        } catch (InstantiationException e) {
            // handle exception
        } catch (IllegalAccessException e) {
            // handle exception
        }
    }
}
