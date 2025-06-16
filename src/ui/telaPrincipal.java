package ui;

import dao.ProdutoDAO;
import model.Produto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class telaPrincipal extends JFrame {

    private JTextField campoNome;
    private JTextField campoQuantidade;
    private JButton botaoSalvar;

    public telaPrincipal() {
        super("Controle de Estoque");

        // Definir tema escuro
        Color backgroundColor = new Color(45, 45, 45);
        Color textColor = Color.WHITE;
        Color buttonColor = new Color(70, 130, 180);

        getContentPane().setBackground(backgroundColor);
        setLayout(new GridLayout(3, 2, 10, 10)); // Espaçamento entre componentes

        JLabel labelNome = new JLabel("Nome do Produto:");
        labelNome.setForeground(textColor);
        add(labelNome);

        campoNome = new JTextField();
        campoNome.setBackground(new Color(60, 60, 60));
        campoNome.setForeground(textColor);
        campoNome.setCaretColor(textColor);
        add(campoNome);

        JLabel labelQuantidade = new JLabel("Quantidade:");
        labelQuantidade.setForeground(textColor);
        add(labelQuantidade);

        campoQuantidade = new JTextField();
        campoQuantidade.setBackground(new Color(60, 60, 60));
        campoQuantidade.setForeground(textColor);
        campoQuantidade.setCaretColor(textColor);
        add(campoQuantidade);

        botaoSalvar = new JButton("Salvar");
        botaoSalvar.setBackground(buttonColor);
        botaoSalvar.setForeground(Color.WHITE);
        botaoSalvar.setFocusPainted(false);
        add(botaoSalvar);

        botaoSalvar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    String nome = campoNome.getText();
                    int quantidade = Integer.parseInt(campoQuantidade.getText());

                    Produto produto = new Produto(nome, quantidade);
                    ProdutoDAO dao = new ProdutoDAO();
                    dao.adicionar(produto);

                    JOptionPane.showMessageDialog(null, "Produto salvo com sucesso!");
                    campoNome.setText("");
                    campoQuantidade.setText("");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Digite uma quantidade válida!");
                }
            }
        });

        setSize(1000, 800);
        setLocationRelativeTo(null); // Centraliza a janela
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}