package mx.edu.utng.tacho.datos;

import java.io.Serializable;
import org.hibernate.HibernateException;
import mx.edu.utng.tacho.modelo.Rol;

public class RolDAO extends DAO<Rol> {

	public RolDAO() {
		super(new Rol());	
	}
	
	public Rol getOneById(Rol rol) throws HibernateException {
		return super.getOneById(rol.getIdRol());
	}
}
