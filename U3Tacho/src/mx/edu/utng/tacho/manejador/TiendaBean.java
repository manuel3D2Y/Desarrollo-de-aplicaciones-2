package mx.edu.utng.tacho.manejador;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import mx.edu.utng.tacho.datos.TiendaDAO;
import mx.edu.utng.tacho.datos.ContadorDAO;
import mx.edu.utng.tacho.modelo.Tienda;
import mx.edu.utng.tacho.modelo.Contador;



@ManagedBean
@SessionScoped
public class TiendaBean implements Serializable {
	
	private List<Tienda> tiendas;
	private Tienda tienda;
	private List<Contador> contadores;
	
	
	public TiendaBean() {
		tienda = new Tienda(); 
	}


	public String listar(){
		TiendaDAO dao = new TiendaDAO();
		try {
			tiendas = dao.getAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Tiendas";
	}
	
	public String eliminar(){
		TiendaDAO dao = new TiendaDAO();
		try {
			dao.delete(tienda);
			tiendas = dao.getAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Eliminar";
	}
	
	public String agregar(){
		tienda = new Tienda();
		tienda.setContador(new Contador());
		try{
			contadores = new ContadorDAO().getAll();
		} catch (Exception e){
			e.printStackTrace();
		}
		return "Agregar";
	}
	
	public String guardar(){
		TiendaDAO dao = new TiendaDAO();
		try {
			if (tienda.getId() != 0) {
				dao.update(tienda);
			} else {
				dao.insert(tienda);
			}
			tiendas = dao.getAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Guardar";
	}
	
	public String cancelar(){
		return "Cancelar";
	}
	
	public String editar(Tienda tienda){
		this.tienda = tienda;
		try{
			contadores = new ContadorDAO().getAll();
		} catch (Exception e){
			e.printStackTrace();
		}
		return "Editar";
	}


	public List<Tienda> getTiendas() {
		return tiendas;
	}


	public void setTiendas(List<Tienda> tiendas) {
		this.tiendas = tiendas;
	}


	public Tienda getTienda() {
		return tienda;
	}


	public void setTienda(Tienda tienda) {
		this.tienda = tienda;
	}


	public List<Contador> getContadores() {
		return contadores;
	}


	public void setContadores(List<Contador> contadores) {
		this.contadores = contadores;
	}





	
}