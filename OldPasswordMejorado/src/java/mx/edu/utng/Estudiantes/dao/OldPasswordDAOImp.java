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
            String query = "INSERT INTO old_passwords( password, changed) VALUES (?,?)";
            PreparedStatement ps = connection.prepareCall(query);
            ps.setString(1, oldPassword.getPassword());
            ps.setInt(2, oldPassword.getChanged());
            ps.executeUpdate();
            ps.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    @Override
    public void borrarOldPassword(int idPassword) {
        try{
            String query = "DELETE FROM old_passwords WHERE id_password = ?";
            PreparedStatement ps = connection.prepareCall(query);
            ps.setInt(1, idPassword);
            ps.executeUpdate();
            ps.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void cambiarOldPassword(OldPassword oldPassword) {
        try{
            String query = "UPDATE old_passwords SET password = ?, changed = ? WHERE id_password = ?";
            PreparedStatement ps = connection.prepareCall(query);
            ps.setString(1, oldPassword.getPassword());
            ps.setInt(2, oldPassword.getChanged());
            ps.setInt(3, oldPassword.getIdPassword());
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
                resultSet.getInt("id_password"), 
                resultSet.getString("password"),
                resultSet.getInt("changed"));
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
    public OldPassword elegirOldPassword(int idPassword) {
        OldPassword oldPassword = new OldPassword();
        try{
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM old_passwords WHERE id_password = ?");
        statement.setInt(1, idPassword);
        
        ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                oldPassword.setIdPassword(resultSet.getInt("id_password")); 
                oldPassword.setPassword(resultSet.getString("password"));
                oldPassword.setChanged(resultSet.getInt("changed"));
            }
            resultSet.close();
            statement.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return oldPassword;
    }
}
