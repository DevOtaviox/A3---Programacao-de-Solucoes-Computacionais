package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/sistema_estoque",
                    "seu usuario", "sua senha"
            );
        } catch (SQLException e) {
            throw new RuntimeException("Erro na conexão com o banco.", e);
        }
    }
}