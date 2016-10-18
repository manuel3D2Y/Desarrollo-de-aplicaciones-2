package mx.edu.utng.tacho.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity @Table(name="tbl_tienda")
public class Tienda {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_tienda")
	private Long id;
	
	private String nombre;
	
	private String estado;
	
	private String pais;
	
	@Column(name = "codigo_postal")
	private int codigoPostal;

	
	
	
	@ManyToOne
	@JoinColumn(name="id_contador")
	private Contador contador;
	
	public Tienda() {
		id = 0L;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	




	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getEstado() {
		return estado;
	}


	public void setEstado(String estado) {
		this.estado = estado;
	}


	public String getPais() {
		return pais;
	}


	public void setPais(String pais) {
		this.pais = pais;
	}

	public int getCodigoPostal() {
		return codigoPostal;
	}


	public void setCodigoPostal(int codigoPostal) {
		this.codigoPostal = codigoPostal;
	}


	public Contador getContador() {
		return contador;
	}


	public void setContador(Contador contador) {
		this.contador = contador;
	}

}

