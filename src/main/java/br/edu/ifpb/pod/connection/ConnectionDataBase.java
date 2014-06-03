
package br.edu.ifpb.pod.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author marciel
 */

public class ConnectionDataBase {
    private static ConnectionDataBase instance;
    private final String url;
    private final String usuario;
    private final String senha;

    //Verifiquem sua senha e login do postgres
    private ConnectionDataBase() {
        this.url = "jdbc:postgresql://localhost:5432/publicador-pod";
        this.usuario = "postgres";
        this.senha = "12345";
    }

    public static ConnectionDataBase getInstance() {
        if (instance == null) {
            instance = new ConnectionDataBase();
        }
        return instance;
    }

    public Connection getConnection() throws SQLException {
        Connection connection = null;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url, usuario, senha);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            throw new SQLException("Problems Initializing database");
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
        return connection;
    }
}