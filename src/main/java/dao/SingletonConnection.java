package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SingletonConnection {
    private static Connection connection;
    static{
        try{
            Class.forName("org.postgresql.Driver");
            connection= DriverManager.getConnection("jdbc:postgresql://localhost:5432/jee_tp1","postgres","Ycode@2021");
        }  catch (Exception e) {
            System.out.println("hello wolrd from singltonconnection");
            e.printStackTrace();
        }
    }
    public static Connection getConnection(){
        return connection;
    }

}
