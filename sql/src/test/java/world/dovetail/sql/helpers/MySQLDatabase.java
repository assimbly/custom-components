package world.dovetail.sql.helpers;

import java.sql.*;

public class MySQLDatabase {
    // JDBC driver name and database URL
    static final String HOST = "dovetail-mariadb";
    static final String DB_URL = "jdbc:mysql://"+ HOST + ":3306/mysql_test";

    //  Database credentials
    static final String USER = "root";
    static final String PASS = "root";

    public void create() {
        Connection conn = null;
        Statement stmt = null;
        try{
            //STEP 1: Open a connection
            conn = DriverManager.getConnection("jdbc:mysql://" + HOST + ":3306/", USER, PASS);

            //STEP 2: Create Database
            stmt = conn.createStatement();

            stmt.executeUpdate("CREATE DATABASE mysql_test;");
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                if(stmt!=null)
                    stmt.close();
            }catch(SQLException se2){
            }// nothing we can do
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
        }

        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            stmt = conn.createStatement();

            stmt.executeUpdate("CREATE TABLE products (id int NOT NULL AUTO_INCREMENT, name varchar(255), description varchar(255), price decimal(7,2), created_at datetime DEFAULT CURRENT_TIMESTAMP, PRIMARY KEY (id));");
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try{
                if(stmt!=null)
                    stmt.close();
            }catch(SQLException se2){
            }// nothing we can do
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
    }

    public void drop() {
        Connection conn = null;
        Statement stmt = null;
        try{
            //STEP 2: Open a connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            //STEP 3: Create Database
            stmt = conn.createStatement();

            String sql = "DROP DATABASE mysql_test;";

            stmt.executeUpdate(sql);
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                if(stmt!=null)
                    stmt.close();
            }catch(SQLException se2){
            }// nothing we can do
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
    }

    public void insertMockData() {
        Connection conn = null;
        PreparedStatement stmt = null;
        try{
            //STEP 2: Open a connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            StringBuffer sql = new StringBuffer( "insert into products (id, name, description, price) values" );
            sql.append( "(1, 'Product Name 1', 'Description 1', 19.99)," );
            sql.append( "(2, 'Product Name 2', 'Description 2', 29.99)," );
            sql.append( "(3, 'Product Name 3', 'Description 3', 39.99)" );

            //STEP 3: Create Database
            stmt = conn.prepareStatement(sql.toString());

            stmt.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                if(stmt!=null)
                    stmt.close();
            }catch(SQLException se2){
            }// nothing we can do
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
    }

    public void createStoredProcedure() {
        Connection conn = null;
        PreparedStatement stmt = null;
        try{
            //STEP 2: Open a connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            StringBuffer sql = new StringBuffer( "create procedure GetAllProducts() " );
            sql.append( "BEGIN " );
            sql.append( "select * from products; " );
            sql.append( "END" );

            //STEP 3: Create Database
            stmt = conn.prepareStatement(sql.toString());

            stmt.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                if(stmt!=null)
                    stmt.close();
            }catch(SQLException se2){
            }// nothing we can do
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
    }
}
