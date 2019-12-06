/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sesiones.modulo1.Migracion;

import java.sql.Connection;
import java.sql.Statement;


public class MigracionLan {

    public static void main() {
        
        
    }
    
    
    
    public static boolean migrar() {
        boolean estado=false;
        String ruta = "C:\\\\Users\\Public\\archivo.csv";
        ruta = "'" + ruta + "'";
        
        try (Connection connection = DBConnection.getConnection()) {

            //\copy zip_codes FROM '/path/to/csv/ZIP_CODES.txt' DELIMITER ',' CSV
            String loadQuery = "copy registro_biometrico(fecha,id_usuario) FROM " + ruta + " DELIMITER ',' CSV";
            System.out.println(loadQuery);
            Statement stmt = connection.createStatement();
            stmt.execute(loadQuery);
            estado=true;
            System.out.println("Se ha copiado existosamente los datos..!!");            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return estado;
    }

}
