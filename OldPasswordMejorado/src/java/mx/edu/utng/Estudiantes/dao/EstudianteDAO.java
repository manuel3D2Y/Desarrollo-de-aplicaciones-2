/*
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.utng.Estudiantes.dao;

import java.util.List;
import mx.edu.utng.Estudiantes.model.Estudiante;
/**
 *
 * @author Irbing
 */
public interface EstudianteDAO {
    void agregarEstudiante (Estudiante estudiante);
    void borrarEstudiante (int idEstudiante);
    void cambiarEstudiante (Estudiante estudiante);
    List<Estudiante> desplegarEstudiantes();
    Estudiante elegirEstudiante (int idEstudiante);
    
}
