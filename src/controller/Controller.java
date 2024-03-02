/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import connection.ConexionMySQL;
import exceptions.NullConnectionException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

/**
 *
 * @author Sebastián Cruz
 */
public class Controller {

// Creamos un objeto de la clase ConexionMySQL
    public ConexionMySQL conexion = new ConexionMySQL();

    // Establecemos la conexión con la base de datos
    public Controller() {
        this.conexion = new ConexionMySQL();

    }

    //This method establishes the connection to database, which is necessary to execute the other methods.
    //If connection is null, throws a NullConnectionException
    public Connection connect() { 
        Connection conn = conexion.conectarMySQL();//Al no estar este dentro de un try with resources sí se ejecuta el metodo .close()? habría que hacer un singleton de conexión?
        if (conn != null) {
            return conn;
        }
        throw new NullConnectionException();
    }

    public void Insert(String manufacturer, String type, float weight, int chainring_size, String color) { //paste: 
        String insertSQL = "INSERT INTO bicycles (manufacturer,type,weight,chainring_size,color) VALUES (?,?,?,?,?)";
        try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(insertSQL)) {
            pstmt.setString(1, manufacturer);
            pstmt.setString(2, type);
            pstmt.setFloat(3, weight);
            pstmt.setInt(4, chainring_size);
            pstmt.setString(5, color);

            int rowsAffected = pstmt.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Successful insertion");
            } else {
                System.out.println("No insertion was made");
            }
        } catch (SQLException | NullConnectionException e) {
            System.out.println("An error occurred while connecting to database for data insertion");
            e.printStackTrace();
        }
    }

    public void select() {
        String selectSQL = "SELECT * FROM bicycles";
        try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(selectSQL)) {
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                System.out.println("Id: " + rs.getInt("id") + ", manufacturer: " + rs.getString("manufacturer") + ", type: " + rs.getString("type") + ", weight: " + rs.getFloat("weight") + ", chainring_size: " + rs.getInt("chainring_size") + " color: " + rs.getString("color"));
            }

        } catch (SQLException | NullConnectionException e) {
            System.out.println("An error occurred while connecting to database for selection");
            e.printStackTrace();
        }
    }
}
