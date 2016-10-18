package mx.edu.utng.tacho.manejador;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import mx.edu.utng.tacho.datos.ContadorDAO;

import mx.edu.utng.tacho.modelo.Contador;



@ManagedBean
@SessionScoped
public class ContadorBean implements Serializable {

	private List<Contador> contadores;
	private Contador contador;
	

	public String listar() {
		ContadorDAO dao = new ContadorDAO();
		try {
			contadores = dao.getAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Contadores";
	}

	public String eliminar() {
		ContadorDAO dao = new ContadorDAO();
		try {
			dao.delete(contador);
			contadores = dao.getAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Eliminar";
	}
	
	public String agregar(){
		contador = new Contador();	
		return "Agregar";
	}

	public String guardar() {
		ContadorDAO dao = new ContadorDAO();
		try {
			if (contador.getId() != 0) {
				dao.update(contador);
			} else {
				dao.insert(contador);
			}
			contadores = dao.getAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Guardar";
	}

	public String cancelar() {
		return "Cancelar";
	}

	public String editar(Contador contador){
		this.contador = contador;
		return "Editar";
	}

	public List<Contador> getContadores() {
		return contadores;
	}

	public void setContadores(List<Contador> contadores) {
		this.contadores = contadores;
	}

	public Contador getContador() {
		return contador;
	}

	public void setContador(Contador contador) {
		this.contador = contador;
	}

	
	
	
	
}
