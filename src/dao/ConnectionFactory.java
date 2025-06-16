package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/controle_estoque",
                    "diego", "diego2004"
            );
        } catch (SQLException e) {
            throw new RuntimeException("Erro na conexão com o banco.", e);
        }
    }
}