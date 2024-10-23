package entidad;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "SOCIOS", catalog = "ejercicio2")
public class Socio implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "ID_SOCIO", unique = true, nullable = false)
	private int id_socio;
	@Column(name = "APELLIDOs")
	private String apellidos;
	@Column(name = "NOMBRE")
	private String nombre;
	
	public Socio() {
		
	}
	public Socio(int id_socio, String apellidos, String nombre) {
		super();
		this.id_socio = id_socio;
		this.apellidos = apellidos;
		this.nombre = nombre;
	}

	public int getId_socio() {
		return id_socio;
	}
	public void setId_socio(int id_socio) {
		this.id_socio = id_socio;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	
	
}
