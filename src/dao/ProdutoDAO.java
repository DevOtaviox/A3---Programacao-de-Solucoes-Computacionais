package dao;

import model.Produto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProdutoDAO {
    private Connection conn;

    public ProdutoDAO() {
        this.conn = conexao.getConnection();
    }

    public void adicionar(Produto produto) {
        String sql = "INSERT INTO produto (nome, quantidade) VALUES (?, ?)";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, produto.getNome());
            stmt.setInt(2, produto.getQuantidade());
            stmt.execute();
            System.out.println("Produto cadastrado com sucesso.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}