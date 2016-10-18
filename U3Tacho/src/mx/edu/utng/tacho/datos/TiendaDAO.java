package mx.edu.utng.tacho.datos;

import org.hibernate.HibernateException;

import mx.edu.utng.tacho.modelo.Tienda;


public class TiendaDAO extends DAO<Tienda> {

	public TiendaDAO() {
		super(new Tienda());	
	}
	
	public Tienda getOneById(Tienda tienda) throws HibernateException {
		return super.getOneById(tienda.getId());
	}
}
