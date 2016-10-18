package mx.edu.utng.tacho.datos;

import java.io.Serializable;
import org.hibernate.HibernateException;

import mx.edu.utng.tacho.modelo.Modulo;

public class ModuloDAO extends DAO<Modulo> {

	public ModuloDAO() {
		super(new Modulo());	
	}
	
	public Modulo getOneById(Modulo modulo) throws HibernateException {
		return super.getOneById(modulo.getIdModulo());
	}
}
