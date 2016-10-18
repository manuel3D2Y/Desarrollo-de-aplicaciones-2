package mx.edu.utng.tacho.datos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;

import mx.edu.utng.tacho.modelo.Usuario;

public class UsuarioDAO extends DAO<Usuario> {

	public UsuarioDAO() {
		super(new Usuario());	
	}
	
	public Usuario getOneById(Usuario usuario) throws HibernateException {
		return super.getOneById(usuario.getIdUsuario());
	}
	
	public Usuario login(Usuario usuario){
		List<String> paramNames = new ArrayList<String>();
		List<Object> paramValues = new ArrayList<Object>();
		paramNames.add("nombre");
		paramNames.add("clave");
		paramValues.add(usuario.getNombre());
		paramValues.add(usuario.getClave());
		usuario = query("FROM " + modelo.getClass().getName() + 
				" WHERE nombre =:nombre and clave =:clave", paramNames, paramValues);
		return usuario;
	}
	
}
