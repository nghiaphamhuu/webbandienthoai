package context;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBContext {
    private final String serverName = "localhost";
    private final String dbName = "ShoppingDB";
    private final String portNumber = "1433";
    private final String instance = "";
    private final String userID = "nghia";
    private final String password = "nghiaph2020";

    public Connection getConnection () throws Exception {
        String url = "jdbc:sqlserver://" + serverName + ":" + portNumber + "\\" + instance + ";databaseName=" + dbName+";encrypt=false";
        if (instance==null || instance.trim().isEmpty())
//            url = "jdbc:sqlserver://" + serverName+ ":" + portNumber + ";databaseName=" + dbName + ";user=" +userID+ ";password=" +password+";encrypt=false";
          url = "jdbc:sqlserver://" + serverName+ ":" + portNumber + ";databaseName=" + dbName + ";encrypt=false";
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");  
        return DriverManager.getConnection(url,userID,password);
    }
    public static void main(String[] args) throws Exception {
        System.out.println(1);
       
        try {
            System.out.println(2);

//          System.out.println(new DBContext().getConnection());
            Connection connection= new DBContext().getConnection();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println(3);

            e.printStackTrace();
        }
        	System.out.println(4);

    }

	    
}