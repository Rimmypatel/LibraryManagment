package projectReg;

import java.sql.Statement;
import java.sql.*;

public class connect
{
    Statement stmt;
    Connection connection;

    public connect()
   {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3308/javaacc","root","root");
            stmt = connection.createStatement();

        }
        catch(Exception e )
        {
            System.out.println( e );
        }
   }


}
