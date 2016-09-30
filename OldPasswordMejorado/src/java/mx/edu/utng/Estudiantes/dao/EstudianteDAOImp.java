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
import mx.edu.utng.Estudiantes.model.Estudiante;
import mx.edu.utng.Estudiantes.util.UtilDB;
/**
 *
 * @author Irbing
 */
import mx.edu.utng.Estudiantes.util.UtilDB;
public class EstudianteDAOImp implements EstudianteDAO{

    private Connection connection;
    
    public EstudianteDAOImp(){
        connection = UtilDB.getConnection();
    }
    
    @Override
    public void agregarEstudiante(Estudiante estudiante) {
        try{
            String query = "INSERT INTO estudiantes(nombre, apellidos, curso,"
                    + " anio) VALUES (?,?,?,?)";
            PreparedStatement ps = connection.prepareCall(query);
            ps.setString(1, estudiante.getNombre());
            ps.setString(2, estudiante.getApellidos());
            ps.setString(3, estudiante.getCurso());
            ps.setInt(4, estudiante.getAnio());
            ps.executeUpdate();
            ps.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    @Override
    public void borrarEstudiante(int idEstudiante) {
        try{
            String query = "DELETE FROM estudiantes WHERE id_estudiante = ?";
            PreparedStatement ps = connection.prepareCall(query);
            ps.setInt(1, idEstudiante);
            ps.executeUpdate();
            ps.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void cambiarEstudiante(Estudiante estudiante) {
        try{
            String query = "UPDATE estudiantes SET nombre = ?, apellidos = ?, curso = ?, anio = ?"
                    + " WHERE id_estudiante = ?";
            PreparedStatement ps = connection.prepareCall(query);
            ps.setString(1, estudiante.getNombre());
            ps.setString(2, estudiante.getApellidos());
            ps.setString(3, estudiante.getCurso());
            ps.setInt(4, estudiante.getAnio());
            ps.setInt(5, estudiante.getIdEstudiante());
            ps.executeUpdate();
            ps.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public List<Estudiante> desplegarEstudiantes() {
        List<Estudiante> estudiantes = new ArrayList<Estudiante>();
        try{
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM estudiantes");
            while (resultSet.next()) {
                Estudiante estudiante = new Estudiante(
                resultSet.getInt("id_estudiante"), 
                resultSet.getString("nombre"),
                resultSet.getString("apellidos"),
                resultSet.getString("curso"),
                resultSet.getInt("anio"));
                estudiantes.add(estudiante); //a la lista se le agregan los estudiantes que se le acaban de agregar datos
            }
            resultSet.close();
            statement.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return estudiantes;
    }

    @Override
    public Estudiante elegirEstudiante(int idEstudiante) {
        Estudiante estudiante = new Estudiante();
        try{
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM estudiantes"
                + " WHERE id_estudiante = ?");
        statement.setInt(1, idEstudiante);
        
        ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                estudiante.setIdEstudiante(resultSet.getInt("id_estudiante")); 
                estudiante.setNombre(resultSet.getString("nombre"));
                estudiante.setApellidos(resultSet.getString("apellidos"));
                estudiante.setCurso(resultSet.getString("curso"));
                estudiante.setAnio(resultSet.getInt("anio"));
            }
            resultSet.close();
            statement.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return estudiante;
    }
}
