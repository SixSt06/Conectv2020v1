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
public class Clase {
    
    private DataAccess dataAccess = DataAccess.Instance(); 
    private int idClase;
    private String materia;
    private String salon;
    private String profesor;
    private int duracion;

    public Clase() {
    }

    public Clase(int idClase, String materia, String salon, String profesor, int duracion) {
        this.idClase = idClase;
        this.materia = materia;
        this.salon = salon;
        this.profesor = profesor;
        this.duracion = duracion;
    }

    public Clase(int idClase) {
        this.idClase = idClase;
    }

    public int getIdClase() {
        return idClase;
    }

    public void setIdClase(int idClase) {
        this.idClase = idClase;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public String getSalon() {
        return salon;
    }

    public void setSalon(String salon) {
        this.salon = salon;
    }

    public String getProfesor() {
        return profesor;
    }

    public void setProfesor(String profesor) {
        this.profesor = profesor;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }
    
    public DefaultTableModel GetAllModel() {
        String query = "SELECT * FROM Clases";
        return dataAccess.Query(query);
    }

    public boolean Add() {
        String query = "INSERT INTO clases(materia, salon, profesor, duracion) VALUES('"
                + materia + "','" + salon + "','" + profesor +"'," + duracion + ")";
        return dataAccess.Execute(query) >= 1;
    }

    public void GetById(){
        String query = "SELECT * FROM Clases WHERE idClase = " + idClase;
        DefaultTableModel res = dataAccess.Query(query);
        idClase = (int)res.getValueAt(0, 0);
        materia = (String)res.getValueAt(0, 1);
        salon = (String)res.getValueAt(0, 2);
        profesor = (String)res.getValueAt(0, 3);
        duracion = (int)res.getValueAt(0, 4);
    }
    
    public boolean Delete() {
        String query = "DELETE FROM Clases WHERE idClase = " + idClase;
        return dataAccess.Execute(query) >= 1;
    }

    public boolean Update() {
        String query = "UPDATE Clases SET " + 
                "materia = '" + materia + "', " + 
                "salon = '" + salon + "', " + 
                "profesor = '" + profesor + "', " +
                "duracion = " + duracion + " " + 
                "WHERE idClase = " + idClase;                 
        return dataAccess.Execute(query) >= 1;
    }
}
