package mssql;

import java.sql.*;

/**
 * Created by User on 7/20/2017.
 */
public class Main {

    private static Connection con = null;
    private static String username = "root";
    private static String password = "root";
    private static String URL = "jdbc:mysql://localhost:3306/sys";

    public static void main(String[] args) throws SQLException {

        DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        con = DriverManager.getConnection(URL, username, password);
        if(con != null) System.out.println("Connection successful !\n");
        if (con == null) System.exit(0);
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM sys_config");

        int x = rs.getMetaData().getColumnCount();
        while (rs.next())
        {
            for (int i = 1; i <= x; i++)
            {
                System.out.println(rs.getString(i) + "\t");
            }
            System.out.println();
        }
        System.out.println();
        if(rs != null) rs.close();
        if(st != null) st.close();
    }

}
