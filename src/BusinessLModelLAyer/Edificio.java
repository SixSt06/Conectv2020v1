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
public class Edificio {

    private DataAccess dataAccess = DataAccess.Instance();
    private int idEdificio;
    private int noSalones;
    private String ubicacion;
    private int pisos;

    public Edificio() {
    }

    public Edificio(int idEdificio, int noSalones, String ubicacion, int pisos) {
        this.idEdificio = idEdificio;
        this.noSalones = noSalones;
        this.ubicacion = ubicacion;
        this.pisos = pisos;
    }

    public Edificio(int idEdificio) {
        this.idEdificio = idEdificio;
    }

    public int getIdEdificio() {
        return idEdificio;
    }

    public void setIdEdificio(int idEdificio) {
        this.idEdificio = idEdificio;
    }

    public int getNoSalones() {
        return noSalones;
    }

    public void setNoSalones(int noSalones) {
        this.noSalones = noSalones;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public int getPisos() {
        return pisos;
    }

    public void setPisos(int pisos) {
        this.pisos = pisos;
    }
    
    public DefaultTableModel GetAllModel() {
        String query = "SELECT * FROM Edificios";
        return dataAccess.Query(query);
    }

    public boolean Add() {
        String query = "INSERT INTO edificios(noSalones, ubicacion,pisos) VALUES("
                + noSalones + ",'" + ubicacion + "'," + pisos +")";
        return dataAccess.Execute(query) >= 1;
    }

    public void GetById(){
        String query = "SELECT * FROM Edificios WHERE idEdificio = " + idEdificio;
        DefaultTableModel res = dataAccess.Query(query);
        idEdificio = (int)res.getValueAt(0, 0);
        noSalones = (int)res.getValueAt(0, 1);
        ubicacion = (String)res.getValueAt(0, 2);
        pisos = (int)res.getValueAt(0, 3);
    }
    
    public boolean Delete() {
        String query = "DELETE FROM Edificios WHERE idEdificio = " + idEdificio;
        return dataAccess.Execute(query) >= 1;
    }

    public boolean Update() {
        String query = "UPDATE Edificios SET " + 
                "noSalones = " + noSalones + ", " + 
                "ubicacion = '" + ubicacion + "', " + 
                "pisos = " + pisos + " " +
                "WHERE idEdificio = " + idEdificio;                 
        return dataAccess.Execute(query) >= 1;
    }
}
