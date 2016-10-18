package mx.edu.utng.tacho.datos;

import java.io.Serializable;
import org.hibernate.HibernateException;

import mx.edu.utng.tacho.modelo.Contador;


public class ContadorDAO extends DAO<Contador> {

	public ContadorDAO() {
		super(new Contador());	
	}
	
	public Contador getOneById(Contador contador) throws HibernateException {
		return super.getOneById(contador.getId());
	}
}
