package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class CriareBD {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/";
        String usuario = "diego";
        String senha = "diego2004";

        try {
            // Conectar ao MySQL (sem especificar banco)
            Connection conn = DriverManager.getConnection(url, usuario, senha);
            Statement stmt = conn.createStatement();

            // Criar banco se não existir
            stmt.executeUpdate("CREATE DATABASE IF NOT EXISTS estoque");

            // Usar o banco recém-criado
            stmt.execute("USE estoque");

            // Criar tabela de produtos
            String sqlTabela = "CREATE TABLE Produtos ("+
                    "codigo INT PRIMARY KEY AUTO_INCREMENT,"+
                    "nome VARCHAR(100) NOT NULL,"+
                    "descricao TEXT NOT NULL,"+
                    "quantidade INT DEFAULT 0,"+
                    "quantidade_minimaINT DEFAULT 0"+
                    ")";

            stmt.executeUpdate(sqlTabela);

            System.out.println("Banco e tabela criados com sucesso!");
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}