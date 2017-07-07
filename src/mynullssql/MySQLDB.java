/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mynullssql;

/**
 *
 * @author TianTaljard
 */
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.sql.*;

public class MySQLDB {

    //static String dbName = "db1511762_db";
    static String dbName = "reqlocaldb";
    static String DB_URL = "jdbc:mysql://127.0.0.1:3306/" + dbName;

    public static void main(String args[]) {
        try { // attempt to establish connection to database
            MysqlDataSource db = new MysqlDataSource();
            db.setUrl(DB_URL);
            Connection connection = db.getConnection(
                    "root", "Zppsit0!");

            Statement tbl_statement = null;
            ResultSet tbl_resultset = null;
            Statement col_statement = null;
            ResultSet col_resultset = null;

//  GET TABLE DATA
            Statement tbl_query = connection.createStatement();
            ResultSet tbl_results = tbl_query.executeQuery("show tables");
            ResultSetMetaData tbl_meta = tbl_results.getMetaData();
            int tbl_numColumns = tbl_meta.getColumnCount();
            for (int i = 1; i <= tbl_numColumns; i++) {
                System.out.print("\t" + tbl_meta.getColumnName(i));
            }
            System.out.println();
            while (tbl_results.next()) {
                for (int i = 1; i <= tbl_numColumns; i++) {
                    System.out.print("\t" + tbl_results.getObject(i));

                    System.out.println();
//  GET COLUMN DATA                   
                    Statement col_query = connection.createStatement();
                    ResultSet col_results = col_query.executeQuery("show columns from " + tbl_results.getObject(i));
                    System.out.print("\t\t" + tbl_results.getObject(i));
                    ResultSetMetaData col_meta = col_results.getMetaData();
                    while (col_results.next()) {
                        for (int ci = 1; ci <= tbl_numColumns; ci++) {
                            int col_numColumns = col_meta.getColumnCount();
                            

          
                        }
                    }

                }
            }

        } catch (SQLException e) { // code to run if connection fails
            System.out.println(
                    "Something went wrong with DB connection \n"
                    + "Error message is: " + e);
        }
    }
}
