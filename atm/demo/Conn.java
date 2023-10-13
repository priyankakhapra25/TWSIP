package atm.demo;
import java.sql.*;

public class Conn {
    Connection connection;
    Statement statement;
    public Conn(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Topperworld","root","1234");
            statement = connection.createStatement();
        }
        catch(ClassNotFoundException | SQLException e){
            System.out.println(e);
        }
    }
}