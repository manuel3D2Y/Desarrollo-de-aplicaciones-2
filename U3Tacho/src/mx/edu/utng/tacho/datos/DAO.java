package mx.edu.utng.tacho.datos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import mx.edu.utng.tacho.configuracion.HibernateUtil;

public  abstract class DAO<T> {
	
	protected Session session;
	protected T modelo;
	
	public DAO(T modelo) {
		this.modelo = modelo;
		session = HibernateUtil.getSession();
	}
	
	public Long insert(T modelo) throws HibernateException{
		long id = 0;
		Transaction tx = session.beginTransaction();
		try {
			Serializable result = session.save(modelo);
			id = (Long) result;
			tx.commit();
			session.clear();
		} catch (HibernateException e) {
			tx.rollback();
			session.clear();
			throw e;
		}
		return id;
	}
	
	public void update(T modelo) throws HibernateException{
		Transaction tx = session.beginTransaction();
		try {
			session.merge(modelo);
			tx.commit();
			session.clear();
		} catch (HibernateException e) {
			tx.rollback();
			session.clear();
			throw e;
		}
	}
	
	public void delete(T modelo) throws HibernateException{
		Transaction tx = session.beginTransaction();
		try {
			session.delete(modelo);
			tx.commit();
			session.clear();
		} catch (HibernateException e) {
			tx.rollback();
			session.clear();
			throw e;
		}
	}
	
	public List<T> getAll() throws HibernateException{
		String entityName = modelo.getClass().getName();
		List<T> objects = new ArrayList<T>();
		try {
			objects = session.createQuery("FROM " + entityName).list();
		} catch (HibernateException e) {
			session.clear();
			throw new HibernateException("Error Al Consultar La Lista" + e.getMessage());
		}
		return objects;
	}
	
	protected T getOneById(Serializable id) throws HibernateException{
		T object = null;
		if (id instanceof String) {
			object = (T) session.get(modelo.getClass(), Long.valueOf(id.toString()));
		} else {
			object = (T) session.get(modelo.getClass(), Long.valueOf(id.toString()));
		}
		session.clear();
		return object;
	}
	
	protected T query(String sql, List<String> paramNames, List<Object> paramValues){
		Query query = session.createQuery(sql);
		for (int i = 0; i < paramNames.size(); i++) {
			query.setParameter(paramNames.get(i), paramValues.get(i));
		}
		List<T> objects = query.list();
		if (objects.size() > 0) {
			return objects.get(0);
		} else {
			return null;
		}
	}
	
	protected List<T> queryList(String sql, List<String> paramNames, List<Object> paramValues){
		SQLQuery query = session.createSQLQuery(sql);
		query.addEntity(modelo.getClass());
		for (int i = 0; i < paramNames.size(); i++) {
			query.setParameter(paramNames.get(i), paramValues.get(i));
		}
		List<T> objects = query.list();
		if (objects.size() > 0) {
			return objects;
		} else {
			return null;
		}
	}
}