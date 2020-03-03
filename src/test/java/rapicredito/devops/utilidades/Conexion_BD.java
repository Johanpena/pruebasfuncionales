package rapicredito.devops.utilidades;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion_BD {

    public static Connection main() {

        Connection conn = null;

        String user = "rapicredit";
        String password = "DwhJkpkNGK";
        String database = "rapicreditdbnewmodel";
        int port = 3306;
        try {
            Class.forName("com.mysql.jdbc.Driver").getConstructor().newInstance();
            conn = DriverManager.getConnection("jdbc:mysql://testing-rc-rds-02-rapicreditdb.cw1jdcgskzcq.us-east-1.rds.amazonaws.com:" + port + "/" + database, user, password);

        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();

        }
        return conn;
    }
}