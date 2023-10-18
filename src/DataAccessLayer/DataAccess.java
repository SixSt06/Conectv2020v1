/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccessLayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author sixst
 */
public class DataAccess {

    private static DataAccess instance = null;
    private Connection con = null;
    private Statement statement;
    private ResultSet resultSet;

    private DataAccess() {
        //Solo se ejecuta una vez
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
        } catch (Exception e) {
        }
    }

    public static DataAccess Instance() {
        if (instance == null) {
            instance = new DataAccess();
        }
        return instance;
    }
    //DataAccess obj2 = new DataAccess.Instance();

    private void ConectarDB(){
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/aoddbr", "root", "F6651d11c4@");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, " Error en la conexion " + e.getMessage());
        }
    }

    private void DesconectarDB(){
        try {
            con.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, " Error en la desconexion " + e.getMessage());
        }
    }

    //Select
    public DefaultTableModel Query(String query) {
        try {
            ConectarDB();
            statement = con.createStatement();
            resultSet = statement.executeQuery(query);
            Vector<String> columnNames = new Vector<String>();
            int columnCount = resultSet.getMetaData().getColumnCount();
            for (int column = 1; column <= columnCount; column++) {
                columnNames.add(resultSet.getMetaData().getColumnName(column));
            }
            Vector<Vector<Object>> data = new Vector<Vector<Object>>();
            while (resultSet.next()) {
                Vector<Object> vector = new Vector<Object>();
                for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                    vector.add(resultSet.getObject(columnIndex));
                }
                data.add(vector);
            }
            return new DefaultTableModel(data, columnNames);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en la build " + e.getMessage());
            return null;
        }
        finally{
            DesconectarDB();
        }
    }

    //Update, insert, delete
    public int Execute(String query) {
        try {
            ConectarDB();
            statement = con.createStatement();
            return statement.executeUpdate(query);
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en la consulta: " + e.getMessage());
            return 0;
        }
        finally{
            DesconectarDB();
        }
    }
}
