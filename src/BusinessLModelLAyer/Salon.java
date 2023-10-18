/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLModelLAyer;

import DataAccessLayer.DataAccess;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author sixst
 */
public class Salon {
    private DataAccess dataAccess = DataAccess.Instance();
    private int idSalon;
    private String nombre;
    private String ubicacion;
    private int cantidadMax;
    private String canon;
    private String pintarron;
    private String ventanas;

    public Salon() {
    }

    public Salon(int idSalon, String nombre, String ubicacion, int cantidadMax, String canon, String pintarron, String ventanas) {
        this.idSalon = idSalon;
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.cantidadMax = cantidadMax;
        this.canon = canon;
        this.pintarron = pintarron;
        this.ventanas = ventanas;
    }

    public Salon(int idSalon) {
        this.idSalon = idSalon;
    }

    public int getIdSalon() {
        return idSalon;
    }

    public void setIdSalon(int idSalon) {
        this.idSalon = idSalon;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public int getCantidadMax() {
        return cantidadMax;
    }

    public void setCantidadMax(int cantidadMax) {
        this.cantidadMax = cantidadMax;
    }

    public String getCanon() {
        return canon;
    }

    public void setCanon(String canon) {
        this.canon = canon;
    }

    public String getPintarron() {
        return pintarron;
    }

    public void setPintarron(String pintarron) {
        this.pintarron = pintarron;
    }

    public String getVentanas() {
        return ventanas;
    }

    public void setVentanas(String ventanas) {
        this.ventanas = ventanas;
    }

    
    public DefaultTableModel GetAllModel(){
        String query = "SELECT * FROM Salones";
        return dataAccess.Query(query);
    }
    
    public boolean Add() {
        String query = "INSERT INTO salones(nombre, ubicacion, cantidadMax, "
                + "canon, pintarron, ventanas) VALUES('"
                + nombre + "','" + ubicacion + "'," + cantidadMax +",'" + canon
                + "','" + pintarron + "','" + ventanas + "')";
        return dataAccess.Execute(query) >= 1;
    }

    public void GetById(){
        String query = "SELECT * FROM salones WHERE idSalon = " + idSalon;
        DefaultTableModel res = dataAccess.Query(query);
        idSalon = (int)res.getValueAt(0, 0);
        nombre = (String)res.getValueAt(0, 1);
        ubicacion = (String)res.getValueAt(0, 2);
        cantidadMax = (int)res.getValueAt(0, 3);
        canon = (String)res.getValueAt(0, 4);
        pintarron = (String)res.getValueAt(0, 5);
        ventanas = (String)res.getValueAt(0, 6);
        
    }
    
    public boolean Delete() {
        String query = "DELETE FROM Salones WHERE idSalon = " + idSalon;
        return dataAccess.Execute(query) >= 1;
    }

    public boolean Update() {
        String query = "UPDATE Salones SET " + 
                "nombre = '" + nombre + "', " + 
                "ubicacion = '" + ubicacion + "', " + 
                "cantidadMax = " + cantidadMax + ", " +
                "canon = '" + canon + "', " + 
                "pintarron = '" + pintarron + "', "+
                "ventanas = '" + ventanas + "'" +
                "WHERE idSalon = " + idSalon;                 
        return dataAccess.Execute(query) >= 1;
    }
}
