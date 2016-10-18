package mx.edu.utng.tacho.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tbl_modulo")
public class Modulo implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idModulo")
	private Long idModulo;
	@Column(length=30)
	private String nombre;
	@Column(length=50)
	private String ruta;
	private Boolean activo;
	
	public Modulo() {
		idModulo = 0L;
	}

	/**
	 * @return the idModulo
	 */
	public Long getIdModulo() {
		return idModulo;
	}

	/**
	 * @param idModulo the idModulo to set
	 */
	public void setIdModulo(Long idModulo) {
		this.idModulo = idModulo;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the ruta
	 */
	public String getRuta() {
		return ruta;
	}

	/**
	 * @param ruta the ruta to set
	 */
	public void setRuta(String ruta) {
		this.ruta = ruta;
	}

	/**
	 * @return the activo
	 */
	public Boolean getActivo() {
		return activo;
	}

	/**
	 * @param activo the activo to set
	 */
	public void setActivo(Boolean activo) {
		this.activo = activo;
	}
	
}
