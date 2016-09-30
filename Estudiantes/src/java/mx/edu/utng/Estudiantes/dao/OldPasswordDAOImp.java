/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.utng.Estudiantes.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import mx.edu.utng.Estudiantes.model.OldPassword;
/**
 *
 * @author Irbing
 */
import mx.edu.utng.Estudiantes.util.UtilDB;
public class OldPasswordDAOImp implements OldPasswordDAO{

    private Connection connection;
    
    public OldPasswordDAOImp(){
        connection = UtilDB.getConnection();
    }
    
    @Override
    public void agregarOldPassword(OldPassword oldPassword) {
        try{
            String query = "INSERT INTO old_passwords( password, changed_timestamp) VALUES (?,?)";
            PreparedStatement ps = connection.prepareCall(query);
            ps.setString(1, oldPassword.getPassword());
            ps.setInt(2, oldPassword.getChanged_timestamp());
            ps.executeUpdate();
            ps.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    @Override
    public void borrarOldPassword(int id_oldPassword) {
        try{
            String query = "DELETE FROM old_passwords WHERE id_p_uuid = ?";
            PreparedStatement ps = connection.prepareCall(query);
            ps.setInt(1, id_oldPassword);
            ps.executeUpdate();
            ps.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void cambiarOldPassword(OldPassword oldPassword) {
        try{
            String query = "UPDATE old_passwords SET password = ?, changed_timestamp = ? WHERE id_p_uuid = ?";
            PreparedStatement ps = connection.prepareCall(query);
            ps.setString(1, oldPassword.getPassword());
            ps.setInt(2, oldPassword.getChanged_timestamp());
            ps.setInt(3, oldPassword.getIdP_uuid());
            ps.executeUpdate();
            ps.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public List<OldPassword> desplegarOldPasswords() {
        List<OldPassword> oldPasswords = new ArrayList<OldPassword>();
        try{
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM old_passwords");
            while (resultSet.next()) {
                OldPassword oldPassword = new OldPassword(
                resultSet.getInt("id_p_uuid"), 
                resultSet.getString("password"),
                resultSet.getInt("changed_timestamp"));
                oldPasswords.add(oldPassword); //a la lista se le agregan los estudiantes que se le acaban de agregar datos
            }
            resultSet.close();
            statement.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return oldPasswords;
    }

    @Override
    public OldPassword elegirOldPassword(int idP_uuid) {
        OldPassword oldPassword = new OldPassword();
        try{
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM old_passwords WHERE id_p_uuid = ?");
        statement.setInt(1, idP_uuid);
        
        ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                oldPassword.setIdP_uuid(resultSet.getInt("id_p_uuid")); 
                oldPassword.setPassword(resultSet.getString("password"));
                oldPassword.setChanged_timestamp(resultSet.getInt("changed_timestamp"));
            }
            resultSet.close();
            statement.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return oldPassword;
    }
}
