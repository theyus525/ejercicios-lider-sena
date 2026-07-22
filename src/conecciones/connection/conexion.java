package connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class conexion
{
    public Connection getConexion()
    {
        Connection con = null;

        try
        {

            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/perfuma2s", "root", "");

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return con;
    }
}