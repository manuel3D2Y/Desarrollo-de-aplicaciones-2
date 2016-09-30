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
    private int idP_uuid;
    private String password;
    private int changed_timestamp;

    public OldPassword() {
        this(0,"",0);
    }

    public OldPassword(int idP_uuid, String password, int changed_timestamp) {
        this.idP_uuid = idP_uuid;
        this.password = password;
        this.changed_timestamp = changed_timestamp;
    }

    
    public int getIdP_uuid() {
        return idP_uuid;
    }

    public void setIdP_uuid(int idP_uuid) {
        this.idP_uuid = idP_uuid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getChanged_timestamp() {
        return changed_timestamp;
    }

    public void setChanged_timestamp(int changed_timestamp) {
        this.changed_timestamp = changed_timestamp;
    }

    @Override
    public String toString() {
        return "OldPassword{" + "idP_uuid=" + idP_uuid + ", password=" + password + ", changed_timestamp=" + changed_timestamp + '}';
    }

    
    
}
