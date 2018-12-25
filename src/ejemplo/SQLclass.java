/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplo;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

/**
 *
 * @author Freddie
 */
public class SQLclass {

    public SQLclass() {
    }
    public Statement conn(){
        try{
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            System.out.println("Connecting to DB ... ");
            Connection connection;
            connection = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:ORCL","HR","hr");
            Statement statement = (Statement) connection.createStatement();
            return statement;
        }catch(SQLException e){
            System.out.println("The exception raised is: "+e);
            return null;
        }
    }
    public LinkedList<String> query(String from){
        try{
            Statement st=conn();
            ResultSet resultSet = st.executeQuery(from);
            LinkedList<String> result = new LinkedList();
            while(resultSet.next()){
                for (int i = 1; i < resultSet.getMetaData().getColumnCount(); i++) {
                    result.add(resultSet.getString(i));
                }
            }
            return result;
        }catch(SQLException e){
            return null;
        }
    }
}
