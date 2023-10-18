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
public class Administrativo {
    
    private DataAccess dataAccess = DataAccess.Instance();
    private int idAdministrativo;
    private String nombre;
    private String apellidoP;
    private String apellidoM;
    private int edad;
    private String departamento;

    public Administrativo() {
    }

    public Administrativo(int idAdministrativo, String nombre, String apellidoP, String apellidoM, int edad, String departamento) {
        this.idAdministrativo = idAdministrativo;
        this.nombre = nombre;
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
        this.edad = edad;
        this.departamento = departamento;
    }

    public Administrativo(int idAdministrativo) {
        this.idAdministrativo = idAdministrativo;
    }

    public int getIdAdministrativo() {
        return idAdministrativo;
    }

    public void setIdAdministrativo(int idAdministrativo) {
        this.idAdministrativo = idAdministrativo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoP() {
        return apellidoP;
    }

    public void setApellidoP(String apellidoP) {
        this.apellidoP = apellidoP;
    }

    public String getApellidoM() {
        return apellidoM;
    }

    public void setApellidoM(String apellidoM) {
        this.apellidoM = apellidoM;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }
    
      public DefaultTableModel GetAllModel() {
        String query = "SELECT * FROM Administrativos";
        return dataAccess.Query(query);
    }

    public boolean Add() {
        String query = "INSERT INTO administrativos(nombre, apellidoP, apellidoM, edad, departamento) VALUES('"
                + nombre + "','" + apellidoP + "','" + apellidoM + "', " + edad + " ,'" 
                + departamento + "')";
        return dataAccess.Execute(query) >= 1;
    }

    public void GetById(){
        String query = "SELECT * FROM Administrativos WHERE idAdministrativo = " + idAdministrativo;
        DefaultTableModel res = dataAccess.Query(query);
        idAdministrativo = (int)res.getValueAt(0, 0);
        nombre = (String)res.getValueAt(0, 1);
        apellidoP = (String)res.getValueAt(0, 2);
        apellidoM = (String)res.getValueAt(0, 3);
        edad = (int)res.getValueAt(0, 4);
        departamento = (String)res.getValueAt(0, 5);
    }
    
    public boolean Delete() {
        String query = "DELETE FROM Administrativos WHERE idAdministrativo = " + idAdministrativo;
        return dataAccess.Execute(query) >= 1;
    }

    public boolean Update() {
        String query = "UPDATE Administrativos SET " + 
                "nombre = '" + nombre + "', " + 
                "apellidoP = '" + apellidoP + "', " + 
                "apellidoM = '" + apellidoM + "', " +
                "edad = " + edad + ", " + 
                "departamento = '" + departamento + "'"+
                "WHERE idAdministrativo = " + idAdministrativo;                 
        return dataAccess.Execute(query) >= 1;
    }
}
