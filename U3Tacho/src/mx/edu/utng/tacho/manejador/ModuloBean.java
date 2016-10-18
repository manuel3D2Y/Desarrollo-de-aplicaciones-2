package mx.edu.utng.tacho.manejador;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import mx.edu.utng.tacho.datos.ModuloDAO;
import mx.edu.utng.tacho.modelo.Modulo;

@ManagedBean
@SessionScoped
public class ModuloBean implements Serializable {

	private List<Modulo> modulos;
	private Modulo modulo;

	

	/**
	 * @return the modulos
	 */
	public List<Modulo> getModulos() {
		return modulos;
	}

	/**
	 * @param modulos the modulos to set
	 */
	public void setModulos(List<Modulo> modulos) {
		this.modulos = modulos;
	}

	/**
	 * @return the modulo
	 */
	public Modulo getModulo() {
		return modulo;
	}

	/**
	 * @param modulo the modulo to set
	 */
	public void setModulo(Modulo modulo) {
		this.modulo = modulo;
	}
	

	public String listar() {
		ModuloDAO dao = new ModuloDAO();
		try {
			modulos = dao.getAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Modulos";
	}

	public String eliminar() {
		ModuloDAO dao = new ModuloDAO();
		try {
			dao.delete(modulo);
			modulos = dao.getAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Eliminar";
	}

	public String agregar() {
		modulo = new Modulo();
		return "Agregar";
	}

	public String guardar() {
		ModuloDAO dao = new ModuloDAO();
		try {
			if (modulo.getIdModulo() != 0) {
				dao.update(modulo);
			} else {
				dao.insert(modulo);
			}
			modulos = dao.getAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Guardar";
	}

	public String cancelar() {
		return "Cancelar";
	}

	public String editar(Modulo modulo) {
		this.modulo = modulo;
		return "Editar";
	}
}
