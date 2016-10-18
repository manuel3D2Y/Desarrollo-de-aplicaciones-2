package mx.edu.utng.tacho.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity @Table(name="tbl_usuario")
public class Usuario {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_usuario")
	private Long idUsuario;
	@Column(length=10)
	private String nombre;
	@Column(length=40)
	private String clave;
	
	@ManyToOne
	@JoinColumn(name="idRol")
	private Rol rol;
	@ManyToOne
	@JoinColumn(name="idModulo")
	private Modulo modulo;

	public Usuario() {
		idUsuario = 0L;
	}

	/**
	 * @return the idUsuario
	 */
	public Long getIdUsuario() {
		return idUsuario;
	}

	/**
	 * @param idUsuario the idUsuario to set
	 */
	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
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
	 * @return the clave
	 */
	public String getClave() {
		return clave;
	}

	/**
	 * @param clave the clave to set
	 */
	public void setClave(String clave) {
		this.clave = clave;
	}

	/**
	 * @return the rol
	 */
	public Rol getRol() {
		return rol;
	}

	/**
	 * @param rol the rol to set
	 */
	public void setRol(Rol rol) {
		this.rol = rol;
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
	
}

