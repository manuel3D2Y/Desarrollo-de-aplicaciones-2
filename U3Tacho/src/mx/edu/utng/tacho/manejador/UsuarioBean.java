package mx.edu.utng.tacho.manejador;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import mx.edu.utng.tacho.datos.RolDAO;
import mx.edu.utng.tacho.datos.UsuarioDAO;
import mx.edu.utng.tacho.modelo.Rol;
import mx.edu.utng.tacho.modelo.Usuario;

@ManagedBean
@SessionScoped
public class UsuarioBean implements Serializable {
	
	private List<Usuario> usuarios;
	private Usuario usuario;
	private List<Rol> roles;
	
	
	public UsuarioBean() {
		usuario = new Usuario(); 
	}
	
	
	
	/**
	 * @return the usuarios
	 */
	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	/**
	 * @param usuarios the usuarios to set
	 */
	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	/**
	 * @return the usuario
	 */
	public Usuario getUsuario() {
		return usuario;
	}

	/**
	 * @param usuario the usuario to set
	 */
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	/**
	 * @return the roles
	 */
	public List<Rol> getRoles() {
		return roles;
	}

	/**
	 * @param roles the roles to set
	 */
	public void setRoles(List<Rol> roles) {
		this.roles = roles;
	}

	

	public String listar(){
		UsuarioDAO dao = new UsuarioDAO();
		try {
			usuarios = dao.getAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Usuarios";
	}
	
	public String eliminar(){
		UsuarioDAO dao = new UsuarioDAO();
		try {
			dao.delete(usuario);
			usuarios = dao.getAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Eliminar";
	}
	
	public String agregar(){
		usuario = new Usuario();
		usuario.setRol(new Rol());
		try{
			roles = new RolDAO().getAll();
		} catch (Exception e){
			e.printStackTrace();
		}
		return "Agregar";
	}
	
	public String guardar(){
		UsuarioDAO dao = new UsuarioDAO();
		try {
			if (usuario.getIdUsuario() != 0) {
				dao.update(usuario);
			} else {
				dao.insert(usuario);
			}
			usuarios = dao.getAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Guardar";
	}
	
	public String cancelar(){
		return "Cancelar";
	}
	
	public String editar(Usuario usuario){
		this.usuario = usuario;
		try{
			roles = new RolDAO().getAll();
		} catch (Exception e){
			e.printStackTrace();
		}
		return "Editar";
	}
	
	public String login(){
		usuario = new UsuarioDAO().login(usuario);
		if (usuario != null) {
			FacesContext.getCurrentInstance()
			.getExternalContext()
			.getSessionMap().put("usuario", usuario);
			return "Correcto";
		} else {
			usuario = new Usuario();
			return "Incorrecto";
		}
	}
}