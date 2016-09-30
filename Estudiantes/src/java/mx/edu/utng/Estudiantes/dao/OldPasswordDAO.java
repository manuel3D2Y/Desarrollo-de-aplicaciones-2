
package mx.edu.utng.Estudiantes.dao;

import java.util.List;
import mx.edu.utng.Estudiantes.model.OldPassword;
/**
 *
 * @author Manuel
 */
public interface OldPasswordDAO {
    void agregarOldPassword (OldPassword oldPassword);
    void borrarOldPassword (int idOldPassword);
    void cambiarOldPassword (OldPassword oldPassword);
    List<OldPassword> desplegarOldPasswords();
    OldPassword elegirOldPassword (int idOldPassword);
    
}
