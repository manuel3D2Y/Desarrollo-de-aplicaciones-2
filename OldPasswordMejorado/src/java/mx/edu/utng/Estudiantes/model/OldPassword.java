/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.utng.Estudiantes.model;

/**
 *
 * @author MAnuel
 */
public class OldPassword {
    private int idPassword;
    private String password;
    private int changed;

    public OldPassword() {
        this(0,"",0);
    }

    public OldPassword(int idPassword, String password, int changed) {
        this.idPassword = idPassword;
        this.password = password;
        this.changed = changed;
    }

    
    public int getIdPassword() {
        return idPassword;
    }

    public void setIdPassword(int idPassword) {
        this.idPassword = idPassword;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getChanged() {
        return changed;
    }

    public void setChanged (int changed) {
        this.changed = changed;
    }

    @Override
    public String toString() {
        return "OldPassword{" + "idPassword=" + idPassword + ", password=" + password + ", changed=" + changed + '}';
    }

    
    
}
