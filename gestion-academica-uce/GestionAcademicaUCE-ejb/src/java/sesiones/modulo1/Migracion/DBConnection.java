package sesiones.modulo1.Migracion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Chandan Singh
 *
 */
public class DBConnection {

    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        //Class.forName("com.mysql.jdbc.Driver");

        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/GestionAcademicaUCE", "postgres", "postgres");

        return connection;
    }

    public static void main(String[] args) {
        try {
            getConnection();            
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
