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
public class Usuario {

    private DataAccess dataAccess = DataAccess.Instance();
    private int idUsuario;
    private String nombre;
    private String usuario;
    private String password;

    public Usuario() {
    }

    public Usuario(String usuario, String password) {
        this.usuario = usuario;
        this.password = password;
    }

    public Usuario(int idUsuario, String nombre, String usuario, String password) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.usuario = usuario;
        this.password = password;
    }

    public DataAccess getDataAccess() {
        return dataAccess;
    }

    public void setDataAccess(DataAccess dataAccess) {
        this.dataAccess = dataAccess;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Usuario Login() {
        String query = "SELECT * FROM usuarios WHERE usuario = '" + usuario + "' AND "
                + "password = '" + password + "'";
        DefaultTableModel res = dataAccess.Query(query);
        if (res.getRowCount() > 0) {
            Usuario obj = new Usuario();
            obj.setIdUsuario((int) res.getValueAt(0, 0));
            obj.setNombre((String) res.getValueAt(0, 1));
            obj.setUsuario((String) res.getValueAt(0, 2));
            obj.setPassword((String) res.getValueAt(0, 3));
            return obj;
        } else {
            return null;
        }
    }

}
