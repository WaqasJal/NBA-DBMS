package basketballdbms.Utils;

import java.sql.Connection ;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MaConnection {
    private String url = "jdbc:oracle:thin:@localhost:1521/orcl" ;
    private String userName = "system" ;
    private String passWord = "Hello123" ;

    private Connection cnx ;
    private static MaConnection instance ;

    private MaConnection()
    {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");  
            cnx = DriverManager.getConnection(url,userName,passWord) ;
            System.out.println("Connected");
        } catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    public static MaConnection getInstance()
    {
        if(instance == null)
            instance = new MaConnection() ;
        return instance ;
    }

    public Connection getCnx()
    {
        return cnx;
    }
}
